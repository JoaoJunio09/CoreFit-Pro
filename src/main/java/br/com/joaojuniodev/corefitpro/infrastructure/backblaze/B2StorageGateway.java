package br.com.joaojuniodev.corefitpro.infrastructure.backblaze;

import br.com.joaojuniodev.corefitpro.config.B2Properties;
import br.com.joaojuniodev.corefitpro.exceptions.FileStorageException;
import br.com.joaojuniodev.corefitpro.exceptions.ObjectIsNullException;
import br.com.joaojuniodev.corefitpro.infrastructure.backblaze.dto.StoredFileResponse;
import com.backblaze.b2.client.B2StorageClient;
import com.backblaze.b2.client.contentHandlers.B2ContentSink;
import com.backblaze.b2.client.contentSources.B2ByteArrayContentSource;
import com.backblaze.b2.client.contentSources.B2ContentSource;
import com.backblaze.b2.client.contentSources.B2ContentTypes;
import com.backblaze.b2.client.contentSources.B2FileContentSource;
import com.backblaze.b2.client.exceptions.B2Exception;
import com.backblaze.b2.client.structures.B2Bucket;
import com.backblaze.b2.client.structures.B2FileVersion;
import com.backblaze.b2.client.structures.B2UploadFileRequest;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

@Component
public class B2StorageGateway implements IB2Storage {

    private final Logger log = LoggerFactory.getLogger(B2StorageGateway.class.getName());

    private static final long SMALL_FILE_LIMIT = 100L * 1024 * 1024; // aproximadamente 100MB
    private static final Pattern FOLDER_PATTERN = Pattern.compile("^[a-z0-9-]+(/[a-z0-9-]+)*$");
    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(
        "jpg", "jpeg", "png", "webp", "mp4", "webm", "mov", "pdf", "mp3", "wav"
    );

    private final B2StorageClient client;
    private final B2Properties props;
    private final S3Presigner presigner;
    private final ExecutorService uploadExecutor;

    public B2StorageGateway(
        B2StorageClient client,
        B2Properties props,
        S3Presigner presigner,
        @Qualifier("b2UploadExecutor") ExecutorService uploadExecutor
    ) {
        this.client = client;
        this.props = props;
        this.presigner = presigner;
        this.uploadExecutor = uploadExecutor;
    }

    public StoredFileResponse upload(MultipartFile file, String folder) {
        if (file == null || file.isEmpty()) {
            throw new FileStorageException("Empty file");
        }

        final String key = buildKey(folder, file.getOriginalFilename());
        Path tempFile = null;

        try {
            // 1) Copia o stream para um arquivo temporário em disco (memória constante).
            tempFile = Files.createTempFile("b2-upload-", ".tmp");
            try (var in = file.getInputStream()) {
                Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
            }
            final Long size = Files.size(tempFile);

            // 2) Fonte baseada em arquivo: o SDK lê em partes, calcula SHA1 e refaz em caso de retry.
            final B2ContentSource source = B2FileContentSource.builder(tempFile.toFile()).build();

            final B2UploadFileRequest request = B2UploadFileRequest
                .builder(getBucket().getBucketId(), key, B2ContentTypes.B2_AUTO, source)
                .build();

            // 3) Escolhe a estratégia (if/else de verdade: só um upload acontece).
            final B2FileVersion version = size < SMALL_FILE_LIMIT
                ? client.uploadSmallFile(request)
                : client.uploadLargeFile(request, uploadExecutor);

            return new StoredFileResponse(
                version.getFileName(),
                version.getContentType(),
                version.getContentLength(),
                version.getFileId(),
                key
            );
        }
        catch(IOException | B2Exception e) {
            log.error("Failed to upload {}", key, e);
            throw new FileStorageException("Error uploading file");
        }
        finally {
            deleteQuietly(tempFile);
        }
    }

    /** Download por streaming: escreve direto no OutputStream (ex.: resposta HTTP). */
    public void get(String fileId, OutputStream out) {
        try {
            client.downloadById(fileId, (headers, in) -> in.transferTo(out));
        }
        catch (B2Exception e) {
            throw new FileStorageException("Error get/downloading file");
        }
    }

    public void delete(String fileId) {
        try {
            // O B2 exige nome E id para apagar uma versão.
            final B2FileVersion info = client.getFileInfo(fileId);
            client.deleteFileVersion(info.getFileName(), fileId);
        }
        catch (B2Exception e) {
            throw new FileStorageException("Error deleting file");
        }
    }

    public String getTemporaryUrl(String key, Duration validity) {
        GetObjectPresignRequest request = GetObjectPresignRequest.builder()
            .signatureDuration(validity)
            .getObjectRequest(r -> r.bucket(props.getBucketName()).key(key))
            .build();
        return presigner.presignGetObject(request).url().toString();
    }

    public String getFileName(String fileId) {
        try {
            return client.getFileInfo(fileId).getFileName();
        }
        catch (B2Exception e) {
            throw new RuntimeException("Could not get fileName for fileId " + fileId, e);
        }
    }

    public Boolean isImage(MultipartFile file) {
        if (file.isEmpty()) return false;

        String extension = FilenameUtils
            .getExtension(file.getOriginalFilename())
            .toLowerCase(Locale.ROOT);

        if (!ALLOWED_EXTENSIONS.contains(extension)) {
            return false;
        }

        try {
            BufferedImage image = ImageIO.read(file.getInputStream());
            return image != null;
        }
        catch (IOException e) {
            return false;
        }
    }

    private B2Bucket getBucket() throws B2Exception {
        var bucket = client.getBucketOrNullByName(props.getBucketName());
        if (bucket == null) throw new ObjectIsNullException("The Bucket is not exists ou null!");
        return bucket;
    }

    private String buildKey(String folder, String originalName) {
        if (folder == null || !FOLDER_PATTERN.matcher(folder).matches()) {
            throw new FileStorageException("Invalid Folder");
        }
        final String ext = FilenameUtils.getExtension(originalName == null ? "" : originalName).toLowerCase(Locale.ROOT);
        if (!ALLOWED_EXTENSIONS.contains(ext)) {
            throw new FileStorageException("File type not allowed: " + ext);
        }
        return folder + "/" + UUID.randomUUID() + "." + ext;
    }

    private void deleteQuietly(Path path) {
        if (path == null) return;
        try {
            Files.deleteIfExists(path);
        }
        catch (IOException e) {
            log.warn("Could not delete temp file {}", path, e);
        }
    }
}
package br.com.joaojuniodev.corefitpro.infrastructure.backblaze;

import br.com.joaojuniodev.corefitpro.infrastructure.backblaze.dto.StoredFileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;

public interface IB2Storage {

    StoredFileResponse upload(MultipartFile file, String folder);
    void get(String fileId, OutputStream out);
    void delete(String fileId);
}
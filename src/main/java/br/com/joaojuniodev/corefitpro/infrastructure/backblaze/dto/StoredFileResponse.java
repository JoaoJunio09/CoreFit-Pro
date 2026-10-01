package br.com.joaojuniodev.corefitpro.infrastructure.backblaze.dto;

public record StoredFileResponse(
    String fileName,
    String contentType,
    Long size,
    String fileId,
    String fileKey
) {
}
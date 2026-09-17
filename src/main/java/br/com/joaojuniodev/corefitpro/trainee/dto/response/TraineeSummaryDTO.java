package br.com.joaojuniodev.corefitpro.trainee.dto.response;

import java.util.UUID;

public record TraineeSummaryDTO(
    UUID id,
    String firstName,
    String lastName
) {
}
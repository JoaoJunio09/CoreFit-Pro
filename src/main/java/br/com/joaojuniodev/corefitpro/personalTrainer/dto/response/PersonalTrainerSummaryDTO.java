package br.com.joaojuniodev.corefitpro.personalTrainer.dto.response;

import java.util.UUID;

public record PersonalTrainerSummaryDTO(
    UUID id,
    String firstName,
    String lastName
) {}
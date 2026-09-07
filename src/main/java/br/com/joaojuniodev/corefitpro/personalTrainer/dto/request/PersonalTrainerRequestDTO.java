package br.com.joaojuniodev.corefitpro.personalTrainer.dto.request;

import java.util.UUID;

public record PersonalTrainerRequestDTO(
    UUID id,
    String firstName,
    String lastName,
    String username
) {}
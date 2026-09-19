package br.com.joaojuniodev.corefitpro.training.dto.response;

import java.util.UUID;

public record TrainingSummaryDTO(
    UUID id,
    String title,
    String description,
    Long numberOfExercises
) {}
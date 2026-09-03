package br.com.joaojuniodev.corefitpro.exerciseItem.dto.request;

import java.util.UUID;

public record ExerciseItemRequestDTO(
    UUID id,
    Integer repetitions,
    Integer series,
    UUID exerciseId,
    UUID trainingId
) {
}
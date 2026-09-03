package br.com.joaojuniodev.corefitpro.exerciseItem.dto.response;

import br.com.joaojuniodev.corefitpro.exercise.dto.response.ExerciseResponseDTO;

import java.util.UUID;

public record ExerciseItemResponseDTO(
    UUID id,
    ExerciseResponseDTO exercise,
    Integer repetitions,
    Integer series
) {
}
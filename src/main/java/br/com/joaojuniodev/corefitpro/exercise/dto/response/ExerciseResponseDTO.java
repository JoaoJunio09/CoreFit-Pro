package br.com.joaojuniodev.corefitpro.exercise.dto.response;

import java.util.UUID;

public record ExerciseResponseDTO(
    UUID id,
    String name,
    String photo,
    String video
) {
}
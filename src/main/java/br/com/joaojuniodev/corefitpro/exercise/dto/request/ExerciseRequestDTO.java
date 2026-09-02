package br.com.joaojuniodev.corefitpro.exercise.dto.request;

import java.util.UUID;

public record ExerciseRequestDTO(
    UUID id,
    String name,
    String photoUrl,
    String videoUrl
) {
}
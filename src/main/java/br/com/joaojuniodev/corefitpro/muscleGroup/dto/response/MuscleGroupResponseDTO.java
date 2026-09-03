package br.com.joaojuniodev.corefitpro.muscleGroup.dto.response;

import java.util.UUID;

public record MuscleGroupResponseDTO(
    UUID id,
    String name
) {
}
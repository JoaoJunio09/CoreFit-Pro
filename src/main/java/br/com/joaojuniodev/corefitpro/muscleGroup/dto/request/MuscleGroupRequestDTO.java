package br.com.joaojuniodev.corefitpro.muscleGroup.dto.request;

import java.util.UUID;

public record MuscleGroupRequestDTO(
    UUID id,
    String name
) {
}
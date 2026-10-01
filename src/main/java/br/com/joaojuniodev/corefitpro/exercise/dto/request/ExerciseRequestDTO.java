package br.com.joaojuniodev.corefitpro.exercise.dto.request;

import java.util.List;
import java.util.UUID;

public record ExerciseRequestDTO(
    UUID id,
    String name,
    String videoUrl,
    Boolean favorite,
    UUID personalTrainerId,
    List<UUID> muscleGroupsId
) {
}
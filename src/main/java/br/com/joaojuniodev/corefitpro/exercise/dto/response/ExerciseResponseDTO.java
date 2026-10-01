package br.com.joaojuniodev.corefitpro.exercise.dto.response;

import br.com.joaojuniodev.corefitpro.muscleGroup.dto.response.MuscleGroupResponseDTO;

import java.util.List;
import java.util.UUID;

public record ExerciseResponseDTO(
    UUID id,
    String name,
    Boolean system,
    Boolean favorite,
    String photoKey,
    String videoKey,
    String photoFileId,
    String videoFileId,
    List<MuscleGroupResponseDTO> muscleGroups
) {
}
package br.com.joaojuniodev.corefitpro.training.dto.response;

import br.com.joaojuniodev.corefitpro.exerciseItem.dto.response.ExerciseItemResponseDTO;
import br.com.joaojuniodev.corefitpro.muscleGroup.dto.response.MuscleGroupResponseDTO;

import java.util.List;
import java.util.UUID;

public record TrainingResponseDTO(
    UUID id,
    String title,
    String description,
    List<MuscleGroupResponseDTO> muscleGroups,
    List<ExerciseItemResponseDTO> exercises
) {
}
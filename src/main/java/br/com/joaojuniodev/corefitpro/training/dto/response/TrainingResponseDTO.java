package br.com.joaojuniodev.corefitpro.training.dto.response;

import br.com.joaojuniodev.corefitpro.exerciseItem.dto.response.ExerciseItemResponseDTO;
import br.com.joaojuniodev.corefitpro.muscleGroup.dto.response.MuscleGroupResponseDTO;
import br.com.joaojuniodev.corefitpro.training.enums.DaysOfWeek;

import java.util.List;
import java.util.UUID;

public record TrainingResponseDTO(
    UUID id,
    String title,
    String description,
    DaysOfWeek dayOfWeek,
    List<MuscleGroupResponseDTO> muscleGroups,
    List<ExerciseItemResponseDTO> exercises
) {
}
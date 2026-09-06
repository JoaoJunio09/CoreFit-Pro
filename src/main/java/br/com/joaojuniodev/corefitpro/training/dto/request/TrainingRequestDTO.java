package br.com.joaojuniodev.corefitpro.training.dto.request;

import br.com.joaojuniodev.corefitpro.exerciseItem.dto.request.ExerciseItemRequestDTO;
import br.com.joaojuniodev.corefitpro.training.enums.DaysOfWeek;

import java.util.List;
import java.util.UUID;

public record TrainingRequestDTO(
    UUID id,
    String title,
    String description,
    List<UUID> muscleGroupsId,
    List<ExerciseItemRequestDTO> exerciseItems
) {
}
package br.com.joaojuniodev.corefitpro.trainingItem.dto.response;

import br.com.joaojuniodev.corefitpro.training.dto.response.TrainingResponseDTO;
import br.com.joaojuniodev.corefitpro.trainingItem.enums.DaysOfWeek;

import java.util.UUID;

public record TrainingItemResponseDTO(
    UUID id,
    DaysOfWeek dayOfWeek,
    Boolean completed,
    TrainingResponseDTO training
) {}
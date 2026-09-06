package br.com.joaojuniodev.corefitpro.trainingItem.dto.response;

import br.com.joaojuniodev.corefitpro.training.dto.response.TrainingResponseDTO;
import br.com.joaojuniodev.corefitpro.training.enums.DaysOfWeek;

import java.util.UUID;

public record TrainingItemResponseDTO(
    UUID id,
    DaysOfWeek dayOfWeek,
    TrainingResponseDTO training
) {}
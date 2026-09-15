package br.com.joaojuniodev.corefitpro.trainingItem.dto.response;

import br.com.joaojuniodev.corefitpro.training.dto.response.TrainingSummaryDTO;
import br.com.joaojuniodev.corefitpro.trainingItem.enums.DaysOfWeek;

import java.util.UUID;

public record TrainingItemSummaryDTO(
    UUID id,
    DaysOfWeek dayOfWeek,
    Boolean completed,
    TrainingSummaryDTO training
) {}
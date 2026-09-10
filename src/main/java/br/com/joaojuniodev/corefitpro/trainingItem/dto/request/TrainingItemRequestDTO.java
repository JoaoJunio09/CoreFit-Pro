package br.com.joaojuniodev.corefitpro.trainingItem.dto.request;

import br.com.joaojuniodev.corefitpro.trainingItem.enums.DaysOfWeek;

import java.util.UUID;

public record TrainingItemRequestDTO(
    UUID id,
    DaysOfWeek dayOfWeek,
    UUID trainingId,
    UUID trainingPlainId
) {}
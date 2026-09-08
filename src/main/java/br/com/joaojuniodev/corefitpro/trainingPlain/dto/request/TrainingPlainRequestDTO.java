package br.com.joaojuniodev.corefitpro.trainingPlain.dto.request;

import br.com.joaojuniodev.corefitpro.trainingPlain.enums.ObjectiveTraining;

import java.util.UUID;

public record TrainingPlainRequestDTO(
    UUID id,
    String description,
    ObjectiveTraining objective,
    UUID personalTrainerId,
    UUID traineeId
) {}
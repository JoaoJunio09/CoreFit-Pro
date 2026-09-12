package br.com.joaojuniodev.corefitpro.trainingPlain.dto.response;

import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.PersonalTrainerSummaryDTO;
import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeResponseDTO;
import br.com.joaojuniodev.corefitpro.trainingPlain.enums.ObjectiveTraining;

import java.util.UUID;

public record TrainingPlainResponseDTO(
    UUID id,
    PersonalTrainerSummaryDTO personalTrainer,
    TraineeResponseDTO trainee,
    String description,
    Boolean active,
    ObjectiveTraining objective
) {}
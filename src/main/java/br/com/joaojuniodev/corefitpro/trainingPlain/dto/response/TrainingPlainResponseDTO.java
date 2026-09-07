package br.com.joaojuniodev.corefitpro.trainingPlain.dto.response;

import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.PersonalTrainerResponseDTO;
import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeResponseDTO;
import br.com.joaojuniodev.corefitpro.trainingItem.dto.response.TrainingItemResponseDTO;
import br.com.joaojuniodev.corefitpro.trainingPlain.enums.ObjectiveTraining;

import java.util.List;
import java.util.UUID;

public record TrainingPlainResponseDTO(
    UUID id,
    PersonalTrainerResponseDTO personalTrainer,
    TraineeResponseDTO trainee,
    String description,
    ObjectiveTraining objective,
    List<TrainingItemResponseDTO> trainings
) {}
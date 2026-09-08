package br.com.joaojuniodev.corefitpro.personalTrainer.dto.response;

import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeResponseDTO;

import java.util.List;
import java.util.UUID;

public record PersonalTrainerResponseDTO(
    UUID id,
    String firstName,
    String lastName,
    List<TraineeResponseDTO> trainees
    // List<TrainingPlainResponseDTO> trainingPlains,
    // List<TrainingResponseDTO> trainings
) {}
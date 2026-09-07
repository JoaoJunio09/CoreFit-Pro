package br.com.joaojuniodev.corefitpro.trainee.dto.response;

import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.PersonalTrainerSummaryDTO;

import java.util.UUID;

public record TraineeResponseDTO(
    UUID id,
    String firstName,
    String lastName,
    PersonalTrainerSummaryDTO personalTrainer
) {}
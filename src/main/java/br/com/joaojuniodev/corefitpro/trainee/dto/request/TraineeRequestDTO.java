package br.com.joaojuniodev.corefitpro.trainee.dto.request;

import java.util.UUID;

public record TraineeRequestDTO(
    UUID id,
    String firstName,
    String lastName,
    String username,
    UUID personalTrainerId
) {}
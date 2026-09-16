package br.com.joaojuniodev.corefitpro.trainee.dto.response;

import java.util.UUID;

public record TraineeDetailsDTO(
    UUID id,
    String firstName,
    Double weeklyProgressPercentage
) {
}
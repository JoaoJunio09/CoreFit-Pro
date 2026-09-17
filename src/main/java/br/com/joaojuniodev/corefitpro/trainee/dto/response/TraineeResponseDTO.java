package br.com.joaojuniodev.corefitpro.trainee.dto.response;

import java.util.UUID;

public record TraineeResponseDTO(
    UUID id,
    String firstName,
    String lastName,
    Integer age,
    Double weight,
    String objective,
    Boolean active,
    Double weeklyProgressPercentage
) {}
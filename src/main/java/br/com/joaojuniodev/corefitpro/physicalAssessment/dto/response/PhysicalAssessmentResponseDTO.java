package br.com.joaojuniodev.corefitpro.physicalAssessment.dto.response;

import br.com.joaojuniodev.corefitpro.physicalAssessment.enums.ActivityLevel;
import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeSummaryDTO;

import java.time.LocalDate;
import java.util.UUID;

public record PhysicalAssessmentResponseDTO(
    UUID id,
    LocalDate registeredAt,
    Integer age,
    Double weight,
    Double height,
    Double imc,
    Double bodyFat,
    Double fatMass,
    Double muscleMass,
    Double chest,
    Double waist,
    Double abdomen,
    Double hip,
    Double rightArm,
    Double leftArm,
    Double rightThigh,
    Double leftThigh,
    ActivityLevel activityLevel,
    String notes, String frontViewPhotoUrl,
    String backViewPhotoUrl,
    String leftViewPhotoUrl,
    String rightViewPhotoUrl
) {}
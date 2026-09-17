package br.com.joaojuniodev.corefitpro.trainee.dto.response;

import br.com.joaojuniodev.corefitpro.physicalAssessment.dto.response.PhysicalAssessmentResponseDTO;

import java.util.List;

public record TraineeDetailsDTO(
    TraineeResponseDTO trainee,
    List<PhysicalAssessmentResponseDTO> physicalAssessments
) {}
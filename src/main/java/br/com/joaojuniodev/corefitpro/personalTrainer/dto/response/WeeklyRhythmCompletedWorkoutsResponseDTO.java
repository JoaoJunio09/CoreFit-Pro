package br.com.joaojuniodev.corefitpro.personalTrainer.dto.response;

import br.com.joaojuniodev.corefitpro.trainingItem.enums.DaysOfWeek;

public record WeeklyRhythmCompletedWorkoutsResponseDTO(
    DaysOfWeek daysOfWeek,
    Long totalTrainings,
    Long completedTrainings
) {
}
package br.com.joaojuniodev.corefitpro.trainee.dto.response;

import br.com.joaojuniodev.corefitpro.trainingItem.enums.DaysOfWeek;
import br.com.joaojuniodev.corefitpro.trainingItem.enums.TrainingStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TraineeWeeklyTraining(
    UUID trainingItemId,
    DaysOfWeek day,
    Boolean isToday,
    String title,
    String focus,
    LocalDateTime dateTime,
    TrainingStatus status
) {
}
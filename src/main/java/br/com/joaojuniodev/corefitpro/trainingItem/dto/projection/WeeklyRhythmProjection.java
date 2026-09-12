package br.com.joaojuniodev.corefitpro.trainingItem.dto.projection;

import br.com.joaojuniodev.corefitpro.trainingItem.enums.DaysOfWeek;

public interface WeeklyRhythmProjection {
    DaysOfWeek getDayOfWeek();
    Long getTotalTrainings();
    Long getCompletedTrainings();
}
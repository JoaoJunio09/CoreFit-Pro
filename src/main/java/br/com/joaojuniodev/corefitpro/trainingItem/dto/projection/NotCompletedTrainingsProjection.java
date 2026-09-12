package br.com.joaojuniodev.corefitpro.trainingItem.dto.projection;

import java.util.UUID;

public interface NotCompletedTrainingsProjection {
    UUID getId();
    Long getCountIncompleteTraining();
    String getTraineeName();
}
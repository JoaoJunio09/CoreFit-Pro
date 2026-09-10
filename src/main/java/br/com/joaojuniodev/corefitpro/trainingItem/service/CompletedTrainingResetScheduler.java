package br.com.joaojuniodev.corefitpro.trainingItem.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CompletedTrainingResetScheduler {

    private final TrainingItemService trainingItemService;

    public CompletedTrainingResetScheduler(TrainingItemService trainingItemService) {
        this.trainingItemService = trainingItemService;
    }

    @Scheduled(cron = "0 0 0 * * MON")
    public void resetsWorkoutsMarkedAsCompletedFotTheWeek() {
        trainingItemService.resetCompletedWorkouts();
    }
}
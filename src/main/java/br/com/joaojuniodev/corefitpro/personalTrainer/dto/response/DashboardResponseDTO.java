package br.com.joaojuniodev.corefitpro.personalTrainer.dto.response;

import br.com.joaojuniodev.corefitpro.recentAcitivty.dto.response.RecentActivityResponseDTO;
import br.com.joaojuniodev.corefitpro.trainingItem.dto.response.TrainingItemSummaryDTO;

import java.util.List;

public record DashboardResponseDTO(
    Long activeTrainees,
    Long activePlans,
    Long pendings,
    Long workoutsCompletedToday,
    Double percentageWorkoutsCompletedToday,
    List<TrainingItemSummaryDTO> workoutsToday,
    List<AttentionResponseDTO> necessaryAttention,
    List<WeeklyRhythmCompletedWorkoutsResponseDTO> rhythmWeekly,
    List<RecentActivityResponseDTO> recentActivities
) {
}
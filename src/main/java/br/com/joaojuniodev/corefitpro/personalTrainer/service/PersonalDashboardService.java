package br.com.joaojuniodev.corefitpro.personalTrainer.service;

import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.AttentionResponseDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.DashboardResponseDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.WeeklyRhythmCompletedWorkoutsResponseDTO;
import br.com.joaojuniodev.corefitpro.recentAcitivty.service.RecentActivityService;
import br.com.joaojuniodev.corefitpro.trainee.repository.TraineeRepository;
import br.com.joaojuniodev.corefitpro.trainingItem.dto.projection.NotCompletedTrainingsProjection;
import br.com.joaojuniodev.corefitpro.trainingItem.dto.projection.WeeklyRhythmProjection;
import br.com.joaojuniodev.corefitpro.trainingItem.enums.DaysOfWeek;
import br.com.joaojuniodev.corefitpro.trainingItem.repository.TrainingItemRepository;
import br.com.joaojuniodev.corefitpro.trainingPlain.repository.TrainingPlainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PersonalDashboardService {
    private static final Logger logger = LoggerFactory.getLogger(PersonalDashboardService.class.getName());

    private final RecentActivityService recentActivityService;
    private final TraineeRepository traineeRepository;
    private final TrainingPlainRepository trainingPlainRepository;
    private final TrainingItemRepository trainingItemRepository;

    public PersonalDashboardService(RecentActivityService recentActivityService, TraineeRepository traineeRepository, TrainingPlainRepository trainingPlainRepository, TrainingItemRepository trainingItemRepository) {
        this.recentActivityService = recentActivityService;
        this.traineeRepository = traineeRepository;
        this.trainingPlainRepository = trainingPlainRepository;
        this.trainingItemRepository = trainingItemRepository;
    }

    public DashboardResponseDTO getDashboard(UUID id) {
        var today = LocalDate.now().getDayOfWeek();
        var day = DaysOfWeek.valueOf(today.name());

        long totalTrainingsOfToday = trainingItemRepository.countByDayOfWeek(day);

        var activeTrainees = traineeRepository.countByUserEnabledTrue();
        var activePlans = trainingPlainRepository.countByActiveTrue();
        var pendings = trainingItemRepository.countByDayOfWeekAndCompletedFalse(day);
        var workoutsCompletedToday = trainingItemRepository.countByDayOfWeekAndCompletedTrue(day);
        var percentageWorkoutsCompletedToday = workoutsCompletedToday == 0
            ? 0.0
            : (double) (workoutsCompletedToday * 100) / totalTrainingsOfToday;
        var todayTrainings = trainingItemRepository.findByDayOfWeek(day);
        var necessaryAttention = getAttentions();
        var rhythmWeekly = getWeeklyRhythm();
        var recentActivities = recentActivityService.getAll(id);

        return new DashboardResponseDTO(
            activeTrainees,
            activePlans,
            pendings,
            workoutsCompletedToday,
            percentageWorkoutsCompletedToday,
            todayTrainings,
            necessaryAttention,
            rhythmWeekly,
            recentActivities
        );
    }

    private List<AttentionResponseDTO> getAttentions() {
        List<NotCompletedTrainingsProjection> results = trainingItemRepository.findTrainingsIncomplete();

        return results.stream()
            .map(r -> {
                final String title = r.getTraineeName();
                final String message = "Faltou aos últimos" + r.getCountIncompleteTraining() + " treinos.";
                final String url = "http://localhost:5173/personal/alunos";

                return new AttentionResponseDTO(title, message, url);
            })
            .limit(3)
            .toList();
    }

    private List<WeeklyRhythmCompletedWorkoutsResponseDTO> getWeeklyRhythm() {
        List<WeeklyRhythmProjection> results = trainingItemRepository.findWeeklyRhythm();

        return results.stream().
            map(r ->  new WeeklyRhythmCompletedWorkoutsResponseDTO(
                r.getDayOfWeek(),
                r.getTotalTrainings(),
                r.getCompletedTrainings()
            ))
            .toList();
    }
}
package br.com.joaojuniodev.corefitpro.mapper.trainee;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.mapper.physicalAssessment.PhysicalAssessmentMapper;
import br.com.joaojuniodev.corefitpro.mapper.trainingItem.TrainingItemMapper;
import br.com.joaojuniodev.corefitpro.personalTrainer.repository.PersonalTrainerRepository;
import br.com.joaojuniodev.corefitpro.security.repository.UserRepository;
import br.com.joaojuniodev.corefitpro.trainee.dto.request.TraineeRequestDTO;
import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeDetailsDTO;
import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeResponseDTO;
import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeSummaryDTO;
import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeWeeklyTraining;
import br.com.joaojuniodev.corefitpro.trainee.model.Trainee;
import br.com.joaojuniodev.corefitpro.trainingItem.enums.DaysOfWeek;
import br.com.joaojuniodev.corefitpro.trainingItem.enums.TrainingStatus;
import br.com.joaojuniodev.corefitpro.trainingItem.model.TrainingItem;
import br.com.joaojuniodev.corefitpro.trainingItem.repository.TrainingItemRepository;
import br.com.joaojuniodev.corefitpro.trainingPlain.repository.TrainingPlainRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TraineeMapper implements ObjectMapper<Trainee, TraineeResponseDTO, TraineeRequestDTO> {

    private final PersonalTrainerRepository personalTrainerRepository;
    private final UserRepository userRepository;
    private final TrainingItemRepository trainingItemRepository;
    private final TrainingPlainRepository trainingPlainRepository;
    private final PhysicalAssessmentMapper physicalAssessmentMapper;
    private final TrainingItemMapper trainingItemMapper;

    public TraineeMapper(PersonalTrainerRepository personalTrainerRepository, UserRepository userRepository, TrainingItemRepository trainingItemRepository, TrainingPlainRepository trainingPlainRepository, PhysicalAssessmentMapper physicalAssessmentMapper, TrainingItemMapper trainingItemMapper) {
        this.personalTrainerRepository = personalTrainerRepository;
        this.userRepository = userRepository;
        this.trainingItemRepository = trainingItemRepository;
        this.trainingPlainRepository = trainingPlainRepository;
        this.physicalAssessmentMapper = physicalAssessmentMapper;
        this.trainingItemMapper = trainingItemMapper;
    }

    @Override
    public Trainee toEntity(TraineeRequestDTO request) {
        var user = userRepository.findByUserName(request.username());
        var personalTrainer = personalTrainerRepository.findById(request.personalTrainerId())
            .orElseThrow(() -> new NotFoundException("Not found Personal Trainer Id: " + request.personalTrainerId()));

        Trainee trainee = new Trainee();
        trainee.setId(request.id());
        trainee.setFirstName(request.firstName());
        trainee.setLastName(request.lastName());
        trainee.setUser(user);
        trainee.setPersonalTrainer(personalTrainer);
        return trainee;
    }

    @Override
    public TraineeResponseDTO toResponse(Trainee entity) {
        var trainingPlainForTrainee = trainingPlainRepository.findByTrainee(entity.getId())
            .orElseThrow(() -> new NotFoundException("Not found Training Plain for Trainee Id: " + entity.getId()));

        var lastPhysicalAssessment = entity.getPhysicalAssessments()
            .stream()
            .findFirst()
            .orElse(null);

        var trainingsOfWeekly = trainingItemRepository.findByTrainee(entity.getId());

        long totalTrainings = trainingsOfWeekly.size();

        long completedTrainings = trainingsOfWeekly.stream()
            .filter(TrainingItem::getCompleted)
            .count();

        double progress = totalTrainings > 0
            ? (completedTrainings * 100.0) / totalTrainings
            : 0.0;

        progress = BigDecimal.valueOf(progress)
            .setScale(2, RoundingMode.HALF_UP)
            .doubleValue();

        return new TraineeResponseDTO(
            entity.getId(),
            entity.getFirstName(),
            entity.getLastName(),
            entity.getAvatarUrl(),
            lastPhysicalAssessment.getAge(),
            lastPhysicalAssessment.getWeight(),
            trainingPlainForTrainee.getObjective(),
            trainingPlainForTrainee.getActive(),
            progress
        );
    }

    public TraineeDetailsDTO toDetails(Trainee entity) {
        var trainingsOfWeekly = trainingItemRepository.findByTrainee(entity.getId());

        var totalTrainings = trainingsOfWeekly.stream().count();
        var completedTrainings = trainingsOfWeekly.stream()
            .filter(item -> Boolean.TRUE.equals(item.getCompleted()))
            .count();

        return new TraineeDetailsDTO(
            toResponse(entity),
            entity.getPhysicalAssessments()
                .stream()
                .map(physicalAssessmentMapper::toResponse).toList(),
            buildWeeklySchedule(trainingsOfWeekly),
            totalTrainings,
            completedTrainings
        );
    }

    private List<TraineeWeeklyTraining> buildWeeklySchedule(List<TrainingItem> trainingItems) {
        Map<DaysOfWeek, TrainingItem> itemsByDay = trainingItems.stream()
            .collect(Collectors.toMap(TrainingItem::getDayOfWeek, Function.identity(), (first, duplicate) -> first));

        LocalDate monday = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate today = LocalDate.now();

        List<TraineeWeeklyTraining> weeklySchedule = new ArrayList<>();

        for (DaysOfWeek day : DaysOfWeek.values()) {
            TrainingItem item = itemsByDay.get(day);

            if (item == null) {
                LocalDateTime restDateTime = monday.plusDays(day.ordinal()).atStartOfDay();
                boolean isToday = restDateTime.toLocalDate().equals(today);
                weeklySchedule.add(new TraineeWeeklyTraining(null, day, isToday, null, null, restDateTime, TrainingStatus.REST));
                continue;
            }

            TrainingStatus status = Boolean.TRUE.equals(item.getCompleted())
                ? TrainingStatus.COMPLETED
                : TrainingStatus.PENDING;

            String title = item.getTraining() != null ? item.getTraining().getTitle() : null;
            String focus = item.getTraining() != null ? item.getTraining().getDescription() : null;
            boolean isToday = item.getDateTime() != null && item.getDateTime().toLocalDate().equals(today);

            weeklySchedule.add(new TraineeWeeklyTraining(item.getId(), day, isToday, title, focus, item.getDateTime(), status));
        }

        return weeklySchedule;
    }

    public TraineeSummaryDTO toSummary(Trainee entity) {
        return new TraineeSummaryDTO(
            entity.getId(),
            entity.getFirstName(),
            entity.getLastName()
        );
    }
}
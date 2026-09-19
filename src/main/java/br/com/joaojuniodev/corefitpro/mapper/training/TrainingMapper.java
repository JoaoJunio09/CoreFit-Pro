package br.com.joaojuniodev.corefitpro.mapper.training;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.mapper.exerciseItem.ExerciseItemMapper;
import br.com.joaojuniodev.corefitpro.mapper.muscleGroup.MuscleGroupMapper;
import br.com.joaojuniodev.corefitpro.personalTrainer.repository.PersonalTrainerRepository;
import br.com.joaojuniodev.corefitpro.training.dto.request.TrainingRequestDTO;
import br.com.joaojuniodev.corefitpro.training.dto.response.TrainingResponseDTO;
import br.com.joaojuniodev.corefitpro.training.dto.response.TrainingSummaryDTO;
import br.com.joaojuniodev.corefitpro.training.model.Training;
import br.com.joaojuniodev.corefitpro.trainingItem.repository.TrainingItemRepository;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper implements ObjectMapper<Training, TrainingResponseDTO, TrainingRequestDTO> {

    private final TrainingItemRepository trainingItemRepository;
    private final PersonalTrainerRepository personalTrainerRepository;
    private final MuscleGroupMapper muscleGroupMapper;
    private final ExerciseItemMapper exerciseItemMapper;

    public TrainingMapper(TrainingItemRepository trainingItemRepository, PersonalTrainerRepository personalTrainerRepository, MuscleGroupMapper muscleGroupMapper, ExerciseItemMapper exerciseItemMapper) {
        this.trainingItemRepository = trainingItemRepository;
        this.personalTrainerRepository = personalTrainerRepository;
        this.muscleGroupMapper = muscleGroupMapper;
        this.exerciseItemMapper = exerciseItemMapper;
    }

    @Override
    public Training toEntity(TrainingRequestDTO request) {
        var personalTrainer = personalTrainerRepository.findById(request.personalTrainerId())
            .orElseThrow(() -> new NotFoundException("Not found Personal Trainer Id: " + request.personalTrainerId()));

        Training training = new Training();
        training.setId(request.id());
        training.setTitle(request.title());
        training.setDescription(request.description());
        training.setPersonalTrainer(personalTrainer);
        return training;
    }

    @Override
    public TrainingResponseDTO toResponse(Training entity) {
        var numberOfExercises = entity.getExerciseItems().stream().count();
        var numberOfTrainees = trainingItemRepository.countTraineesUseThisTraining(entity.getId());
        return new TrainingResponseDTO(
            entity.getId(),
            entity.getTitle(),
            entity.getDescription(),
            numberOfExercises,
            numberOfTrainees,
            entity.getMuscleGroups().stream().map(muscleGroupMapper::toResponse).toList(),
            entity.getExerciseItems().stream().map(exerciseItemMapper::toResponse).toList()
        );
    }

    public TrainingSummaryDTO toSummary(Training entity) {
        return new TrainingSummaryDTO(
            entity.getId(),
            entity.getTitle(),
            entity.getDescription(),
            entity.getExerciseItems().stream().count()
        );
    }
}
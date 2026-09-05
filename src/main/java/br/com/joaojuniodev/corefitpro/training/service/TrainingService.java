package br.com.joaojuniodev.corefitpro.training.service;

import br.com.joaojuniodev.corefitpro.exceptions.IsEmptyObjectException;
import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.exerciseItem.dto.request.ExerciseItemRequestDTO;
import br.com.joaojuniodev.corefitpro.exerciseItem.model.ExerciseItem;
import br.com.joaojuniodev.corefitpro.exerciseItem.repository.ExerciseItemRepository;
import br.com.joaojuniodev.corefitpro.mapper.exerciseItem.ExerciseItemMapper;
import br.com.joaojuniodev.corefitpro.mapper.training.TrainingMapper;
import br.com.joaojuniodev.corefitpro.muscleGroup.model.MuscleGroup;
import br.com.joaojuniodev.corefitpro.muscleGroup.repository.MuscleGroupRepository;
import br.com.joaojuniodev.corefitpro.training.dto.request.TrainingRequestDTO;
import br.com.joaojuniodev.corefitpro.training.dto.response.TrainingResponseDTO;
import br.com.joaojuniodev.corefitpro.training.model.Training;
import br.com.joaojuniodev.corefitpro.training.repository.TrainingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TrainingService {
    private static final Logger logger = LoggerFactory.getLogger(TrainingService.class.getName());

    private final TrainingRepository trainingRepository;
    private final MuscleGroupRepository muscleGroupRepository;
    private final ExerciseItemRepository exerciseItemRepository;
    private final TrainingMapper trainingMapper;
    private final ExerciseItemMapper exerciseItemMapper;

    public TrainingService(TrainingRepository trainingRepository, MuscleGroupRepository muscleGroupRepository, ExerciseItemRepository exerciseItemRepository, TrainingMapper trainingMapper, ExerciseItemMapper exerciseItemMapper) {
        this.trainingRepository = trainingRepository;
        this.muscleGroupRepository = muscleGroupRepository;
        this.exerciseItemRepository = exerciseItemRepository;
        this.trainingMapper = trainingMapper;
        this.exerciseItemMapper = exerciseItemMapper;
    }

    public List<TrainingResponseDTO> getAll() {
        logger.info("Getting All Trainings");

        return trainingRepository.findAll()
            .stream()
            .map(trainingMapper::toResponse)
            .toList();
    }

    public TrainingResponseDTO getById(UUID id) {
        logger.info("Getting By Training Id");

        var entity = trainingRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Training Id: " + id));
        return trainingMapper.toResponse(entity);
    }

    @Transactional
    public TrainingResponseDTO create(TrainingRequestDTO training) {
        logger.info("Creating new Training");

        if (training.exerciseItems().isEmpty()) throw new IsEmptyObjectException("Exercise Items is empty");
        if (training.muscleGroupsId().isEmpty()) throw new IsEmptyObjectException(("Muscle Groups Id is empty"));

        Training entity = trainingMapper.toEntity(training);

        List<MuscleGroup> muscleGroups = muscleGroupRepository.findAllById(training.muscleGroupsId());
        entity.setMuscleGroups(muscleGroups);

        var saved = trainingRepository.save(entity);

        logger.info("savo primeira vez");

        List<ExerciseItem> exerciseItems = new ArrayList<>();

        for (ExerciseItemRequestDTO exerciseItem : training.exerciseItems()) {
            var exerciseItemEntity = exerciseItemMapper.toEntity(exerciseItem);
            exerciseItemEntity.setTraining(entity);
            exerciseItems.add(exerciseItemRepository.save(exerciseItemEntity));
        }

        logger.info("adiciono exercises items");

        saved.setExerciseItems(exerciseItems);
        var trainingCreated = trainingRepository.save(saved);

        logger.info("Salvo d novo");

        return trainingMapper.toResponse(trainingCreated);
    }

    public TrainingResponseDTO update(TrainingRequestDTO training) {
        logger.info("Updating Training");

        var entity = trainingRepository.findById(training.id())
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Id: " + training.id()));
        return null;
    }

    public void delete(UUID id) {
        logger.info("Deleting Training");

        var entity = trainingRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Id: " + id));
        trainingRepository.delete(entity);
    }
}
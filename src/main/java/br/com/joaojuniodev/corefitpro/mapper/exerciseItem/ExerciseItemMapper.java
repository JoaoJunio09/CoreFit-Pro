package br.com.joaojuniodev.corefitpro.mapper.exerciseItem;

import br.com.joaojuniodev.corefitpro.exercise.repository.ExerciseRepository;
import br.com.joaojuniodev.corefitpro.exerciseItem.dto.request.ExerciseItemRequestDTO;
import br.com.joaojuniodev.corefitpro.exerciseItem.dto.response.ExerciseItemResponseDTO;
import br.com.joaojuniodev.corefitpro.exerciseItem.model.ExerciseItem;
import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.mapper.exercise.ExerciseMapper;
import br.com.joaojuniodev.corefitpro.training.repository.TrainingRepository;
import org.springframework.stereotype.Component;

@Component
public class ExerciseItemMapper implements ObjectMapper<ExerciseItem, ExerciseItemResponseDTO, ExerciseItemRequestDTO> {
    private final ExerciseRepository exerciseRepository;
    private final TrainingRepository trainingRepository;
    private final ExerciseMapper exerciseMapper;

    public ExerciseItemMapper(ExerciseRepository exerciseRepository, TrainingRepository trainingRepository, ExerciseMapper exerciseMapper) {
        this.exerciseRepository = exerciseRepository;
        this.trainingRepository = trainingRepository;
        this.exerciseMapper = exerciseMapper;
    }

    @Override
    public ExerciseItem toEntity(ExerciseItemRequestDTO request) {
        var exercise = exerciseRepository.findById(request.exerciseId()).orElseGet(null);
        var training = trainingRepository.findById(request.trainingId()).orElseGet(null);

        ExerciseItem exerciseItem = new ExerciseItem();
        exerciseItem.setId(request.id());
        exerciseItem.setRepetitions(request.repetitions());
        exerciseItem.setSeries(request.series());
        exerciseItem.setExercise(exercise);
        exerciseItem.setTraining(training);
        return exerciseItem;
    }

    @Override
    public ExerciseItemResponseDTO toResponse(ExerciseItem entity) {
        return new ExerciseItemResponseDTO(
            entity.getId(),
            exerciseMapper.toResponse(entity.getExercise()),
            entity.getRepetitions(),
            entity.getSeries()
        );
    }
}
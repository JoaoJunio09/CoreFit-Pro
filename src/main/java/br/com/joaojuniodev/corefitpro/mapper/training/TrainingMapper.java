package br.com.joaojuniodev.corefitpro.mapper.training;

import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.mapper.exerciseItem.ExerciseItemMapper;
import br.com.joaojuniodev.corefitpro.mapper.muscleGroup.MuscleGroupMapper;
import br.com.joaojuniodev.corefitpro.training.dto.request.TrainingRequestDTO;
import br.com.joaojuniodev.corefitpro.training.dto.response.TrainingResponseDTO;
import br.com.joaojuniodev.corefitpro.training.model.Training;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper implements ObjectMapper<Training, TrainingResponseDTO, TrainingRequestDTO> {
    private final MuscleGroupMapper muscleGroupMapper;
    private final ExerciseItemMapper exerciseItemMapper;

    public TrainingMapper(MuscleGroupMapper muscleGroupMapper, ExerciseItemMapper exerciseItemMapper) {
        this.muscleGroupMapper = muscleGroupMapper;
        this.exerciseItemMapper = exerciseItemMapper;
    }

    @Override
    public Training toEntity(TrainingRequestDTO request) {
        Training training = new Training();
        training.setId(request.id());
        training.setTitle(request.title());
        training.setDescription(request.description());
        return training;
    }

    @Override
    public TrainingResponseDTO toResponse(Training entity) {
        return new TrainingResponseDTO(
            entity.getId(),
            entity.getTitle(),
            entity.getDescription(),
            entity.getMuscleGroups().stream().map(muscleGroupMapper::toResponse).toList(),
            entity.getExerciseItems().stream().map(exerciseItemMapper::toResponse).toList()
        );
    }
}
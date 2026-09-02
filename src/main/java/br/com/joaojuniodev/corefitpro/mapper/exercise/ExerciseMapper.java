package br.com.joaojuniodev.corefitpro.mapper.exercise;

import br.com.joaojuniodev.corefitpro.exercise.dto.request.ExerciseRequestDTO;
import br.com.joaojuniodev.corefitpro.exercise.dto.response.ExerciseResponseDTO;
import br.com.joaojuniodev.corefitpro.exercise.model.Exercise;
import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper implements ObjectMapper<Exercise, ExerciseResponseDTO, ExerciseRequestDTO> {

    @Override
    public Exercise toEntity(ExerciseRequestDTO request) {
        Exercise exercise = new Exercise();
        exercise.setId(request.id());
        exercise.setName(request.name());
        exercise.setPhoto(request.photoUrl());
        exercise.setVideo(request.videoUrl());
        return exercise;
    }

    @Override
    public ExerciseResponseDTO toResponse(Exercise entity) {
        return new ExerciseResponseDTO(
            entity.getId(),
            entity.getName(),
            entity.getPhoto(),
            entity.getVideo()
        );
    }
}
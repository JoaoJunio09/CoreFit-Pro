package br.com.joaojuniodev.corefitpro.exercise.service;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.exercise.dto.request.ExerciseRequestDTO;
import br.com.joaojuniodev.corefitpro.exercise.dto.response.ExerciseResponseDTO;
import br.com.joaojuniodev.corefitpro.exercise.repository.ExerciseRepository;
import br.com.joaojuniodev.corefitpro.mapper.exercise.ExerciseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExerciseService {
    private static final Logger logger = LoggerFactory.getLogger(ExerciseService.class.getName());

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper mapper;

    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseMapper mapper) {
        this.exerciseRepository = exerciseRepository;
        this.mapper = mapper;
    }

    public List<ExerciseResponseDTO> getAll() {
        logger.info("Getting All Exercises");

        return exerciseRepository.findAll()
            .stream()
            .map(mapper::toResponse)
            .toList();
    }

    public ExerciseResponseDTO getById(UUID id) {
        logger.info("Getting By Exercise Id");

        var entity = exerciseRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Id: " + id));
        return new ExerciseResponseDTO(
            entity.getId(),
            entity.getName(),
            entity.getPhoto(),
            entity.getVideo()
        );
    }

    public ExerciseResponseDTO create(ExerciseRequestDTO exercise) {
        logger.info("Creating new Exercise");

        var entity = mapper.toEntity(exercise);
        var exerciseCreated = exerciseRepository.save(entity);
        return mapper.toResponse(exerciseCreated);
    }

    public ExerciseResponseDTO update(ExerciseRequestDTO exercise) {
        logger.info("Updating Exercise");

        var entity = exerciseRepository.findById(exercise.id())
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Id: " + exercise.id()));
        entity.setName(exercise.name());
        entity.setPhoto(exercise.photoUrl());
        entity.setVideo(exercise.videoUrl());
        var exerciseUpdated = exerciseRepository.save(entity);
        return mapper.toResponse(exerciseUpdated);
    }

    public void delete(UUID id) {
        logger.info("Deleting Exercise");

        var entity = exerciseRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Id: " + id));
        exerciseRepository.delete(entity);
    }
}
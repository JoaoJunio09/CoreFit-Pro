package br.com.joaojuniodev.corefitpro.exerciseItem.service;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.exerciseItem.dto.request.ExerciseItemRequestDTO;
import br.com.joaojuniodev.corefitpro.exerciseItem.dto.response.ExerciseItemResponseDTO;
import br.com.joaojuniodev.corefitpro.exerciseItem.repository.ExerciseItemRepository;
import br.com.joaojuniodev.corefitpro.mapper.exerciseItem.ExerciseItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExerciseItemService {
    private static final Logger logger = LoggerFactory.getLogger(ExerciseItemService.class.getName());

    private final ExerciseItemMapper mapper;
    private final ExerciseItemRepository exerciseItemRepository;

    public ExerciseItemService(ExerciseItemMapper mapper, ExerciseItemRepository exerciseItemRepository) {
        this.mapper = mapper;
        this.exerciseItemRepository = exerciseItemRepository;
    }

    public List<ExerciseItemResponseDTO> getAll() {
        logger.info("Getting All Exercises Items");

        return exerciseItemRepository.findAll()
            .stream()
            .map(mapper::toResponse)
            .toList();
    }

    public ExerciseItemResponseDTO getById(UUID id) {
        logger.info("Getting By Exercise Item Id");

        var entity = exerciseItemRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Item Id: " + id));
        return mapper.toResponse(entity);
    }

    public ExerciseItemResponseDTO create(ExerciseItemRequestDTO exerciseItem) {
        logger.info("Creating new Exercise Item");

        var entity = mapper.toEntity(exerciseItem);
        var exerciseItemCreated = exerciseItemRepository.save(entity);
        return mapper.toResponse(exerciseItemCreated);
    }

    public ExerciseItemResponseDTO update(ExerciseItemRequestDTO exerciseItem) {
        logger.info("Updating Exercise Item");

        var entity = exerciseItemRepository.findById(exerciseItem.id())
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Item Id: " + exerciseItem.id()));
        entity.setRepetitions(exerciseItem.repetitions());
        entity.setSeries(exerciseItem.series());
        var exerciseItemUpdated = exerciseItemRepository.save(entity);
        return mapper.toResponse(exerciseItemUpdated);
    }

    public void delete(UUID id) {
        logger.info("Deleting Exercise Item");

        var entity = exerciseItemRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Item Id: " + id));
        exerciseItemRepository.delete(entity);
    }
}
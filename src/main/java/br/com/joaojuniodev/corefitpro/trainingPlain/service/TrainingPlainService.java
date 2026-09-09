package br.com.joaojuniodev.corefitpro.trainingPlain.service;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.mapper.trainingPlain.TrainingPlainMapper;
import br.com.joaojuniodev.corefitpro.trainingPlain.dto.request.TrainingPlainRequestDTO;
import br.com.joaojuniodev.corefitpro.trainingPlain.dto.response.TrainingPlainDetailsDTO;
import br.com.joaojuniodev.corefitpro.trainingPlain.dto.response.TrainingPlainResponseDTO;
import br.com.joaojuniodev.corefitpro.trainingPlain.repository.TrainingPlainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TrainingPlainService {
    private static final Logger logger = LoggerFactory.getLogger(TrainingPlainService.class.getName());

    private final TrainingPlainRepository trainingPlainRepository;
    private final TrainingPlainMapper trainingPlainMapper;

    public TrainingPlainService(TrainingPlainRepository trainingPlainRepository, TrainingPlainMapper trainingPlainMapper) {
        this.trainingPlainRepository = trainingPlainRepository;
        this.trainingPlainMapper = trainingPlainMapper;
    }

    public List<TrainingPlainResponseDTO> getAll() {
        logger.info("Getting All Trainings Plain");

        return trainingPlainRepository.findAll()
            .stream()
            .map(trainingPlainMapper::toResponse)
            .toList();
    }

    public TrainingPlainDetailsDTO getById(UUID id) {
        logger.info("Getting By Training Plain Id");

        var entity = trainingPlainRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Training Plain Id: " + id));
        return trainingPlainMapper.toDetails(entity);
    }

    public TrainingPlainResponseDTO create(TrainingPlainRequestDTO trainingPlain) {
        logger.info("Creating new Training Plain");

        var entity = trainingPlainMapper.toEntity(trainingPlain);
        var trainingPlainCreated = trainingPlainRepository.save(entity);
        return trainingPlainMapper.toResponse(trainingPlainCreated);
    }

    public TrainingPlainResponseDTO update(TrainingPlainRequestDTO trainingPlain) {
        logger.info("Updating Training Plain");

        var entity = trainingPlainRepository.findById(trainingPlain.id())
            .orElseThrow(() -> new NotFoundException("Not found this Training Plain Id: " + trainingPlain.id()));
        entity.setDescription(trainingPlain.description());
        entity.setObjective(trainingPlain.objective());

        var trainingPlainUpdated = trainingPlainRepository.save(entity);

        return trainingPlainMapper.toResponse(trainingPlainUpdated);
    }

    public void delete(UUID id) {
        logger.info("Deleting Training Plain");

        var entity = trainingPlainRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Training Plain Id: " + id));
        trainingPlainRepository.delete(entity);
    }
}
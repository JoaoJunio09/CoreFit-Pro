package br.com.joaojuniodev.corefitpro.trainee.service;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.mapper.trainee.TraineeMapper;
import br.com.joaojuniodev.corefitpro.trainee.dto.request.TraineeRequestDTO;
import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeResponseDTO;
import br.com.joaojuniodev.corefitpro.trainee.repository.TraineeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TraineeService {
    private static final Logger logger = LoggerFactory.getLogger(TraineeService.class.getName());

    private final TraineeRepository traineeRepository;
    private final TraineeMapper traineeMapper;

    public TraineeService(TraineeRepository traineeRepository, TraineeMapper traineeMapper) {
        this.traineeRepository = traineeRepository;
        this.traineeMapper = traineeMapper;
    }

    public List<TraineeResponseDTO> getAll() {
        logger.info("Getting All Trainees");

        return traineeRepository.findAll()
            .stream()
            .map(traineeMapper::toResponse)
            .toList();
    }

    public TraineeResponseDTO getById(UUID id) {
        logger.info("Getting By Trainee Id");

        var entity = traineeRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Trainee Id: " + id));
        return traineeMapper.toResponse(entity);
    }

    public TraineeResponseDTO create(TraineeRequestDTO trainee) {
        logger.info("Creating new Exercise");

        var entity = traineeMapper.toEntity(trainee);
        var traineeCreated = traineeRepository.save(entity);
        return traineeMapper.toResponse(traineeCreated);
    }

    public TraineeResponseDTO update(TraineeRequestDTO trainee) {
        logger.info("Updating Exercise");

        var entity = traineeRepository.findById(trainee.id())
            .orElseThrow(() -> new NotFoundException("Not found this Trainee Id: " + trainee.id()));
        entity.setFirstName(trainee.firstName());
        entity.setLastName(trainee.lastName());
        var traineeUpdated = traineeRepository.save(entity);
        return traineeMapper.toResponse(traineeUpdated);
    }

    public void delete(UUID id) {
        logger.info("Deleting Trainee");

        var entity = traineeRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Trainee Id: " + id));
        traineeRepository.delete(entity);
    }
}
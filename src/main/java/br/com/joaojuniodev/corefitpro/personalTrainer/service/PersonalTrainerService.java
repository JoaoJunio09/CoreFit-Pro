package br.com.joaojuniodev.corefitpro.personalTrainer.service;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.mapper.personalTrainer.PersonalTrainerMapper;
import br.com.joaojuniodev.corefitpro.personalTrainer.dto.request.PersonalTrainerRequestDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.PersonalTrainerResponseDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.repository.PersonalTrainerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonalTrainerService {
    private static final Logger logger = LoggerFactory.getLogger(PersonalTrainerService.class.getName());

    private final PersonalTrainerRepository personalTrainerRepository;
    private final PersonalTrainerMapper personalTrainerMapper;

    public PersonalTrainerService(PersonalTrainerRepository personalTrainerRepository, PersonalTrainerMapper personalTrainerMapper) {
        this.personalTrainerRepository = personalTrainerRepository;
        this.personalTrainerMapper = personalTrainerMapper;
    }

    public List<PersonalTrainerResponseDTO> getAll() {
        logger.info("Getting All Exercises");

        return personalTrainerRepository.findAll()
            .stream()
            .map(personalTrainerMapper::toResponse)
            .toList();
    }

    public PersonalTrainerResponseDTO getById(UUID id) {
        logger.info("Getting By Exercise Id");

        var entity = personalTrainerRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Personal Trainer Id: " + id));
        return personalTrainerMapper.toResponse(entity);
    }

    public PersonalTrainerResponseDTO create(PersonalTrainerRequestDTO personalTrainer) {
        logger.info("Creating new Exercise");

        var entity = personalTrainerMapper.toEntity(personalTrainer);
        var personalTrainerCreated = personalTrainerRepository.save(entity);
        return personalTrainerMapper.toResponse(personalTrainerCreated);
    }

    public PersonalTrainerResponseDTO update(PersonalTrainerRequestDTO personalTrainer) {
        logger.info("Updating Exercise");

        var entity = personalTrainerRepository.findById(personalTrainer.id())
            .orElseThrow(() -> new NotFoundException("Not found this Personal Trainer Id: " + personalTrainer.id()));
        entity.setFirstName(personalTrainer.firstName());
        entity.setLastName(personalTrainer.lastName());
        var personalTrainerUpdated = personalTrainerRepository.save(entity);
        return personalTrainerMapper.toResponse(personalTrainerUpdated);
    }

    public void delete(UUID id) {
        logger.info("Deleting Personal Trainer");

        var entity = personalTrainerRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Personal Trainer Id: " + id));
        personalTrainerRepository.delete(entity);
    }
}
package br.com.joaojuniodev.corefitpro.muscleGroup.service;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.mapper.muscleGroup.MuscleGroupMapper;
import br.com.joaojuniodev.corefitpro.muscleGroup.dto.request.MuscleGroupRequestDTO;
import br.com.joaojuniodev.corefitpro.muscleGroup.dto.response.MuscleGroupResponseDTO;
import br.com.joaojuniodev.corefitpro.muscleGroup.repository.MuscleGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MuscleGroupService {
    private static final Logger logger = LoggerFactory.getLogger(MuscleGroupService.class.getName());

    private final MuscleGroupRepository muscleGroupRepository;
    private final MuscleGroupMapper mapper;

    public MuscleGroupService(MuscleGroupRepository muscleGroupRepository, MuscleGroupMapper mapper) {
        this.muscleGroupRepository = muscleGroupRepository;
        this.mapper = mapper;
    }

    public List<MuscleGroupResponseDTO> getAll() {
        logger.info("Getting All Muscle Groups");

        return muscleGroupRepository.findAll()
            .stream()
            .map(mapper::toResponse)
            .toList();
    }

    public MuscleGroupResponseDTO getById(UUID id) {
        logger.info("Getting By Muscle Group Id");

        var entity = muscleGroupRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Muscle Group Id: " + id));
        return new MuscleGroupResponseDTO(entity.getId(), entity.getName());
    }

    public MuscleGroupResponseDTO create(MuscleGroupRequestDTO muscleGroup) {
        logger.info("Creating new Muscle Group");

        var entity = mapper.toEntity(muscleGroup);
        var muscleGroupCreated = muscleGroupRepository.save(entity);
        return mapper.toResponse(muscleGroupCreated);
    }

    public MuscleGroupResponseDTO update(MuscleGroupRequestDTO muscleGroup) {
        logger.info("Updating Muscle Group");

        var entity = muscleGroupRepository.findById(muscleGroup.id())
            .orElseThrow(() -> new NotFoundException("Not found this Muscle Group Id: " + muscleGroup.id()));
        entity.setName(muscleGroup.name());
        var muscleGroupUpdated = muscleGroupRepository.save(entity);
        return mapper.toResponse(muscleGroupUpdated);
    }

    public void delete(UUID id) {
        logger.info("Deleting Muscle Group");

        var entity = muscleGroupRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Id: " + id));
        muscleGroupRepository.delete(entity);
    }
}
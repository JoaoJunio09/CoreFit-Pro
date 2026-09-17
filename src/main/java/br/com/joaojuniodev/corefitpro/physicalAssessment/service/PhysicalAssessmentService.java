package br.com.joaojuniodev.corefitpro.physicalAssessment.service;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.mapper.physicalAssessment.PhysicalAssessmentMapper;
import br.com.joaojuniodev.corefitpro.physicalAssessment.dto.request.PhysicalAssessmentRequestDTO;
import br.com.joaojuniodev.corefitpro.physicalAssessment.dto.response.PhysicalAssessmentResponseDTO;
import br.com.joaojuniodev.corefitpro.physicalAssessment.repository.PhysicalAssessmentRepository;
import br.com.joaojuniodev.corefitpro.physicalAssessment.repository.spec.PhysicalAssessmentSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhysicalAssessmentService {
    private static final Logger logger = LoggerFactory.getLogger(PhysicalAssessmentService.class.getName());

    private final PhysicalAssessmentRepository physicalAssessmentRepository;
    private final PhysicalAssessmentMapper physicalAssessmentMapper;

    public PhysicalAssessmentService(PhysicalAssessmentRepository physicalAssessmentRepository, PhysicalAssessmentMapper physicalAssessmentMapper) {
        this.physicalAssessmentRepository = physicalAssessmentRepository;
        this.physicalAssessmentMapper = physicalAssessmentMapper;
    }

    public List<PhysicalAssessmentResponseDTO> getAll(UUID traineeId) {
        logger.info("Getting All Physical Assessments");

        PhysicalAssessmentSpecification spec = new PhysicalAssessmentSpecification();
        spec.addToSpecifications(traineeId);

        return physicalAssessmentRepository
            .findAll(spec.apply())
            .stream()
            .map(physicalAssessmentMapper::toResponse)
            .toList();
    }

    public PhysicalAssessmentResponseDTO getById(UUID id) {
        logger.info("Getting By Physical Assessment Id");

        var entity = physicalAssessmentRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Physical Assessment Id: " + id));
        return physicalAssessmentMapper.toResponse(entity);
    }

    public PhysicalAssessmentResponseDTO create(PhysicalAssessmentRequestDTO physicalAssessment) {
        logger.info("Creating new Physical Assessment");

        var entity = physicalAssessmentMapper.toEntity(physicalAssessment);
        var physicalAssessmentCreated = physicalAssessmentRepository.save(entity);
        return physicalAssessmentMapper.toResponse(physicalAssessmentCreated);
    }

    public PhysicalAssessmentResponseDTO update(PhysicalAssessmentRequestDTO physicalAssessment) {
        logger.info("Updating Physical Assessment");

        var entity = physicalAssessmentRepository.findById(physicalAssessment.id())
            .orElseThrow(() -> new NotFoundException("Not found this Physical Assessment Id: " + physicalAssessment.id()));

        var physicalAssessmentUpdated = physicalAssessmentRepository.save(entity);

        return physicalAssessmentMapper.toResponse(physicalAssessmentUpdated);
    }

    public void delete(UUID id) {
        logger.info("Deleting Physical Assessment");

        var entity = physicalAssessmentRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Physical Assessment Id: " + id));
        physicalAssessmentRepository.delete(entity);
    }
}
package br.com.joaojuniodev.corefitpro.mapper.physicalAssessment;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.mapper.trainee.TraineeMapper;
import br.com.joaojuniodev.corefitpro.physicalAssessment.dto.request.PhysicalAssessmentRequestDTO;
import br.com.joaojuniodev.corefitpro.physicalAssessment.dto.response.PhysicalAssessmentResponseDTO;
import br.com.joaojuniodev.corefitpro.physicalAssessment.model.PhysicalAssessment;
import br.com.joaojuniodev.corefitpro.trainee.repository.TraineeRepository;
import org.springframework.stereotype.Component;

@Component
public class PhysicalAssessmentMapper implements ObjectMapper<PhysicalAssessment, PhysicalAssessmentResponseDTO, PhysicalAssessmentRequestDTO> {

    private TraineeRepository traineeRepository;
    private TraineeMapper traineeMapper;

    public PhysicalAssessmentMapper(TraineeRepository traineeRepository, TraineeMapper traineeMapper) {
        this.traineeRepository = traineeRepository;
        this.traineeMapper = traineeMapper;
    }

    @Override
    public PhysicalAssessment toEntity(PhysicalAssessmentRequestDTO request) {
        var trainee = traineeRepository.findById(request.traineeId())
            .orElseThrow(() -> new NotFoundException("Not found Physical Assessment Id: " + request.traineeId()));

        PhysicalAssessment physicalAssessment = new PhysicalAssessment();
        physicalAssessment.setId(request.id());
        physicalAssessment.setTrainee(trainee);
        physicalAssessment.setRegisteredAt(request.registeredAt());
        physicalAssessment.setAge(request.age());
        physicalAssessment.setWeight(request.weight());
        physicalAssessment.setHeight(request.height());
        physicalAssessment.setImc(request.imc());
        physicalAssessment.setBodyFat(request.bodyFat());
        physicalAssessment.setFatMass(request.fatMass());
        physicalAssessment.setMuscleMass(request.muscleMass());
        physicalAssessment.setChest(request.chest());
        physicalAssessment.setWaist(request.waist());
        physicalAssessment.setAbdomen(request.abdomen());
        physicalAssessment.setHip(request.hip());
        physicalAssessment.setRightArm(request.rightArm());
        physicalAssessment.setLeftArm(request.leftArm());
        physicalAssessment.setRightThigh(request.rightThigh());
        physicalAssessment.setLeftThigh(request.leftThigh());
        physicalAssessment.setActivityLevel(request.activityLevel());
        physicalAssessment.setNotes(request.notes());
        physicalAssessment.setFrontViewPhotoUrl(request.frontViewPhotoUrl());
        physicalAssessment.setBackViewPhotoUrl(request.backViewPhotoUrl());
        physicalAssessment.setLeftViewPhotoUrl(request.leftViewPhotoUrl());
        physicalAssessment.setRightViewPhotoUrl(request.rightViewPhotoUrl());
        return physicalAssessment;
    }

    @Override
    public PhysicalAssessmentResponseDTO toResponse(PhysicalAssessment entity) {
        return new PhysicalAssessmentResponseDTO(
            entity.getId(),
            traineeMapper.toSummary(entity.getTrainee()),
            entity.getRegisteredAt(),
            entity.getAge(),
            entity.getWeight(),
            entity.getHeight(),
            entity.getImc(),
            entity.getBodyFat(),
            entity.getFatMass(),
            entity.getMuscleMass(),
            entity.getChest(),
            entity.getWaist(),
            entity.getAbdomen(),
            entity.getHip(),
            entity.getRightArm(),
            entity.getLeftArm(),
            entity.getRightThigh(),
            entity.getLeftThigh(),
            entity.getActivityLevel(),
            entity.getNotes(),
            entity.getFrontViewPhotoUrl(),
            entity.getBackViewPhotoUrl(),
            entity.getLeftViewPhotoUrl(),
            entity.getRightViewPhotoUrl()
        );
    }
}
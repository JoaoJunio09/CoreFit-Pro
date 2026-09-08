package br.com.joaojuniodev.corefitpro.mapper.trainingPlain;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.mapper.personalTrainer.PersonalTrainerMapper;
import br.com.joaojuniodev.corefitpro.mapper.trainee.TraineeMapper;
import br.com.joaojuniodev.corefitpro.mapper.trainingItem.TrainingItemMapper;
import br.com.joaojuniodev.corefitpro.personalTrainer.repository.PersonalTrainerRepository;
import br.com.joaojuniodev.corefitpro.trainee.repository.TraineeRepository;
import br.com.joaojuniodev.corefitpro.trainingPlain.dto.request.TrainingPlainRequestDTO;
import br.com.joaojuniodev.corefitpro.trainingPlain.dto.response.TrainingPlainResponseDTO;
import br.com.joaojuniodev.corefitpro.trainingPlain.model.TrainingPlain;
import org.springframework.stereotype.Component;

@Component
public class TrainingPlainMapper implements ObjectMapper<TrainingPlain, TrainingPlainResponseDTO, TrainingPlainRequestDTO> {

    private final PersonalTrainerRepository personalTrainerRepository;
    private final TraineeRepository traineeRepository;
    private final PersonalTrainerMapper personalTrainerMapper;
    private final TraineeMapper traineeMapper;
    private final TrainingItemMapper trainingItemMapper;

    public TrainingPlainMapper(PersonalTrainerRepository personalTrainerRepository, TraineeRepository traineeRepository, PersonalTrainerMapper personalTrainerMapper, TraineeMapper traineeMapper, TrainingItemMapper trainingItemMapper) {
        this.personalTrainerRepository = personalTrainerRepository;
        this.traineeRepository = traineeRepository;
        this.personalTrainerMapper = personalTrainerMapper;
        this.traineeMapper = traineeMapper;
        this.trainingItemMapper = trainingItemMapper;
    }

    @Override
    public TrainingPlain toEntity(TrainingPlainRequestDTO request) {
        var personalTrainer = personalTrainerRepository.findById(request.personalTrainerId())
            .orElseThrow(() -> new NotFoundException("Not found Personal Trainer Id: " + request.personalTrainerId()));
        var trainee = traineeRepository.findById(request.traineeId())
            .orElseThrow(() -> new NotFoundException("Not found Trainee Id: " + request.traineeId()));

        TrainingPlain trainingPlain = new TrainingPlain();
        trainingPlain.setId(request.id());
        trainingPlain.setDescription(request.description());
        trainingPlain.setObjective(request.objective());
        trainingPlain.setPersonalTrainer(personalTrainer);
        trainingPlain.setTrainee(trainee);
        return trainingPlain;
    }

    @Override
    public TrainingPlainResponseDTO toResponse(TrainingPlain entity) {
        return new TrainingPlainResponseDTO(
            entity.getId(),
            personalTrainerMapper.toResponse(entity.getPersonalTrainer()),
            traineeMapper.toResponse(entity.getTrainee()),
            entity.getDescription(),
            entity.getObjective(),
            entity.getTrainings().stream().map(trainingItemMapper::toResponse).toList()
        );
    }
}
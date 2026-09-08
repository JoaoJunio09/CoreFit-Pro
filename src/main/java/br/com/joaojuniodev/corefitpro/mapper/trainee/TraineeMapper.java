package br.com.joaojuniodev.corefitpro.mapper.trainee;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.mapper.personalTrainer.PersonalTrainerMapper;
import br.com.joaojuniodev.corefitpro.personalTrainer.repository.PersonalTrainerRepository;
import br.com.joaojuniodev.corefitpro.security.repository.UserRepository;
import br.com.joaojuniodev.corefitpro.trainee.dto.request.TraineeRequestDTO;
import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeResponseDTO;
import br.com.joaojuniodev.corefitpro.trainee.model.Trainee;
import org.springframework.stereotype.Component;

@Component
public class TraineeMapper implements ObjectMapper<Trainee, TraineeResponseDTO, TraineeRequestDTO> {

    private final PersonalTrainerRepository personalTrainerRepository;
    private final UserRepository userRepository;

    public TraineeMapper(PersonalTrainerRepository personalTrainerRepository, UserRepository userRepository) {
        this.personalTrainerRepository = personalTrainerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Trainee toEntity(TraineeRequestDTO request) {
        var user = userRepository.findByUserName(request.username());
        var personalTrainer = personalTrainerRepository.findById(request.personalTrainerId())
            .orElseThrow(() -> new NotFoundException("Not found Personal Trainer Id: " + request.personalTrainerId()));

        Trainee trainee = new Trainee();
        trainee.setId(request.id());
        trainee.setFirstName(request.firstName());
        trainee.setLastName(request.lastName());
        trainee.setUser(user);
        trainee.setPersonalTrainer(personalTrainer);
        return trainee;
    }

    @Override
    public TraineeResponseDTO toResponse(Trainee entity) {
        return new TraineeResponseDTO(
            entity.getId(),
            entity.getFirstName(),
            entity.getLastName()
        );
    }
}
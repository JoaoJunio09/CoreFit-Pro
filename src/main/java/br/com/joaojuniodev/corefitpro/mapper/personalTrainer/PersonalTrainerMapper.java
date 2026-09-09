package br.com.joaojuniodev.corefitpro.mapper.personalTrainer;

import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.personalTrainer.dto.request.PersonalTrainerRequestDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.PersonalTrainerResponseDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.PersonalTrainerSummaryDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.model.PersonalTrainer;
import br.com.joaojuniodev.corefitpro.security.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class PersonalTrainerMapper implements ObjectMapper<PersonalTrainer, PersonalTrainerResponseDTO, PersonalTrainerRequestDTO> {

    private final UserRepository userRepository;

    public PersonalTrainerMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public PersonalTrainer toEntity(PersonalTrainerRequestDTO request) {
        var user = userRepository.findByUserName(request.username());

        PersonalTrainer personalTrainer = new PersonalTrainer();
        personalTrainer.setId(request.id());
        personalTrainer.setFirstName(request.firstName());
        personalTrainer.setLastName(request.lastName());
        personalTrainer.setUser(user);
        return personalTrainer;
    }

    @Override
    public PersonalTrainerResponseDTO toResponse(PersonalTrainer entity) {
        return new PersonalTrainerResponseDTO(
            entity.getId(),
            entity.getFirstName(),
            entity.getLastName()
        );
    }

    public PersonalTrainerSummaryDTO toSummary(PersonalTrainer entity) {
        return new PersonalTrainerSummaryDTO(entity.getId(), entity.getFirstName(), entity.getLastName());
    }
}
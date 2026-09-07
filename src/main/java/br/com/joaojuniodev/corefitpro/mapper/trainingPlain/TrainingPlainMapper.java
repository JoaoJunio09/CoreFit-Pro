package br.com.joaojuniodev.corefitpro.mapper.trainingPlain;

import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.trainingPlain.dto.request.TrainingPlainRequestDTO;
import br.com.joaojuniodev.corefitpro.trainingPlain.dto.response.TrainingPlainResponseDTO;
import br.com.joaojuniodev.corefitpro.trainingPlain.model.TrainingPlain;
import org.springframework.stereotype.Component;

@Component
public class TrainingPlainMapper implements ObjectMapper<TrainingPlain, TrainingPlainResponseDTO, TrainingPlainRequestDTO> {



    @Override
    public TrainingPlain toEntity(TrainingPlainRequestDTO request) {
        return null;
    }

    @Override
    public TrainingPlainResponseDTO toResponse(TrainingPlain entity) {
        return null;
    }
}
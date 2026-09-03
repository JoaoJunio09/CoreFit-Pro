package br.com.joaojuniodev.corefitpro.mapper.muscleGroup;


import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.muscleGroup.dto.request.MuscleGroupRequestDTO;
import br.com.joaojuniodev.corefitpro.muscleGroup.dto.response.MuscleGroupResponseDTO;
import br.com.joaojuniodev.corefitpro.muscleGroup.model.MuscleGroup;
import org.springframework.stereotype.Component;

@Component
public class MuscleGroupMapper implements ObjectMapper<MuscleGroup, MuscleGroupResponseDTO, MuscleGroupRequestDTO> {
    @Override
    public MuscleGroup toEntity(MuscleGroupRequestDTO request) {
        return null;
    }

    @Override
    public MuscleGroupResponseDTO toResponse(MuscleGroup entity) {
        return null;
    }
}
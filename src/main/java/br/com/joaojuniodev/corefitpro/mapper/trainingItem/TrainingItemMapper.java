package br.com.joaojuniodev.corefitpro.mapper.trainingItem;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.mapper.training.TrainingMapper;
import br.com.joaojuniodev.corefitpro.training.repository.TrainingRepository;
import br.com.joaojuniodev.corefitpro.trainingItem.dto.request.TrainingItemRequestDTO;
import br.com.joaojuniodev.corefitpro.trainingItem.dto.response.TrainingItemResponseDTO;
import br.com.joaojuniodev.corefitpro.trainingItem.model.TrainingItem;
import org.springframework.stereotype.Component;

@Component
public class TrainingItemMapper implements ObjectMapper<TrainingItem, TrainingItemResponseDTO, TrainingItemRequestDTO> {

    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;

    public TrainingItemMapper(TrainingRepository trainingRepository, TrainingMapper trainingMapper) {
        this.trainingRepository = trainingRepository;
        this.trainingMapper = trainingMapper;
    }

    @Override
    public TrainingItem toEntity(TrainingItemRequestDTO request) {
        var training = trainingRepository.findById(request.trainingId())
            .orElseThrow(() -> new NotFoundException("Not found Training Id: " + request.trainingId()));
        TrainingItem trainingItem = new TrainingItem();
        trainingItem.setId(request.id());
        trainingItem.setDayOfWeek(request.dayOfWeek());
        trainingItem.setTraining(training);
        return trainingItem;
    }

    @Override
    public TrainingItemResponseDTO toResponse(TrainingItem entity) {
        return new TrainingItemResponseDTO(
            entity.getId(),
            entity.getDayOfWeek(),
            trainingMapper.toResponse(entity.getTraining())
        );
    }
}
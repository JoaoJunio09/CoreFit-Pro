package br.com.joaojuniodev.corefitpro.mapper.recentAcitivty;

import br.com.joaojuniodev.corefitpro.mapper.ObjectMapper;
import br.com.joaojuniodev.corefitpro.recentAcitivty.dto.request.RecentActivityRequestDTO;
import br.com.joaojuniodev.corefitpro.recentAcitivty.dto.response.RecentActivityResponseDTO;
import br.com.joaojuniodev.corefitpro.recentAcitivty.model.RecentActivity;
import org.springframework.stereotype.Component;

@Component
public class RecentActivityMapper implements ObjectMapper<RecentActivity, RecentActivityResponseDTO, RecentActivityRequestDTO> {
    @Override
    public RecentActivity toEntity(RecentActivityRequestDTO request) {
        RecentActivity recentActivity = new RecentActivity();
        recentActivity.setId(request.id());
        recentActivity.setRegisteredAt(request.registeredAt());
        recentActivity.setDescription(request.description());
        return recentActivity;
    }

    @Override
    public RecentActivityResponseDTO toResponse(RecentActivity entity) {
        return new RecentActivityResponseDTO(
            entity.getId(),
            entity.getRegisteredAt(),
            entity.getDescription()
        );
    }
}
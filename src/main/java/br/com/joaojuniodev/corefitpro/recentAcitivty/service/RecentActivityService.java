package br.com.joaojuniodev.corefitpro.recentAcitivty.service;

import br.com.joaojuniodev.corefitpro.mapper.recentAcitivty.RecentActivityMapper;
import br.com.joaojuniodev.corefitpro.recentAcitivty.dto.request.RecentActivityRequestDTO;
import br.com.joaojuniodev.corefitpro.recentAcitivty.dto.response.RecentActivityResponseDTO;
import br.com.joaojuniodev.corefitpro.recentAcitivty.repository.RecentActivityRepository;
import br.com.joaojuniodev.corefitpro.recentAcitivty.repository.spec.RecentActivitySpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecentActivityService {
    private static final Logger logger = LoggerFactory.getLogger(RecentActivityService.class.getName());

    private final RecentActivityRepository repository;
    private final RecentActivityMapper mapper;

    public RecentActivityService(RecentActivityRepository repository, RecentActivityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<RecentActivityResponseDTO> getAll(UUID personalTrainerId) {
        logger.info("Getting All Recent Activities");

        RecentActivitySpecification spec = new RecentActivitySpecification();
        spec.addToSpecifications(personalTrainerId);

        return repository
            .findAll(spec.apply())
            .stream()
            .map(mapper::toResponse)
            .limit(4)
            .toList();
    }

    public RecentActivityResponseDTO create(RecentActivityRequestDTO recentActivity) {
        logger.info("Creating new Recent Activity");

        var recentActivityCreated = repository.save(mapper.toEntity(recentActivity));
        return mapper.toResponse(recentActivityCreated);
    }
}
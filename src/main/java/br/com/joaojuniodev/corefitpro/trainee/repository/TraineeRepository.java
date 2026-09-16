package br.com.joaojuniodev.corefitpro.trainee.repository;

import br.com.joaojuniodev.corefitpro.trainee.model.Trainee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, UUID> {

    List<Trainee> findAll(Specification<Trainee> spec);

    Long countByUserEnabledTrueAndPersonalTrainerId(UUID personalTrainerId);
}
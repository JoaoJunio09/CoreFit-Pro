package br.com.joaojuniodev.corefitpro.trainee.repository;

import br.com.joaojuniodev.corefitpro.trainee.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, UUID> {
}
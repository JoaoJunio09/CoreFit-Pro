package br.com.joaojuniodev.corefitpro.trainingPlain.repository;

import br.com.joaojuniodev.corefitpro.trainingPlain.model.TrainingPlain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrainingPlainRepository extends JpaRepository<TrainingPlain, UUID> {
}
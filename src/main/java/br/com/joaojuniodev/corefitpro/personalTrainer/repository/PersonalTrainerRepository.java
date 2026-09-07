package br.com.joaojuniodev.corefitpro.personalTrainer.repository;

import br.com.joaojuniodev.corefitpro.personalTrainer.model.PersonalTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonalTrainerRepository extends JpaRepository<PersonalTrainer, UUID> {
}
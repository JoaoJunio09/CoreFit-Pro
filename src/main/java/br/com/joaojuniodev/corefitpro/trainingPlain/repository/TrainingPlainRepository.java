package br.com.joaojuniodev.corefitpro.trainingPlain.repository;

import br.com.joaojuniodev.corefitpro.trainingPlain.model.TrainingPlain;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TrainingPlainRepository extends JpaRepository<TrainingPlain, UUID> {

    @EntityGraph(attributePaths = {"personalTrainer", "trainee"})
    List<TrainingPlain> findAll();

    @EntityGraph(attributePaths = {
        "personalTrainer",
        "trainee",
        "trainings",
        "trainings.training",
        "trainings.training.muscleGroups",
        "trainings.training.exerciseItems",
        "trainings.training.exerciseItems.exercise",
    })
    Optional<TrainingPlain> findById(UUID id);
}
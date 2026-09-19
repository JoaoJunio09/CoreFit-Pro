package br.com.joaojuniodev.corefitpro.training.repository;

import br.com.joaojuniodev.corefitpro.training.model.Training;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrainingRepository extends JpaRepository<Training, UUID> {

    @EntityGraph(attributePaths = {
        "muscleGroups",
        "exerciseItems",
        "exerciseItems.exercise"
    })
    List<Training> findAll(Specification<Training> spec);
}
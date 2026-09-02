package br.com.joaojuniodev.corefitpro.exercise.repository;

import br.com.joaojuniodev.corefitpro.exercise.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {
}
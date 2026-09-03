package br.com.joaojuniodev.corefitpro.exerciseItem.repository;

import br.com.joaojuniodev.corefitpro.exerciseItem.model.ExerciseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExerciseItemRepository extends JpaRepository<ExerciseItem, UUID> {
}
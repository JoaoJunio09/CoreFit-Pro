package br.com.joaojuniodev.corefitpro.muscleGroup.repository;

import br.com.joaojuniodev.corefitpro.muscleGroup.model.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, UUID> {
}
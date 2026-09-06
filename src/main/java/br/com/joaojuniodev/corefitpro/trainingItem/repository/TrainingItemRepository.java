package br.com.joaojuniodev.corefitpro.trainingItem.repository;

import br.com.joaojuniodev.corefitpro.trainingItem.model.TrainingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrainingItemRepository extends JpaRepository<TrainingItem, UUID> {
}
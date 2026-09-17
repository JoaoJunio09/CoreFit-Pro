package br.com.joaojuniodev.corefitpro.physicalAssessment.repository;

import br.com.joaojuniodev.corefitpro.physicalAssessment.model.PhysicalAssessment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhysicalAssessmentRepository extends JpaRepository<PhysicalAssessment, UUID> {

    List<PhysicalAssessment> findAll(Specification<PhysicalAssessment> spec);
}
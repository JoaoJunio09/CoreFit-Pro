package br.com.joaojuniodev.corefitpro.physicalAssessment.repository.spec;

import br.com.joaojuniodev.corefitpro.physicalAssessment.model.PhysicalAssessment;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class PhysicalAssessmentSpecification {

    Specification<PhysicalAssessment> spec;

    public PhysicalAssessmentSpecification() {
        this.spec = Specification.where(null);
    }

    public Specification<PhysicalAssessment> apply() {
        return this.spec;
    }

    public void addToSpecifications(UUID traineeId) {
        if (traineeId != null) hasTrainee(traineeId);
    }

    private void hasTrainee(UUID traineeId) {
        this.spec = this.spec.and((root, query, cb) ->
            cb.equal(root.get("trainee").get("id"), traineeId));
    }
}
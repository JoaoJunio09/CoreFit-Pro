package br.com.joaojuniodev.corefitpro.recentAcitivty.repository.spec;

import br.com.joaojuniodev.corefitpro.recentAcitivty.model.RecentActivity;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class RecentActivitySpecification {

    Specification<RecentActivity> spec;

    public RecentActivitySpecification() {
        this.spec = Specification.where(null);
    }

    public Specification<RecentActivity> apply() {
        return this.spec;
    }

    public void addToSpecifications(UUID personalTrainerId) {
        if (personalTrainerId != null) hasPersonalTrainer(personalTrainerId);
    }

    private void hasPersonalTrainer(UUID personalTrainerId) {
        this.spec = this.spec.and((root, query, cb) ->
            cb.equal(root.get("personalTrainer").get("id"), personalTrainerId));
    }
}
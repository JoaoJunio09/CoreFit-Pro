package br.com.joaojuniodev.corefitpro.trainee.repository.spec;

import br.com.joaojuniodev.corefitpro.trainee.model.Trainee;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class TraineeSpecification {

    private Specification<Trainee> spec;

    public TraineeSpecification() {
        this.spec = Specification.where(null);
    }

    public Specification<Trainee> apply() {
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
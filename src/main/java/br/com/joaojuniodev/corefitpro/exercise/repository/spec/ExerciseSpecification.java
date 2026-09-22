package br.com.joaojuniodev.corefitpro.exercise.repository.spec;

import br.com.joaojuniodev.corefitpro.exercise.model.Exercise;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class ExerciseSpecification {

    Specification<Exercise> spec;

    public ExerciseSpecification() {
        this.spec = Specification.where(null);
    }

    public Specification<Exercise> apply() {
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
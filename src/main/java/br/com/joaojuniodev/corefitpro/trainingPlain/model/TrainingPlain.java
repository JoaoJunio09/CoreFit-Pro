package br.com.joaojuniodev.corefitpro.trainingPlain.model;

import br.com.joaojuniodev.corefitpro.trainingItem.model.TrainingItem;
import br.com.joaojuniodev.corefitpro.trainingPlain.enums.ObjectiveTraining;
import br.com.joaojuniodev.corefitpro.personalTrainer.model.PersonalTrainer;
import br.com.joaojuniodev.corefitpro.trainee.model.Trainee;
import br.com.joaojuniodev.corefitpro.training.model.Training;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "training_plans")
public class TrainingPlain {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "personal_trainer_id")
    private PersonalTrainer personalTrainer;

    @OneToOne
    @JoinColumn(name = "trainee_id")
    private Trainee trainee;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private ObjectiveTraining objective;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "training_plain_training_items",
        joinColumns = @JoinColumn(name = "training_plan_id"),
        inverseJoinColumns = @JoinColumn(name = "training_item_id")
    )
    private List<TrainingItem> trainings;

    public TrainingPlain() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PersonalTrainer getPersonalTrainer() {
        return personalTrainer;
    }

    public void setPersonalTrainer(PersonalTrainer personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ObjectiveTraining getObjective() {
        return objective;
    }

    public void setObjective(ObjectiveTraining objective) {
        this.objective = objective;
    }

    public List<TrainingItem> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<TrainingItem> trainings) {
        this.trainings = trainings;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        TrainingPlain that = (TrainingPlain) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
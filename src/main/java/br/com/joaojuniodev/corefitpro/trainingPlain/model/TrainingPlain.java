package br.com.joaojuniodev.corefitpro.trainingPlain.model;

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
        name = "training_plain_workout",
        joinColumns = @JoinColumn(name = "training_plan_id"),
        inverseJoinColumns = @JoinColumn(name = "workout_id")
    )
    private List<Training> workouts;

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

    public List<Training> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Training> workouts) {
        this.workouts = workouts;
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
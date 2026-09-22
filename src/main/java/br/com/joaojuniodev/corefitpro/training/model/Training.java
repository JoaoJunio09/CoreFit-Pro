package br.com.joaojuniodev.corefitpro.training.model;

import br.com.joaojuniodev.corefitpro.exerciseItem.model.ExerciseItem;
import br.com.joaojuniodev.corefitpro.personalTrainer.model.PersonalTrainer;
import br.com.joaojuniodev.corefitpro.muscleGroup.model.MuscleGroup;
import jakarta.persistence.*;

import java.util.*;

@Table(name = "trainings")
@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "personal_trainer_id")
    private PersonalTrainer personalTrainer;

    @ManyToMany
    @JoinTable(
        name = "training_muscle_groups",
        joinColumns = @JoinColumn(name = "training_id"),
        inverseJoinColumns = @JoinColumn(name = "muscle_group_id")
    )
    private Set<MuscleGroup> muscleGroups = new HashSet<>();

    @OneToMany(mappedBy = "training")
    private Set<ExerciseItem> exerciseItems = new HashSet<>();

    public Training() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PersonalTrainer getPersonalTrainer() {
        return personalTrainer;
    }

    public void setPersonalTrainer(PersonalTrainer personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public Set<MuscleGroup> getMuscleGroups() {
        return muscleGroups;
    }

    public void setMuscleGroups(Set<MuscleGroup> muscleGroups) {
        this.muscleGroups = muscleGroups;
    }

    public Set<ExerciseItem> getExerciseItems() {
        return exerciseItems;
    }

    public void setExerciseItems(Set<ExerciseItem> exerciseItems) {
        this.exerciseItems = exerciseItems;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Training training = (Training) o;
        return Objects.equals(getId(), training.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
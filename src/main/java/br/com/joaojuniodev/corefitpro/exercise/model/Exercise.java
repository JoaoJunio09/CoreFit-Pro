package br.com.joaojuniodev.corefitpro.exercise.model;

import br.com.joaojuniodev.corefitpro.muscleGroup.model.MuscleGroup;
import br.com.joaojuniodev.corefitpro.personalTrainer.model.PersonalTrainer;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String name;

    @Column
    private Boolean system;

    @Column
    private Boolean favorite;

    @Column
    private String photo;

    @Column
    private String video;

    @ManyToOne
    @JoinColumn(name = "personal_trainer_id")
    private PersonalTrainer personalTrainer;

    @ManyToMany
    @JoinTable(
        name = "exercise_muscle_groups",
        joinColumns = @JoinColumn(name = "exercise_id"),
        inverseJoinColumns = @JoinColumn(name = "muscle_group_id")
    )
    private List<MuscleGroup> muscleGroups = new ArrayList<>();

    public Exercise() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public PersonalTrainer getPersonalTrainer() {
        return personalTrainer;
    }

    public void setPersonalTrainer(PersonalTrainer personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public List<MuscleGroup> getMuscleGroups() {
        return muscleGroups;
    }

    public void setMuscleGroups(List<MuscleGroup> muscleGroups) {
        this.muscleGroups = muscleGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Exercise exercise = (Exercise) o;
        return Objects.equals(getId(), exercise.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
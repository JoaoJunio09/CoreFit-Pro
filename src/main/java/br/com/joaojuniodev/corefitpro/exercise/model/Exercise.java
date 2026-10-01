package br.com.joaojuniodev.corefitpro.exercise.model;

import br.com.joaojuniodev.corefitpro.muscleGroup.model.MuscleGroup;
import br.com.joaojuniodev.corefitpro.personalTrainer.model.PersonalTrainer;
import jakarta.persistence.*;

import java.util.*;

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

    @Column(name = "photo_key")
    private String photoKey;

    @Column(name = "video_key")
    private String videoKey;

    @Column(name = "photo_file_id")
    private String photoFileId;

    @Column(name = "video_file_id")
    private String videoFileId;

    @ManyToOne
    @JoinColumn(name = "personal_trainer_id")
    private PersonalTrainer personalTrainer;

    @ManyToMany
    @JoinTable(
        name = "exercise_muscle_groups",
        joinColumns = @JoinColumn(name = "exercise_id"),
        inverseJoinColumns = @JoinColumn(name = "muscle_group_id")
    )
    private Set<MuscleGroup> muscleGroups = new HashSet<>();

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

    public String getPhotoKey() {
        return photoKey;
    }

    public void setPhotoKey(String photoKey) {
        this.photoKey = photoKey;
    }

    public String getVideoKey() {
        return videoKey;
    }

    public void setVideoKey(String videoKey) {
        this.videoKey = videoKey;
    }

    public String getPhotoFileId() {
        return photoFileId;
    }

    public void setPhotoFileId(String photoFileId) {
        this.photoFileId = photoFileId;
    }

    public String getVideoFileId() {
        return videoFileId;
    }

    public void setVideoFileId(String videoFileId) {
        this.videoFileId = videoFileId;
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
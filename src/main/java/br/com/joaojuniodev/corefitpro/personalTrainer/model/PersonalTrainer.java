package br.com.joaojuniodev.corefitpro.personalTrainer.model;

import br.com.joaojuniodev.corefitpro.trainee.model.Trainee;
import br.com.joaojuniodev.corefitpro.training.model.Training;
import br.com.joaojuniodev.corefitpro.trainingPlain.model.TrainingPlain;
import br.com.joaojuniodev.corefitpro.security.model.User;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "personals_trainers")
public class PersonalTrainer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "personalTrainer")
    private Set<Trainee> trainees;

    @OneToMany(mappedBy = "personalTrainer")
    private Set<TrainingPlain> trainingPlains;

    @OneToMany(mappedBy = "personalTrainer")
    private List<Training> trainings;

    public PersonalTrainer() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(Set<Trainee> trainees) {
        this.trainees = trainees;
    }

    public Set<TrainingPlain> getTrainingPlains() {
        return trainingPlains;
    }

    public void setTrainingPlains(Set<TrainingPlain> trainingPlains) {
        this.trainingPlains = trainingPlains;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        PersonalTrainer that = (PersonalTrainer) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
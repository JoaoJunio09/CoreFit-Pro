package br.com.joaojuniodev.corefitpro.models;

import jakarta.persistence.*;

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
}
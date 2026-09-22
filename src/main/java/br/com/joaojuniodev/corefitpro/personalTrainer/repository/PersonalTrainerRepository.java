package br.com.joaojuniodev.corefitpro.personalTrainer.repository;

import br.com.joaojuniodev.corefitpro.personalTrainer.model.PersonalTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonalTrainerRepository extends JpaRepository<PersonalTrainer, UUID> {

    @Query("SELECT pt FROM PersonalTrainer pt WHERE pt.user.username = :username")
    Optional<PersonalTrainer> findByUsername(@Param("username") String username);
}
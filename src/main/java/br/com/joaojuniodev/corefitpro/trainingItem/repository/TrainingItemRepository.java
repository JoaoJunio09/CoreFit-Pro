package br.com.joaojuniodev.corefitpro.trainingItem.repository;

import br.com.joaojuniodev.corefitpro.trainingItem.dto.projection.NotCompletedTrainingsProjection;
import br.com.joaojuniodev.corefitpro.trainingItem.dto.projection.WeeklyRhythmProjection;
import br.com.joaojuniodev.corefitpro.trainingItem.enums.DaysOfWeek;
import br.com.joaojuniodev.corefitpro.trainingItem.model.TrainingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrainingItemRepository extends JpaRepository<TrainingItem, UUID> {

    @Query("""
        SELECT COUNT(ti.id)
        FROM TrainingItem ti
        WHERE ti.dayOfWeek = :dayOfWeek
          AND ti.trainingPlain.personalTrainer.id = :personalTrainerId
    """)
    Long countByDayOfWeekAndPersonalTrainerId(
        @Param("dayOfWeek") DaysOfWeek dayOfWeek,
        @Param("personalTrainerId") UUID personalTrainerId
    );

    @Query("""
        SELECT COUNT(ti.id)
        FROM TrainingItem ti
        WHERE ti.dayOfWeek = :dayOfWeek
          AND ti.completed = false
          AND ti.trainingPlain.personalTrainer.id = :personalTrainerId
    """)
    Long countPendingByDayOfWeekAndPersonalTrainerId(
        @Param("dayOfWeek") DaysOfWeek dayOfWeek,
        @Param("personalTrainerId") UUID personalTrainerId
    );

    @Query("""
        SELECT COUNT(ti.id)
        FROM TrainingItem ti
        WHERE ti.dayOfWeek = :dayOfWeek
          AND ti.completed = true
          AND ti.trainingPlain.personalTrainer.id = :personalTrainerId
    """)
    Long countCompletedByDayOfWeekAndPersonalTrainerId(
        @Param("dayOfWeek") DaysOfWeek dayOfWeek,
        @Param("personalTrainerId") UUID personalTrainerId
    );

    @Query("""
        SELECT COUNT(DISTINCT ti.trainingPlain.trainee.id)
        FROM TrainingItem ti
        WHERE ti.training.id = :trainingId
    """)
    Long countTraineesUseThisTraining(UUID trainingId);

    @Query("""
        SELECT ti
        FROM TrainingItem ti
        WHERE ti.trainingPlain.trainee.id = :traineeId
    """)
    List<TrainingItem> findByTrainee(@Param("traineeId") UUID traineeId);

    @Query("""
        SELECT ti
        FROM TrainingItem ti
        WHERE ti.dayOfWeek = :dayOfWeek
          AND ti.trainingPlain.personalTrainer.id = :personalTrainerId
    """)
    List<TrainingItem> findByDayOfWeekAndPersonalTrainerId(
        @Param("dayOfWeek") DaysOfWeek dayOfWeek,
        @Param("personalTrainerId") UUID personalTrainerId
    );

    @Query("""
        SELECT
            ti.trainingPlain.trainee.id AS traineeId,
            COUNT(ti.id) AS countIncompleteTraining,
            CONCAT(
                ti.trainingPlain.trainee.firstName,
                ' ',
                ti.trainingPlain.trainee.lastName
            ) AS traineeName
        FROM TrainingItem ti
        WHERE ti.completed = false
          AND ti.trainingPlain.personalTrainer.id = :personalTrainerId
        GROUP BY
            ti.trainingPlain.trainee.id,
            ti.trainingPlain.trainee.firstName,
            ti.trainingPlain.trainee.lastName
    """)
    List<NotCompletedTrainingsProjection> findTrainingsIncomplete(
        @Param("personalTrainerId") UUID personalTrainerId
    );

    @Query("""
        SELECT
            ti.dayOfWeek AS dayOfWeek,
            COUNT(ti.id) AS totalTrainings,
            SUM(
                CASE
                    WHEN ti.completed = true THEN 1
                    ELSE 0
                END
            ) AS completedTrainings
        FROM TrainingItem ti
        WHERE ti.trainingPlain.personalTrainer.id = :personalTrainerId
        GROUP BY ti.dayOfWeek
        ORDER BY ti.dayOfWeek
    """)
    List<WeeklyRhythmProjection> findWeeklyRhythm(
        @Param("personalTrainerId") UUID personalTrainerId
    );
}
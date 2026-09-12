package br.com.joaojuniodev.corefitpro.trainingItem.repository;

import br.com.joaojuniodev.corefitpro.trainingItem.dto.projection.NotCompletedTrainingsProjection;
import br.com.joaojuniodev.corefitpro.trainingItem.dto.projection.WeeklyRhythmProjection;
import br.com.joaojuniodev.corefitpro.trainingItem.enums.DaysOfWeek;
import br.com.joaojuniodev.corefitpro.trainingItem.model.TrainingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrainingItemRepository extends JpaRepository<TrainingItem, UUID> {

    Long countByDayOfWeek(DaysOfWeek dayOfWeek);

    Long countByDayOfWeekAndCompletedFalse(DaysOfWeek dayOfWeek);

    Long countByDayOfWeekAndCompletedTrue(DaysOfWeek dasOfWeek);

    List<TrainingItem> findByDayOfWeek(DaysOfWeek dayOfWeek);

    @Query("""
        SELECT
            ti.trainingPlain.trainee.id,
            COUNT(ti.id) AS countIncompleteTraining,
            CONCAT(
                ti.trainingPlain.trainee.firstName,
                ' ',
                ti.trainingPlain.trainee.lastName
            ) as traineeName
        FROM TrainingItem ti
        WHERE ti.completed = false
        GROUP BY
            ti.trainingPlain.trainee.id,
            ti.trainingPlain.trainee.firstName,
            ti.trainingPlain.trainee.lastName
    """)
    List<NotCompletedTrainingsProjection> findTrainingsIncomplete();

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
        GROUP BY ti.dayOfWeek
        ORDER BY ti.dayOfWeek
    """)
    List<WeeklyRhythmProjection> findWeeklyRhythm();
}
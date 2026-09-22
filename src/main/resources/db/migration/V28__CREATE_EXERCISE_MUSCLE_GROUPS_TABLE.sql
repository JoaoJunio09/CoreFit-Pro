CREATE TABLE exercise_muscle_groups (
    exercise_id     UUID NOT NULL,
    muscle_group_id UUID NOT NULL,
    CONSTRAINT pk_exercise_muscle_groups PRIMARY KEY (exercise_id, muscle_group_id),
    CONSTRAINT fk_emg_exercise FOREIGN KEY (exercise_id) REFERENCES exercises (id) ON DELETE CASCADE,
    CONSTRAINT fk_emg_muscle_group FOREIGN KEY (muscle_group_id) REFERENCES muscle_groups (id) ON DELETE CASCADE
);

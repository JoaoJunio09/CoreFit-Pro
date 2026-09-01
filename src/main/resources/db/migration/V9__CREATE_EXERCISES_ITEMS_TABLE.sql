CREATE TABLE exercises_items (
    id           CHAR(36) NOT NULL,
    exercise_id  CHAR(36) NOT NULL,
    repetitions  INT      NULL,
    series       INT      NULL,
    training_id  CHAR(36) NULL,
    CONSTRAINT pk_exercises_items PRIMARY KEY (id),
    CONSTRAINT fk_exercises_items_exercise FOREIGN KEY (exercise_id) REFERENCES exercises (id),
    CONSTRAINT fk_exercises_items_training FOREIGN KEY (training_id) REFERENCES trainings (id) ON DELETE CASCADE
) ENGINE = InnoDB;

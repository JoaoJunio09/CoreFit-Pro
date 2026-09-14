CREATE TABLE exercises_items (
    id          UUID NOT NULL DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL,
    repetitions INT  NULL,
    series      INT  NULL,
    training_id UUID NULL,
    CONSTRAINT pk_exercises_items PRIMARY KEY (id),
    CONSTRAINT fk_exercises_items_exercise FOREIGN KEY (exercise_id) REFERENCES exercises (id),
    CONSTRAINT fk_exercises_items_training FOREIGN KEY (training_id) REFERENCES trainings (id) ON DELETE CASCADE
);

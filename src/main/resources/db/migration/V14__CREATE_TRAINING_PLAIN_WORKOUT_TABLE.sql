CREATE TABLE training_plain_workout (
    training_plan_id UUID NOT NULL,
    workout_id        UUID NOT NULL,
    CONSTRAINT pk_training_plain_workout PRIMARY KEY (training_plan_id, workout_id),
    CONSTRAINT fk_tpw_training_plan FOREIGN KEY (training_plan_id) REFERENCES training_plans (id) ON DELETE CASCADE,
    CONSTRAINT fk_tpw_workout FOREIGN KEY (workout_id) REFERENCES trainings (id) ON DELETE CASCADE
);

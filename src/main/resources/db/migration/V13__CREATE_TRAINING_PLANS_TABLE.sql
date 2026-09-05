CREATE TABLE training_plans (
    id                  UUID         NOT NULL DEFAULT gen_random_uuid(),
    personal_trainer_id UUID         NULL,
    trainee_id          UUID         NOT NULL,
    description         VARCHAR(500) NULL,
    objective           VARCHAR(20)  NOT NULL,
    CONSTRAINT pk_training_plans PRIMARY KEY (id),
    CONSTRAINT uq_training_plans_trainee UNIQUE (trainee_id),
    CONSTRAINT fk_training_plans_personal_trainer FOREIGN KEY (personal_trainer_id) REFERENCES personals_trainers (id) ON DELETE SET NULL,
    CONSTRAINT fk_training_plans_trainee FOREIGN KEY (trainee_id) REFERENCES trainees (id) ON DELETE CASCADE
);

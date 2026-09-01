CREATE TABLE training_plans (
    id                  CHAR(36)     NOT NULL,
    personal_trainer_id CHAR(36)     NULL,
    trainee_id          CHAR(36)     NOT NULL,
    description         VARCHAR(500) NULL,
    objective           VARCHAR(20)  NOT NULL,
    CONSTRAINT pk_training_plans PRIMARY KEY (id),
    CONSTRAINT uq_training_plans_trainee UNIQUE (trainee_id),
    CONSTRAINT fk_training_plans_personal_trainer FOREIGN KEY (personal_trainer_id) REFERENCES personals_trainers (id) ON DELETE SET NULL,
    CONSTRAINT fk_training_plans_trainee FOREIGN KEY (trainee_id) REFERENCES trainees (id) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE trainings (
    id                  UUID         NOT NULL DEFAULT gen_random_uuid(),
    title               VARCHAR(100) NOT NULL,
    description         VARCHAR(500) NULL,
    personal_trainer_id UUID         NULL,
    CONSTRAINT pk_trainings PRIMARY KEY (id),
    CONSTRAINT fk_trainings_personal_trainer FOREIGN KEY (personal_trainer_id) REFERENCES personals_trainers (id) ON DELETE SET NULL
);

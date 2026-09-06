ALTER TABLE trainings
    ADD COLUMN personal_trainer_id UUID NULL;

ALTER TABLE trainings
    ADD CONSTRAINT fk_trainings_personal_trainer
        FOREIGN KEY (personal_trainer_id) REFERENCES personals_trainers (id) ON DELETE SET NULL;

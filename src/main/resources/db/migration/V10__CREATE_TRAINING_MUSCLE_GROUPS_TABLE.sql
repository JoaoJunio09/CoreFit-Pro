CREATE TABLE training_muscle_groups (
    training_id     CHAR(36) NOT NULL,
    muscle_group_id CHAR(36) NOT NULL,
    CONSTRAINT pk_training_muscle_groups PRIMARY KEY (training_id, muscle_group_id),
    CONSTRAINT fk_tmg_training FOREIGN KEY (training_id) REFERENCES trainings (id) ON DELETE CASCADE,
    CONSTRAINT fk_tmg_muscle_group FOREIGN KEY (muscle_group_id) REFERENCES muscle_groups (id) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE trainees (
    id                  CHAR(36)    NOT NULL,
    first_name          VARCHAR(80) NOT NULL,
    last_name           VARCHAR(80) NOT NULL,
    user_id             CHAR(36)    NOT NULL,
    personal_trainer_id CHAR(36)    NULL,
    CONSTRAINT pk_trainees PRIMARY KEY (id),
    CONSTRAINT uq_trainees_user UNIQUE (user_id),
    CONSTRAINT fk_trainees_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_trainees_personal_trainer FOREIGN KEY (personal_trainer_id) REFERENCES personals_trainers (id) ON DELETE SET NULL
) ENGINE = InnoDB;

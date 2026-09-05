CREATE TABLE personals_trainers (
    id         UUID        NOT NULL DEFAULT gen_random_uuid(),
    first_name VARCHAR(80) NOT NULL,
    last_name  VARCHAR(80) NOT NULL,
    user_id    UUID        NOT NULL,
    CONSTRAINT pk_personals_trainers PRIMARY KEY (id),
    CONSTRAINT uq_personals_trainers_user UNIQUE (user_id),
    CONSTRAINT fk_personals_trainers_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE trainings (
    id          UUID         NOT NULL DEFAULT gen_random_uuid(),
    title       VARCHAR(100) NOT NULL,
    description VARCHAR(500) NULL,
    CONSTRAINT pk_trainings PRIMARY KEY (id)
);

CREATE TABLE exercises (
    id    UUID         NOT NULL DEFAULT gen_random_uuid(),
    name  VARCHAR(100) NOT NULL,
    photo VARCHAR(255) NULL,
    video VARCHAR(255) NULL,
    CONSTRAINT pk_exercises PRIMARY KEY (id)
);

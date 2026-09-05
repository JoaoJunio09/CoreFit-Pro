CREATE TABLE muscle_groups (
    id   UUID        NOT NULL DEFAULT gen_random_uuid(),
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_muscle_groups PRIMARY KEY (id),
    CONSTRAINT uq_muscle_groups_name UNIQUE (name)
);

CREATE TABLE muscle_groups (
    id   CHAR(36)    NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_muscle_groups PRIMARY KEY (id),
    CONSTRAINT uq_muscle_groups_name UNIQUE (name)
) ENGINE = InnoDB;

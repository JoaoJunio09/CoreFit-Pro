CREATE TABLE exercises (
    id    CHAR(36)     NOT NULL,
    name  VARCHAR(100) NOT NULL,
    photo VARCHAR(255) NULL,
    video VARCHAR(255) NULL,
    CONSTRAINT pk_exercises PRIMARY KEY (id)
) ENGINE = InnoDB;

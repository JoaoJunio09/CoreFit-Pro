CREATE TABLE trainings (
    id           CHAR(36)     NOT NULL,
    title        VARCHAR(100) NOT NULL,
    description  VARCHAR(500) NULL,
    day_of_week  VARCHAR(20)  NOT NULL,
    CONSTRAINT pk_trainings PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE users (
    id                        CHAR(36)     NOT NULL,
    username                  VARCHAR(50)  NOT NULL,
    password                  VARCHAR(255) NULL,
    full_name                 VARCHAR(150) NOT NULL,
    email                     VARCHAR(150) NOT NULL,
    recovery_email            VARCHAR(150) NOT NULL,
    account_non_expired       BOOLEAN      NOT NULL DEFAULT TRUE,
    account_non_locked        BOOLEAN      NOT NULL DEFAULT TRUE,
    credentials_non_expired   BOOLEAN      NOT NULL DEFAULT TRUE,
    enabled                   BOOLEAN      NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT uq_users_username UNIQUE (username),
    CONSTRAINT uq_users_email UNIQUE (email)
) ENGINE = InnoDB;
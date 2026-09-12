CREATE TABLE recent_activities (
    id                  UUID        NOT NULL DEFAULT gen_random_uuid(),
    registered_at       TIMESTAMP   NOT NULL,
    description         VARCHAR(20) NOT NULL,
    personal_trainer_id UUID        NOT NULL,
    CONSTRAINT pk_recent_activities PRIMARY KEY (id),
    CONSTRAINT fk_recent_activities_personal_trainer FOREIGN KEY (personal_trainer_id) REFERENCES personals_trainers (id) ON DELETE CASCADE
);
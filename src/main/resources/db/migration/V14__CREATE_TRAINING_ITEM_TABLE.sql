CREATE TABLE training_item (
    id          UUID        NOT NULL DEFAULT gen_random_uuid(),
    day_of_week VARCHAR(20) NOT NULL,
    training_id UUID        NOT NULL,
    CONSTRAINT pk_training_item PRIMARY KEY (id),
    CONSTRAINT fk_training_item_training FOREIGN KEY (training_id) REFERENCES trainings (id) ON DELETE CASCADE
);

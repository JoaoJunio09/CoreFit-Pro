CREATE TABLE training_plain_training_items (
    training_plan_id UUID NOT NULL,
    training_item_id UUID NOT NULL,
    CONSTRAINT pk_training_plain_training_items PRIMARY KEY (training_plan_id, training_item_id),
    CONSTRAINT fk_tpti_training_plan FOREIGN KEY (training_plan_id) REFERENCES training_plans (id) ON DELETE CASCADE,
    CONSTRAINT fk_tpti_training_item FOREIGN KEY (training_item_id) REFERENCES training_item (id) ON DELETE CASCADE
);

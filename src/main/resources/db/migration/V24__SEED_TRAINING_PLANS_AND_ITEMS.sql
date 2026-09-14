-- Um plano de treino por aluno (respeitando a constraint de 1 plano por trainee),
-- cada um com seus training_item (dia da semana + treino do catálogo do personal)

DO $$
DECLARE
    mateus_trainee_id  UUID;
    beatriz_trainee_id UUID;
    gabriel_trainee_id UUID;
    camila_trainee_id  UUID;
    diego_trainee_id   UUID;
    juliana_trainee_id UUID;

    lucas_pt_id    UUID;
    fernanda_pt_id UUID;
    rafael_pt_id   UUID;

    plan_id UUID;
BEGIN
    SELECT t.id INTO mateus_trainee_id  FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'mateus';
    SELECT t.id INTO beatriz_trainee_id FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'beatriz';
    SELECT t.id INTO gabriel_trainee_id FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'gabriel';
    SELECT t.id INTO camila_trainee_id  FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'camila';
    SELECT t.id INTO diego_trainee_id   FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'diego';
    SELECT t.id INTO juliana_trainee_id FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'juliana';

    SELECT id INTO lucas_pt_id    FROM personals_trainers WHERE first_name = 'Lucas';
    SELECT id INTO fernanda_pt_id FROM personals_trainers WHERE first_name = 'Fernanda';
    SELECT id INTO rafael_pt_id   FROM personals_trainers WHERE first_name = 'Rafael';

    -- Mateus (Lucas) - hipertrofia, ativo
    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, objective, active)
    VALUES (gen_random_uuid(), lucas_pt_id, mateus_trainee_id, 'Plano de hipertrofia - fase 1', 'HYPERTROPHY', TRUE)
    RETURNING id INTO plan_id;

    INSERT INTO training_item (id, day_of_week, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day, v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 'Treino A - Peito e Tríceps'), ('WEDNESDAY', TRUE, 'Treino B - Costas e Bíceps'), ('FRIDAY', FALSE, 'Treino C - Pernas Completo')) AS v(day, completed, title)
    JOIN trainings tr ON tr.title = v.title;

    -- Beatriz (Lucas) - emagrecimento, ativo
    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, objective, active)
    VALUES (gen_random_uuid(), lucas_pt_id, beatriz_trainee_id, 'Plano de emagrecimento com foco em pernas', 'WEIGHT_LOSS', TRUE)
    RETURNING id INTO plan_id;

    INSERT INTO training_item (id, day_of_week, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day, v.completed, tr.id, plan_id
    FROM (VALUES ('TUESDAY', FALSE, 'Treino A - Peito e Tríceps'), ('THURSDAY', TRUE, 'Treino C - Pernas Completo')) AS v(day, completed, title)
    JOIN trainings tr ON tr.title = v.title;

    -- Gabriel (Fernanda) - hipertrofia, ativo
    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, objective, active)
    VALUES (gen_random_uuid(), fernanda_pt_id, gabriel_trainee_id, 'Plano push/pull/legs', 'HYPERTROPHY', TRUE)
    RETURNING id INTO plan_id;

    INSERT INTO training_item (id, day_of_week, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day, v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 'Treino A - Push'), ('WEDNESDAY', TRUE, 'Treino B - Pull'), ('FRIDAY', FALSE, 'Treino C - Legs')) AS v(day, completed, title)
    JOIN trainings tr ON tr.title = v.title;

    -- Camila (Fernanda) - recuperação, INATIVO (plano pausado, para testar o campo active)
    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, objective, active)
    VALUES (gen_random_uuid(), fernanda_pt_id, camila_trainee_id, 'Plano de recuperação pós-lesão - pausado', 'RECOVERY', FALSE)
    RETURNING id INTO plan_id;

    INSERT INTO training_item (id, day_of_week, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day, v.completed, tr.id, plan_id
    FROM (VALUES ('TUESDAY', FALSE, 'Treino B - Pull'), ('THURSDAY', FALSE, 'Treino C - Legs')) AS v(day, completed, title)
    JOIN trainings tr ON tr.title = v.title;

    -- Diego (Rafael) - hipertrofia, ativo
    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, objective, active)
    VALUES (gen_random_uuid(), rafael_pt_id, diego_trainee_id, 'Plano full body iniciante', 'HYPERTROPHY', TRUE)
    RETURNING id INTO plan_id;

    INSERT INTO training_item (id, day_of_week, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day, v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 'Treino Full Body A'), ('THURSDAY', TRUE, 'Treino Full Body B')) AS v(day, completed, title)
    JOIN trainings tr ON tr.title = v.title;

    -- Juliana (Rafael) - emagrecimento, ativo
    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, objective, active)
    VALUES (gen_random_uuid(), rafael_pt_id, juliana_trainee_id, 'Plano de emagrecimento e resistência', 'WEIGHT_LOSS', TRUE)
    RETURNING id INTO plan_id;

    INSERT INTO training_item (id, day_of_week, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day, v.completed, tr.id, plan_id
    FROM (VALUES ('TUESDAY', TRUE, 'Treino de Emagrecimento'), ('THURSDAY', FALSE, 'Treino de Emagrecimento'), ('SATURDAY', FALSE, 'Treino de Emagrecimento')) AS v(day, completed, title)
    JOIN trainings tr ON tr.title = v.title;
END $$;

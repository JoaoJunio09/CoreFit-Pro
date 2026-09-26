-- Um plano de treino por aluno (respeitando a constraint de 1 plano por trainee),
-- cada um com seus training_item (dia da semana + treino do catálogo do personal).
-- objective e goal agora são texto livre, definidos pelo personal trainer.

DO $$
DECLARE
    mateus_trainee_id   UUID; beatriz_trainee_id  UUID; thiago_trainee_id   UUID;
    larissa_trainee_id  UUID; bruno_trainee_id    UUID;

    gabriel_trainee_id  UUID; camila_trainee_id   UUID; amanda_trainee_id   UUID;

    diego_trainee_id    UUID; juliana_trainee_id  UUID; felipe_trainee_id   UUID;
    carolina_trainee_id UUID; eduardo_trainee_id  UUID; renata_trainee_id   UUID;
    vinicius_trainee_id UUID;

    isabela_trainee_id  UUID;

    lucas_pt_id    UUID;
    fernanda_pt_id UUID;
    rafael_pt_id   UUID;
    patricia_pt_id UUID;

    plan_id UUID;
BEGIN
    SELECT t.id INTO mateus_trainee_id   FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'mateus';
    SELECT t.id INTO beatriz_trainee_id  FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'beatriz';
    SELECT t.id INTO thiago_trainee_id   FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'thiago';
    SELECT t.id INTO larissa_trainee_id  FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'larissa';
    SELECT t.id INTO bruno_trainee_id    FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'bruno';

    SELECT t.id INTO gabriel_trainee_id  FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'gabriel';
    SELECT t.id INTO camila_trainee_id   FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'camila';
    SELECT t.id INTO amanda_trainee_id   FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'amanda';

    SELECT t.id INTO diego_trainee_id    FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'diego';
    SELECT t.id INTO juliana_trainee_id  FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'juliana';
    SELECT t.id INTO felipe_trainee_id   FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'felipe';
    SELECT t.id INTO carolina_trainee_id FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'carolina';
    SELECT t.id INTO eduardo_trainee_id  FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'eduardo';
    SELECT t.id INTO renata_trainee_id   FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'renata';
    SELECT t.id INTO vinicius_trainee_id FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'vinicius';

    SELECT t.id INTO isabela_trainee_id  FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'isabela';

    SELECT id INTO lucas_pt_id    FROM personals_trainers WHERE first_name = 'Lucas';
    SELECT id INTO fernanda_pt_id FROM personals_trainers WHERE first_name = 'Fernanda';
    SELECT id INTO rafael_pt_id   FROM personals_trainers WHERE first_name = 'Rafael';
    SELECT id INTO patricia_pt_id FROM personals_trainers WHERE first_name = 'Patrícia';

    -- ==================== LUCAS (5) ====================

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), lucas_pt_id, mateus_trainee_id, 'Plano de hipertrofia - fase 1', TRUE,
            'Ganho de massa muscular no tronco superior, com ênfase em peito e costas',
            'Ganhar 4kg de massa magra em 4 meses')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 7, 'Treino A - Peito e Tríceps'), ('WEDNESDAY', TRUE, 18, 'Treino B - Costas e Bíceps'), ('FRIDAY', FALSE, 8, 'Treino C - Pernas Completo')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), lucas_pt_id, beatriz_trainee_id, 'Plano de emagrecimento com foco em pernas', TRUE,
            'Redução de percentual de gordura corporal, mantendo massa magra',
            'Perder 6kg até o verão')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('TUESDAY', FALSE, 19, 'Treino A - Peito e Tríceps'), ('THURSDAY', TRUE, 7, 'Treino C - Pernas Completo')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), lucas_pt_id, thiago_trainee_id, 'Plano de condicionamento inicial', TRUE,
            'Condicionamento físico geral com foco em resistência',
            'Correr 5km sem parar em 8 semanas')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 18, 'Treino A - Peito e Tríceps'), ('THURSDAY', FALSE, 7, 'Treino C - Pernas Completo')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), lucas_pt_id, larissa_trainee_id, 'Plano de tonificação', TRUE,
            'Tonificação muscular e definição corporal',
            'Reduzir 3% de gordura corporal em 3 meses')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('TUESDAY', TRUE, 18, 'Treino B - Costas e Bíceps'), ('FRIDAY', FALSE, 8, 'Treino C - Pernas Completo')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), lucas_pt_id, bruno_trainee_id, 'Plano de força - divisão ABC', TRUE,
            'Ganho de força nos grandes grupos musculares (supino, agachamento, remada)',
            'Aumentar a carga do supino reto em 15kg')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 19, 'Treino A - Peito e Tríceps'), ('WEDNESDAY', TRUE, 7, 'Treino B - Costas e Bíceps'), ('FRIDAY', FALSE, 18, 'Treino C - Pernas Completo')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    -- ==================== FERNANDA (3) ====================

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), fernanda_pt_id, gabriel_trainee_id, 'Plano push/pull/legs', TRUE,
            'Hipertrofia muscular com divisão push/pull/legs',
            'Ganhar 5kg de massa muscular em 6 meses')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 7, 'Treino A - Push'), ('WEDNESDAY', TRUE, 18, 'Treino B - Pull'), ('FRIDAY', FALSE, 8, 'Treino C - Legs')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), fernanda_pt_id, camila_trainee_id, 'Plano de recuperação pós-lesão - pausado', FALSE,
            'Recuperação pós-lesão no joelho com fortalecimento gradual',
            'Retomar os treinos de perna sem dor até o fim do trimestre')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('TUESDAY', FALSE, 19, 'Treino B - Pull'), ('THURSDAY', FALSE, 7, 'Treino C - Legs')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), fernanda_pt_id, amanda_trainee_id, 'Plano funcional de alta intensidade', TRUE,
            'Emagrecimento com foco em treino funcional de alta intensidade',
            'Perder 8kg em 5 meses')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 18, 'Treino A - Push'), ('THURSDAY', FALSE, 7, 'Treino C - Legs')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    -- ==================== RAFAEL (7) ====================

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), rafael_pt_id, diego_trainee_id, 'Plano full body iniciante', TRUE,
            'Adaptação inicial ao treino de força, corpo inteiro',
            'Criar hábito de treino consistente e ganhar força de base')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 18, 'Treino Full Body A'), ('THURSDAY', TRUE, 8, 'Treino Full Body B')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), rafael_pt_id, juliana_trainee_id, 'Plano de emagrecimento e resistência', TRUE,
            'Emagrecimento com foco em resistência cardiovascular',
            'Perder 4kg e melhorar o condicionamento em 3 meses')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('TUESDAY', TRUE, 19, 'Treino de Emagrecimento'), ('THURSDAY', FALSE, 7, 'Treino de Emagrecimento'), ('SATURDAY', FALSE, 18, 'Treino de Emagrecimento')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), rafael_pt_id, felipe_trainee_id, 'Plano de hipertrofia de membros superiores', TRUE,
            'Hipertrofia com foco em membros superiores',
            'Aumentar a circunferência dos braços em 2cm')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 7, 'Treino Full Body A'), ('THURSDAY', FALSE, 18, 'Treino Full Body B')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), rafael_pt_id, carolina_trainee_id, 'Plano de definição e core', TRUE,
            'Definição muscular e reforço de core',
            'Reduzir a medida da cintura em 5cm')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('TUESDAY', FALSE, 8, 'Treino Full Body A'), ('FRIDAY', TRUE, 19, 'Treino de Emagrecimento')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), rafael_pt_id, eduardo_trainee_id, 'Plano de força máxima', TRUE,
            'Ganho de força máxima nos levantamentos básicos',
            'Bater o recorde pessoal no levantamento terra')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 7, 'Treino Full Body A'), ('WEDNESDAY', TRUE, 18, 'Treino Full Body B'), ('FRIDAY', FALSE, 7, 'Treino de Emagrecimento')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), rafael_pt_id, renata_trainee_id, 'Plano de bem-estar geral', TRUE,
            'Condicionamento físico geral com foco em bem-estar',
            'Treinar com consistência 3 vezes por semana')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('TUESDAY', FALSE, 18, 'Treino de Emagrecimento')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), rafael_pt_id, vinicius_trainee_id, 'Plano de hipertrofia geral', TRUE,
            'Hipertrofia e ganho de massa magra',
            'Ganhar 3kg de massa muscular em 4 meses')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 8, 'Treino Full Body A'), ('THURSDAY', FALSE, 19, 'Treino Full Body B')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;

    -- ==================== PATRÍCIA (1) ====================

    INSERT INTO training_plans (id, personal_trainer_id, trainee_id, description, active, objective, goal)
    VALUES (gen_random_uuid(), patricia_pt_id, isabela_trainee_id, 'Plano de adaptação inicial', TRUE,
            'Reeducação do movimento e adaptação inicial à atividade física',
            'Ganhar consistência de treino e reduzir dores nas costas')
    RETURNING id INTO plan_id;
    INSERT INTO training_item (id, day_of_week, date_time, completed, training_id, training_plan_id)
    SELECT gen_random_uuid(), v.day,
        date_trunc('week', CURRENT_DATE) + (CASE v.day
            WHEN 'MONDAY' THEN 0 WHEN 'TUESDAY' THEN 1 WHEN 'WEDNESDAY' THEN 2
            WHEN 'THURSDAY' THEN 3 WHEN 'FRIDAY' THEN 4 WHEN 'SATURDAY' THEN 5
            ELSE 6 END) * INTERVAL '1 day' + (v.hour * INTERVAL '1 hour'),
        v.completed, tr.id, plan_id
    FROM (VALUES ('MONDAY', TRUE, 7, 'Treino Adaptação A'), ('THURSDAY', FALSE, 18, 'Treino Adaptação B')) AS v(day, completed, hour, title)
    JOIN trainings tr ON tr.title = v.title;
END $$;

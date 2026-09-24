DO $$
DECLARE
    lucas_pt_id    UUID;
    fernanda_pt_id UUID;
    rafael_pt_id   UUID;
    patricia_pt_id UUID;

    t1_id UUID; t2_id UUID; t3_id UUID;
    t4_id UUID; t5_id UUID; t6_id UUID;
    t7_id UUID; t8_id UUID; t9_id UUID;
    t10_id UUID; t11_id UUID;
BEGIN
    SELECT id INTO lucas_pt_id    FROM personals_trainers WHERE first_name = 'Lucas';
    SELECT id INTO fernanda_pt_id FROM personals_trainers WHERE first_name = 'Fernanda';
    SELECT id INTO rafael_pt_id   FROM personals_trainers WHERE first_name = 'Rafael';
    SELECT id INTO patricia_pt_id FROM personals_trainers WHERE first_name = 'Patrícia';

    INSERT INTO trainings (id, title, description, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Treino A - Peito e Tríceps', 'Foco em empurrar: peito e tríceps', lucas_pt_id) RETURNING id INTO t1_id;
    INSERT INTO trainings (id, title, description, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Treino B - Costas e Bíceps', 'Foco em puxar: costas e bíceps', lucas_pt_id) RETURNING id INTO t2_id;
    INSERT INTO trainings (id, title, description, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Treino C - Pernas Completo', 'Quadríceps, posterior, glúteos e panturrilha', lucas_pt_id) RETURNING id INTO t3_id;

    INSERT INTO trainings (id, title, description, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Treino A - Push', 'Peito, ombros e tríceps', fernanda_pt_id) RETURNING id INTO t4_id;
    INSERT INTO trainings (id, title, description, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Treino B - Pull', 'Costas, bíceps e trapézio', fernanda_pt_id) RETURNING id INTO t5_id;
    INSERT INTO trainings (id, title, description, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Treino C - Legs', 'Quadríceps, glúteos e panturrilha', fernanda_pt_id) RETURNING id INTO t6_id;

    INSERT INTO trainings (id, title, description, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Treino Full Body A', 'Corpo inteiro - parte superior + pernas', rafael_pt_id) RETURNING id INTO t7_id;
    INSERT INTO trainings (id, title, description, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Treino Full Body B', 'Ombros, braços e abdômen', rafael_pt_id) RETURNING id INTO t8_id;
    INSERT INTO trainings (id, title, description, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Treino de Emagrecimento', 'Foco em queima calórica e resistência', rafael_pt_id) RETURNING id INTO t9_id;

    INSERT INTO trainings (id, title, description, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Treino Adaptação A', 'Corpo inteiro, foco em reeducação de movimento para iniciantes', patricia_pt_id) RETURNING id INTO t10_id;
    INSERT INTO trainings (id, title, description, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Treino Adaptação B', 'Mobilidade e fortalecimento leve de corpo inteiro', patricia_pt_id) RETURNING id INTO t11_id;

    INSERT INTO training_muscle_groups (training_id, muscle_group_id)
    SELECT t1_id, id FROM muscle_groups WHERE name IN ('Peito', 'Tríceps')
    UNION ALL
    SELECT t2_id, id FROM muscle_groups WHERE name IN ('Costas', 'Bíceps')
    UNION ALL
    SELECT t3_id, id FROM muscle_groups WHERE name IN ('Quadríceps', 'Posterior de Coxa', 'Glúteos', 'Panturrilha')
    UNION ALL
    SELECT t4_id, id FROM muscle_groups WHERE name IN ('Peito', 'Ombros', 'Tríceps')
    UNION ALL
    SELECT t5_id, id FROM muscle_groups WHERE name IN ('Costas', 'Bíceps', 'Trapézio')
    UNION ALL
    SELECT t6_id, id FROM muscle_groups WHERE name IN ('Quadríceps', 'Glúteos', 'Panturrilha')
    UNION ALL
    SELECT t7_id, id FROM muscle_groups WHERE name IN ('Peito', 'Costas', 'Quadríceps')
    UNION ALL
    SELECT t8_id, id FROM muscle_groups WHERE name IN ('Ombros', 'Bíceps', 'Tríceps', 'Abdômen')
    UNION ALL
    SELECT t9_id, id FROM muscle_groups WHERE name IN ('Abdômen', 'Quadríceps', 'Panturrilha')
    UNION ALL
    SELECT t10_id, id FROM muscle_groups WHERE name IN ('Peito', 'Costas', 'Quadríceps', 'Abdômen')
    UNION ALL
    SELECT t11_id, id FROM muscle_groups WHERE name IN ('Ombros', 'Glúteos', 'Panturrilha');
END $$;

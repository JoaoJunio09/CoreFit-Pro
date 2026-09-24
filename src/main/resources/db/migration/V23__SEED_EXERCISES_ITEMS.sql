INSERT INTO exercises_items (id, exercise_id, repetitions, series, training_id)
SELECT gen_random_uuid(), e.id, v.repetitions, v.series, tr.id
FROM trainings tr, (VALUES
    ('Supino Reto com Barra', 10, 4), ('Supino Inclinado com Halteres', 12, 3),
    ('Crossover no Cabo', 15, 3), ('Tríceps Corda (Pulley)', 12, 4), ('Tríceps Testa', 10, 3)
) AS v(exercise_name, repetitions, series)
JOIN exercises e ON e.name = v.exercise_name
WHERE tr.title = 'Treino A - Peito e Tríceps';

INSERT INTO exercises_items (id, exercise_id, repetitions, series, training_id)
SELECT gen_random_uuid(), e.id, v.repetitions, v.series, tr.id
FROM trainings tr, (VALUES
    ('Puxada Frontal (Pulley)', 10, 4), ('Remada Curvada com Barra', 10, 4),
    ('Remada Unilateral com Halter', 12, 3), ('Rosca Direta com Barra', 10, 4), ('Rosca Martelo', 12, 3)
) AS v(exercise_name, repetitions, series)
JOIN exercises e ON e.name = v.exercise_name
WHERE tr.title = 'Treino B - Costas e Bíceps';

INSERT INTO exercises_items (id, exercise_id, repetitions, series, training_id)
SELECT gen_random_uuid(), e.id, v.repetitions, v.series, tr.id
FROM trainings tr, (VALUES
    ('Agachamento Livre', 10, 4), ('Leg Press 45°', 12, 4),
    ('Mesa Flexora', 12, 3), ('Elevação Pélvica (Hip Thrust)', 12, 3), ('Elevação de Panturrilha em Pé', 15, 4)
) AS v(exercise_name, repetitions, series)
JOIN exercises e ON e.name = v.exercise_name
WHERE tr.title = 'Treino C - Pernas Completo';

INSERT INTO exercises_items (id, exercise_id, repetitions, series, training_id)
SELECT gen_random_uuid(), e.id, v.repetitions, v.series, tr.id
FROM trainings tr, (VALUES
    ('Supino Reto com Barra', 8, 4), ('Desenvolvimento com Halteres', 10, 4),
    ('Elevação Lateral', 15, 3), ('Tríceps Francês', 12, 3)
) AS v(exercise_name, repetitions, series)
JOIN exercises e ON e.name = v.exercise_name
WHERE tr.title = 'Treino A - Push';

INSERT INTO exercises_items (id, exercise_id, repetitions, series, training_id)
SELECT gen_random_uuid(), e.id, v.repetitions, v.series, tr.id
FROM trainings tr, (VALUES
    ('Barra Fixa (Pull-up)', 8, 4), ('Remada Baixa no Cabo', 10, 4),
    ('Encolhimento de Ombros com Halteres', 15, 3), ('Rosca Alternada com Halteres', 10, 3)
) AS v(exercise_name, repetitions, series)
JOIN exercises e ON e.name = v.exercise_name
WHERE tr.title = 'Treino B - Pull';

INSERT INTO exercises_items (id, exercise_id, repetitions, series, training_id)
SELECT gen_random_uuid(), e.id, v.repetitions, v.series, tr.id
FROM trainings tr, (VALUES
    ('Agachamento Búlgaro', 10, 4), ('Cadeira Extensora', 15, 3),
    ('Agachamento Sumô', 12, 4), ('Panturrilha no Leg Press', 15, 4)
) AS v(exercise_name, repetitions, series)
JOIN exercises e ON e.name = v.exercise_name
WHERE tr.title = 'Treino C - Legs';

INSERT INTO exercises_items (id, exercise_id, repetitions, series, training_id)
SELECT gen_random_uuid(), e.id, v.repetitions, v.series, tr.id
FROM trainings tr, (VALUES
    ('Supino Inclinado com Halteres', 12, 3), ('Puxada Atrás da Nuca', 12, 3),
    ('Leg Press 45°', 12, 4), ('Afundo (Passada)', 12, 3)
) AS v(exercise_name, repetitions, series)
JOIN exercises e ON e.name = v.exercise_name
WHERE tr.title = 'Treino Full Body A';

INSERT INTO exercises_items (id, exercise_id, repetitions, series, training_id)
SELECT gen_random_uuid(), e.id, v.repetitions, v.series, tr.id
FROM trainings tr, (VALUES
    ('Desenvolvimento Militar com Barra', 10, 3), ('Rosca Scott', 12, 3),
    ('Mergulho em Paralelas (Dips)', 10, 3), ('Abdominal Supra', 20, 3)
) AS v(exercise_name, repetitions, series)
JOIN exercises e ON e.name = v.exercise_name
WHERE tr.title = 'Treino Full Body B';

INSERT INTO exercises_items (id, exercise_id, repetitions, series, training_id)
SELECT gen_random_uuid(), e.id, v.repetitions, v.series, tr.id
FROM trainings tr, (VALUES
    ('Agachamento Livre', 15, 4), ('Prancha Isométrica', 1, 3),
    ('Elevação de Panturrilha Sentado', 20, 3), ('Abdominal Oblíquo', 20, 3)
) AS v(exercise_name, repetitions, series)
JOIN exercises e ON e.name = v.exercise_name
WHERE tr.title = 'Treino de Emagrecimento';

INSERT INTO exercises_items (id, exercise_id, repetitions, series, training_id)
SELECT gen_random_uuid(), e.id, v.repetitions, v.series, tr.id
FROM trainings tr, (VALUES
    ('Flexão de Braço', 8, 2), ('Agachamento Livre', 12, 2),
    ('Abdominal Supra', 12, 2), ('Elevação de Panturrilha em Pé', 15, 2)
) AS v(exercise_name, repetitions, series)
JOIN exercises e ON e.name = v.exercise_name
WHERE tr.title = 'Treino Adaptação A';

INSERT INTO exercises_items (id, exercise_id, repetitions, series, training_id)
SELECT gen_random_uuid(), e.id, v.repetitions, v.series, tr.id
FROM trainings tr, (VALUES
    ('Elevação Lateral', 12, 2), ('Elevação Pélvica (Hip Thrust)', 12, 2),
    ('Prancha Isométrica', 1, 2)
) AS v(exercise_name, repetitions, series)
JOIN exercises e ON e.name = v.exercise_name
WHERE tr.title = 'Treino Adaptação B';

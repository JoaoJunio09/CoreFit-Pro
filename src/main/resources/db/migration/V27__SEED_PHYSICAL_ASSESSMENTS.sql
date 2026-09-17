-- 3 avaliações físicas por aluno (a cada ~30 dias), mostrando evolução condizente
-- com o objetivo de cada plano de treino (hipertrofia, emagrecimento, recuperação)

DO $$
DECLARE
    mateus_id  UUID; beatriz_id UUID; gabriel_id UUID;
    camila_id  UUID; diego_id   UUID; juliana_id UUID;
BEGIN
    SELECT t.id INTO mateus_id  FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'mateus';
    SELECT t.id INTO beatriz_id FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'beatriz';
    SELECT t.id INTO gabriel_id FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'gabriel';
    SELECT t.id INTO camila_id  FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'camila';
    SELECT t.id INTO diego_id   FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'diego';
    SELECT t.id INTO juliana_id FROM trainees t JOIN users u ON u.id = t.user_id WHERE u.username = 'juliana';

    -- Mateus (hipertrofia) - 1,78m, 24 anos, ganhando massa magra
    INSERT INTO physical_assessments (id, trainee_id, registered_at, age, weight, height, imc, body_fat, fat_mass, muscle_mass, chest, waist, abdomen, hip, right_arm, left_arm, right_thigh, left_thigh, activity_level, notes) VALUES
        (gen_random_uuid(), mateus_id, CURRENT_DATE - 60, 24, 78, 1.78, 24.62, 18.0, 14.0, 34.0, 98,  82, 84, 96, 33.0, 32.5, 55.0, 54.5, 'MODERATE', NULL),
        (gen_random_uuid(), mateus_id, CURRENT_DATE - 30, 24, 79, 1.78, 24.94, 17.2, 13.6, 35.0, 99,  81, 83, 96, 33.8, 33.3, 56.0, 55.5, 'MODERATE', NULL),
        (gen_random_uuid(), mateus_id, CURRENT_DATE - 2,  24, 80, 1.78, 25.25, 16.5, 13.2, 36.2, 100, 80, 82, 96, 34.5, 34.0, 57.0, 56.5, 'MODERATE', 'Boa evolução de massa magra, manter dieta hiperproteica');

    -- Beatriz (emagrecimento) - 1,65m, 29 anos, perdendo gordura
    INSERT INTO physical_assessments (id, trainee_id, registered_at, age, weight, height, imc, body_fat, fat_mass, muscle_mass, chest, waist, abdomen, hip, right_arm, left_arm, right_thigh, left_thigh, activity_level, notes) VALUES
        (gen_random_uuid(), beatriz_id, CURRENT_DATE - 60, 29, 70, 1.65, 25.71, 32.0, 22.4, 24.5, 92, 84, 88, 102, 28.0, 27.5, 58.0, 57.5, 'LIGHT', NULL),
        (gen_random_uuid(), beatriz_id, CURRENT_DATE - 30, 29, 68, 1.65, 24.98, 30.0, 20.4, 24.8, 91, 81, 85, 100, 27.5, 27.0, 56.0, 55.5, 'LIGHT', NULL),
        (gen_random_uuid(), beatriz_id, CURRENT_DATE - 2,  29, 66, 1.65, 24.24, 28.0, 18.5, 25.0, 90, 78, 82,  98, 27.0, 26.5, 54.0, 53.5, 'LIGHT', 'Ótima redução de percentual de gordura, seguir com cardio 3x/semana');

    -- Gabriel (hipertrofia) - 1,80m, 22 anos, ganho consistente
    INSERT INTO physical_assessments (id, trainee_id, registered_at, age, weight, height, imc, body_fat, fat_mass, muscle_mass, chest, waist, abdomen, hip, right_arm, left_arm, right_thigh, left_thigh, activity_level, notes) VALUES
        (gen_random_uuid(), gabriel_id, CURRENT_DATE - 60, 22, 75.0, 1.80, 23.15, 15.0, 11.3, 37.0, 100, 80, 82, 98, 34.0, 33.5, 58.0, 57.5, 'ACTIVE', NULL),
        (gen_random_uuid(), gabriel_id, CURRENT_DATE - 30, 22, 76.5, 1.80, 23.61, 14.5, 11.1, 38.2, 101, 79, 81, 98, 34.8, 34.3, 59.0, 58.5, 'ACTIVE', NULL),
        (gen_random_uuid(), gabriel_id, CURRENT_DATE - 2,  22, 78.0, 1.80, 24.07, 14.0, 10.9, 39.5, 102, 79, 80, 98, 35.5, 35.0, 60.0, 59.5, 'ACTIVE', 'Ganho consistente de massa muscular, ajustar carga dos treinos de push');

    -- Camila (recuperação, plano pausado) - 1,60m, 35 anos, estável durante a recuperação
    INSERT INTO physical_assessments (id, trainee_id, registered_at, age, weight, height, imc, body_fat, fat_mass, muscle_mass, chest, waist, abdomen, hip, right_arm, left_arm, right_thigh, left_thigh, activity_level, notes) VALUES
        (gen_random_uuid(), camila_id, CURRENT_DATE - 60, 35, 58.0, 1.60, 22.66, 27.0, 15.7, 22.0, 88,   76, 80, 96, 26.0, 25.5, 54.0, 53.0, 'SEDENTARY', NULL),
        (gen_random_uuid(), camila_id, CURRENT_DATE - 30, 35, 58.0, 1.60, 22.66, 27.0, 15.7, 22.0, 88,   76, 80, 96, 26.0, 25.5, 54.0, 53.0, 'SEDENTARY', NULL),
        (gen_random_uuid(), camila_id, CURRENT_DATE - 2,  35, 57.5, 1.60, 22.46, 26.5, 15.2, 22.1, 87.5, 75, 79, 95, 26.0, 25.5, 53.5, 52.5, 'SEDENTARY', 'Recuperação de lesão no joelho, plano pausado até liberação médica');

    -- Diego (hipertrofia, iniciante full body) - 1,75m, 27 anos
    INSERT INTO physical_assessments (id, trainee_id, registered_at, age, weight, height, imc, body_fat, fat_mass, muscle_mass, chest, waist, abdomen, hip, right_arm, left_arm, right_thigh, left_thigh, activity_level, notes) VALUES
        (gen_random_uuid(), diego_id, CURRENT_DATE - 60, 27, 70.0, 1.75, 22.86, 20.0, 14.0, 30.0, 94, 82, 85, 96, 30.0, 29.5, 54.0, 53.5, 'MODERATE', NULL),
        (gen_random_uuid(), diego_id, CURRENT_DATE - 30, 27, 71.5, 1.75, 23.35, 19.0, 13.6, 31.2, 95, 81, 84, 96, 30.7, 30.2, 55.0, 54.5, 'MODERATE', NULL),
        (gen_random_uuid(), diego_id, CURRENT_DATE - 2,  27, 73.0, 1.75, 23.84, 18.2, 13.3, 32.5, 96, 80, 83, 96, 31.5, 31.0, 56.0, 55.5, 'MODERATE', 'Bom progresso para iniciante, aumentar carga gradualmente');

    -- Juliana (emagrecimento) - 1,62m, 31 anos
    INSERT INTO physical_assessments (id, trainee_id, registered_at, age, weight, height, imc, body_fat, fat_mass, muscle_mass, chest, waist, abdomen, hip, right_arm, left_arm, right_thigh, left_thigh, activity_level, notes) VALUES
        (gen_random_uuid(), juliana_id, CURRENT_DATE - 60, 31, 68.0, 1.62, 25.91, 33.0, 22.4, 23.0, 90, 86, 90, 104, 27.0, 26.5, 57.0, 56.5, 'LIGHT', NULL),
        (gen_random_uuid(), juliana_id, CURRENT_DATE - 30, 31, 66.0, 1.62, 25.15, 31.0, 20.5, 23.3, 89, 83, 87, 102, 26.5, 26.0, 55.5, 55.0, 'LIGHT', NULL),
        (gen_random_uuid(), juliana_id, CURRENT_DATE - 2,  31, 64.0, 1.62, 24.39, 29.0, 18.6, 23.6, 88, 80, 84, 100, 26.0, 25.5, 54.0, 53.5, 'LIGHT', 'Excelente evolução no emagrecimento, seguir protocolo atual');
END $$;

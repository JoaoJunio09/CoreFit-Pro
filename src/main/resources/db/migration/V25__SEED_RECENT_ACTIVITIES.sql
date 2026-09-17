DO $$
DECLARE
    lucas_pt_id    UUID;
    fernanda_pt_id UUID;
    rafael_pt_id   UUID;
BEGIN
    SELECT id INTO lucas_pt_id    FROM personals_trainers WHERE first_name = 'Lucas';
    SELECT id INTO fernanda_pt_id FROM personals_trainers WHERE first_name = 'Fernanda';
    SELECT id INTO rafael_pt_id   FROM personals_trainers WHERE first_name = 'Rafael';

    INSERT INTO recent_activities (id, registered_at, description, personal_trainer_id) VALUES
        (gen_random_uuid(), NOW() - INTERVAL '9 days',  'Você adicionou 3 novos treinos', lucas_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '8 days',  'Você criou um plano de treino para Mateus', lucas_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '7 days',  'Você criou um plano de treino para Beatriz', lucas_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '3 days',  'Aluno Mateus concluiu o treino Treino A - Peito e Tríceps', lucas_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '2 days',  'Aluno Beatriz concluiu o treino Treino C - Pernas Completo', lucas_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '1 day',   'Aluno Mateus concluiu o treino Treino B - Costas e Bíceps', lucas_pt_id),

        (gen_random_uuid(), NOW() - INTERVAL '10 days', 'Você adicionou 3 novos treinos', fernanda_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '6 days',  'Você criou um plano de treino para Gabriel', fernanda_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '5 days',  'Você criou um plano de treino para Camila', fernanda_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '4 days',  'Você pausou o plano de treino de Camila', fernanda_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '2 days',  'Aluno Gabriel concluiu o treino Treino A - Push', fernanda_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '1 day',   'Aluno Gabriel concluiu o treino Treino B - Pull', fernanda_pt_id),

        (gen_random_uuid(), NOW() - INTERVAL '11 days', 'Você adicionou 3 novos treinos', rafael_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '6 days',  'Você criou um plano de treino para Diego', rafael_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '5 days',  'Você criou um plano de treino para Juliana', rafael_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '3 days',  'Aluno Diego concluiu o treino Treino Full Body A', rafael_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '2 days',  'Aluno Juliana concluiu o treino Treino de Emagrecimento', rafael_pt_id),
        (gen_random_uuid(), NOW() - INTERVAL '1 day',   'Aluno Diego concluiu o treino Treino Full Body B', rafael_pt_id);
END $$;

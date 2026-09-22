-- Exercícios personalizados (system = FALSE) - funcionais/calistenia, criados por cada personal trainer
DO $$
DECLARE
    lucas_pt_id    UUID;
    fernanda_pt_id UUID;
    rafael_pt_id   UUID;
BEGIN
    SELECT id INTO lucas_pt_id    FROM personals_trainers WHERE first_name = 'Lucas';
    SELECT id INTO fernanda_pt_id FROM personals_trainers WHERE first_name = 'Fernanda';
    SELECT id INTO rafael_pt_id   FROM personals_trainers WHERE first_name = 'Rafael';

    INSERT INTO exercises (id, name, system, favorite, photo, video, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Burpee com Salto',             FALSE, TRUE,  NULL, NULL, lucas_pt_id),
        (gen_random_uuid(), 'Prancha com Toque no Ombro',   FALSE, TRUE,  NULL, NULL, lucas_pt_id),
        (gen_random_uuid(), 'Remada Invertida na TRX',      FALSE, FALSE, NULL, NULL, fernanda_pt_id),
        (gen_random_uuid(), 'Agachamento Pistol',           FALSE, FALSE, NULL, NULL, fernanda_pt_id),
        (gen_random_uuid(), 'Flexão Diamante',              FALSE, FALSE, NULL, NULL, rafael_pt_id);
END $$;

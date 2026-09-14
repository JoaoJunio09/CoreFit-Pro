-- 6 alunos de teste (username/password iguais ao primeiro nome), distribuídos entre os 3 personal trainers

DO $$
DECLARE
    mateus_user_id  UUID := gen_random_uuid();
    beatriz_user_id UUID := gen_random_uuid();
    gabriel_user_id UUID := gen_random_uuid();
    camila_user_id  UUID := gen_random_uuid();
    diego_user_id   UUID := gen_random_uuid();
    juliana_user_id UUID := gen_random_uuid();

    lucas_pt_id    UUID;
    fernanda_pt_id UUID;
    rafael_pt_id   UUID;
BEGIN
    SELECT id INTO lucas_pt_id    FROM personals_trainers WHERE first_name = 'Lucas';
    SELECT id INTO fernanda_pt_id FROM personals_trainers WHERE first_name = 'Fernanda';
    SELECT id INTO rafael_pt_id   FROM personals_trainers WHERE first_name = 'Rafael';

    INSERT INTO users (id, username, password, full_name, email, recovery_email, account_non_expired, account_non_locked, credentials_non_expired, enabled) VALUES
        (mateus_user_id,  'mateus',  '{pbkdf2}775b3343f2d48858b89d939e12f2079061d66503f8951f0d3acb5e0b81424a8cf6bd176f9dba7d6f', 'Mateus',          'mateus@corefitpro.com',  'mateus@corefitpro.com',  TRUE, TRUE, TRUE, TRUE),
        (beatriz_user_id, 'beatriz', '{pbkdf2}bf10b13a9a51941ec065e736f9dcbcd5acba57fa502a3b6e7129e18de4e609efddb646480abbe709', 'Beatriz Lima',    'beatriz@corefitpro.com', 'beatriz@corefitpro.com', TRUE, TRUE, TRUE, TRUE),
        (gabriel_user_id, 'gabriel', '{pbkdf2}60997dfbd82e32a385b85fecb59af6ec4358cb5fef0ef588632851cde5796dafa0e52064e8cdd187', 'Gabriel Santos',  'gabriel@corefitpro.com', 'gabriel@corefitpro.com', TRUE, TRUE, TRUE, TRUE),
        (camila_user_id,  'camila',  '{pbkdf2}ed4d4e75f2a30a45be82844099619d7101285d734478125556a074799a8ce3978f23001930037a89', 'Camila Rocha',    'camila@corefitpro.com',  'camila@corefitpro.com',  TRUE, TRUE, TRUE, TRUE),
        (diego_user_id,   'diego',   '{pbkdf2}d024b062d805fe965d85ce91dd957c78832c82d0aa57d8098fa0d79ad316d7f3c9fc2135c4bf7b70', 'Diego Alves',     'diego@corefitpro.com',   'diego@corefitpro.com',   TRUE, TRUE, TRUE, TRUE),
        (juliana_user_id, 'juliana', '{pbkdf2}1bd5980b539c48a9780d11d817ffe0ca7405d8dc331167f246fb116f2c5c9f6318973213855f4299', 'Juliana Pereira', 'juliana@corefitpro.com', 'juliana@corefitpro.com', TRUE, TRUE, TRUE, TRUE);

    INSERT INTO user_role (user_id, role_id)
    SELECT u.id, r.id FROM users u, roles r
    WHERE u.id IN (mateus_user_id, beatriz_user_id, gabriel_user_id, camila_user_id, diego_user_id, juliana_user_id)
      AND r.name = 'TRAINEE';

    INSERT INTO trainees (id, first_name, last_name, user_id, personal_trainer_id) VALUES
        (gen_random_uuid(), 'Mateus',  '',        mateus_user_id,  lucas_pt_id),
        (gen_random_uuid(), 'Beatriz', 'Lima',    beatriz_user_id, lucas_pt_id),
        (gen_random_uuid(), 'Gabriel', 'Santos',  gabriel_user_id, fernanda_pt_id),
        (gen_random_uuid(), 'Camila',  'Rocha',   camila_user_id,  fernanda_pt_id),
        (gen_random_uuid(), 'Diego',   'Alves',   diego_user_id,   rafael_pt_id),
        (gen_random_uuid(), 'Juliana', 'Pereira', juliana_user_id, rafael_pt_id);
END $$;

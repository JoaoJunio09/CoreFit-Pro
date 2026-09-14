-- 3 personal trainers de teste (username/password iguais ao primeiro nome)

DO $$
DECLARE
    lucas_user_id    UUID := gen_random_uuid();
    fernanda_user_id UUID := gen_random_uuid();
    rafael_user_id   UUID := gen_random_uuid();
BEGIN
    INSERT INTO users (id, username, password, full_name, email, recovery_email, account_non_expired, account_non_locked, credentials_non_expired, enabled) VALUES
        (lucas_user_id,    'lucas',    '{pbkdf2}af2ee5f6ec40b0f232e107c07ecb85d39844c07952e753c4eefe909e9192e7124697ecff3656d4da', 'Lucas',         'lucas@corefitpro.com',    'lucas@corefitpro.com',    TRUE, TRUE, TRUE, TRUE),
        (fernanda_user_id, 'fernanda', '{pbkdf2}e71f88b519a2aecc3c7f1d411921293fda2a2dd2f32f306ace811b2654e77f22cc54f7339c1a1e10', 'Fernanda Costa', 'fernanda@corefitpro.com', 'fernanda@corefitpro.com', TRUE, TRUE, TRUE, TRUE),
        (rafael_user_id,   'rafael',   '{pbkdf2}be883ef0f3a45b27ba16d4c4a0ea261061086fb40284e46d4770c69149dad683fddfd0acfcf997d8', 'Rafael Souza',  'rafael@corefitpro.com',   'rafael@corefitpro.com',   TRUE, TRUE, TRUE, TRUE);

    INSERT INTO user_role (user_id, role_id)
    SELECT u.id, r.id FROM users u, roles r
    WHERE u.id IN (lucas_user_id, fernanda_user_id, rafael_user_id) AND r.name = 'PERSONAL';

    INSERT INTO personals_trainers (id, first_name, last_name, user_id) VALUES
        (gen_random_uuid(), 'Lucas',    '',      lucas_user_id),
        (gen_random_uuid(), 'Fernanda', 'Costa', fernanda_user_id),
        (gen_random_uuid(), 'Rafael',   'Souza', rafael_user_id);
END $$;

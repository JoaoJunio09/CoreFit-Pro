-- Aluno de teste (username/password: mateus / mateus), vinculado ao Lucas como personal trainer
DO $$
DECLARE
    mateus_user_id UUID := gen_random_uuid();
BEGIN
    INSERT INTO users (
        id, username, password, full_name, email, recovery_email,
        account_non_expired, account_non_locked, credentials_non_expired, enabled
    ) VALUES (
        mateus_user_id,
        'mateus',
        '{pbkdf2}775b3343f2d48858b89d939e12f2079061d66503f8951f0d3acb5e0b81424a8cf6bd176f9dba7d6f',
        'Mateus',
        'mateus@corefitpro.com',
        'mateus@corefitpro.com',
        TRUE, TRUE, TRUE, TRUE
    );

    INSERT INTO user_role (user_id, role_id)
    SELECT mateus_user_id, r.id
    FROM roles r
    WHERE r.name = 'TRAINEE';

    INSERT INTO trainees (id, first_name, last_name, user_id, personal_trainer_id)
    SELECT gen_random_uuid(), 'Mateus', '', mateus_user_id, pt.id
    FROM personals_trainers pt
    WHERE pt.first_name = 'Lucas';
END $$;

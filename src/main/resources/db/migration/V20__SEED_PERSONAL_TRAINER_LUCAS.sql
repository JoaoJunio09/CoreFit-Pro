-- Personal trainer de teste (username/password: lucas / lucas)
DO $$
DECLARE
    lucas_user_id UUID := gen_random_uuid();
    lucas_personal_trainer_id UUID := gen_random_uuid();
BEGIN
    INSERT INTO users (
        id, username, password, full_name, email, recovery_email,
        account_non_expired, account_non_locked, credentials_non_expired, enabled
    ) VALUES (
        lucas_user_id,
        'lucas',
        '{pbkdf2}af2ee5f6ec40b0f232e107c07ecb85d39844c07952e753c4eefe909e9192e7124697ecff3656d4da',
        'Lucas',
        'lucas@corefitpro.com',
        'lucas@corefitpro.com',
        TRUE, TRUE, TRUE, TRUE
    );

    INSERT INTO user_role (user_id, role_id)
    SELECT lucas_user_id, r.id
    FROM roles r
    WHERE r.name = 'PERSONAL';

    INSERT INTO personals_trainers (id, first_name, last_name, user_id)
    VALUES (lucas_personal_trainer_id, 'Lucas', '', lucas_user_id);
END $$;

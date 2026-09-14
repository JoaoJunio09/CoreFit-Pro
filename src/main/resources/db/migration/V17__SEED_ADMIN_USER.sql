-- Usuário administrador padrão (username/password: joaojunio / joaojunio)
-- Hash gerado com PBKDF2WithHmacSHA256 (salt 8 bytes, 1.815.000 iterações, hash 256 bits),
-- os mesmos parâmetros configurados no PasswordEncoder do SecurityConfig
DO $$
DECLARE
    admin_user_id UUID := gen_random_uuid();
BEGIN
    INSERT INTO users (
        id, username, password, full_name, email, recovery_email,
        account_non_expired, account_non_locked, credentials_non_expired, enabled
    ) VALUES (
        admin_user_id,
        'joaojunio',
        '{pbkdf2}1838ee36ca7e81bf26c9b16f922047b2bd90155898effad9fd01f567cd881d7caf5432b9e73d386b',
        'João Júnio',
        'joaojunio@corefitpro.com',
        'joaojunio@corefitpro.com',
        TRUE, TRUE, TRUE, TRUE
    );

    INSERT INTO user_role (user_id, role_id)
    SELECT admin_user_id, r.id
    FROM roles r
    WHERE r.name = 'ADMIN';
END $$;

-- Usuário administrador padrão (username/password: joaojunio / joaojunio)
-- Hash gerado com BCrypt (strength 10), compatível com BCryptPasswordEncoder do Spring Security
SET @admin_user_id = UUID();

INSERT INTO users (
    id, username, password, full_name, email, recovery_email,
    account_non_expired, account_non_locked, credentials_non_expired, enabled
) VALUES (
    @admin_user_id,
    'joaojunio',
    '$2b$10$lCBCglgtZ5qSGEF6w5JxlOMAwcJLP7OzNNTnFfwWMJ4ZSGW8WykxW',
    'João Júnio',
    'joaojunio@corefitpro.com',
    'joaojunio@corefitpro.com',
    TRUE, TRUE, TRUE, TRUE
);

INSERT INTO user_role (user_id, role_id)
SELECT @admin_user_id, r.id
FROM roles r
WHERE r.name = 'ADMIN';

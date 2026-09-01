-- Roles do sistema
INSERT INTO roles (id, name) VALUES
    (1, 'ADMIN'),
    (2, 'PERSONAL'),
    (3, 'TRAINEE');

-- Permission coringa, usada apenas durante o desenvolvimento do MVP.
-- Quando o sistema estiver pronto, remover esta permission e criar as
-- permissions granulares corretas para cada ROLE.
INSERT INTO permissions (id, name, description) VALUES
    (1, 'ALL', 'Permissão total - uso temporário durante o desenvolvimento do MVP');

-- ADMIN recebe a permission ALL
INSERT INTO role_permission (role_id, permission_id)
SELECT r.id, p.id
FROM roles r
JOIN permissions p ON p.name = 'ALL'
WHERE r.name = 'ADMIN';

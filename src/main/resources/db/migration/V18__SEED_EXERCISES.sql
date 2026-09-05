-- Exercícios comuns de academia, organizados por grupo muscular predominante
-- (o vínculo formal com muscle_groups acontece via Training, não aqui)

-- Peito
INSERT INTO exercises (id, name, photo, video) VALUES
    (gen_random_uuid(), 'Supino Reto com Barra', NULL, NULL),
    (gen_random_uuid(), 'Supino Inclinado com Halteres', NULL, NULL),
    (gen_random_uuid(), 'Supino Declinado com Barra', NULL, NULL),
    (gen_random_uuid(), 'Crucifixo Reto com Halteres', NULL, NULL),
    (gen_random_uuid(), 'Crossover no Cabo', NULL, NULL),
    (gen_random_uuid(), 'Peck Deck (Voador)', NULL, NULL),
    (gen_random_uuid(), 'Flexão de Braço', NULL, NULL);

-- Costas
INSERT INTO exercises (id, name, photo, video) VALUES
    (gen_random_uuid(), 'Puxada Frontal (Pulley)', NULL, NULL),
    (gen_random_uuid(), 'Puxada Atrás da Nuca', NULL, NULL),
    (gen_random_uuid(), 'Remada Curvada com Barra', NULL, NULL),
    (gen_random_uuid(), 'Remada Baixa no Cabo', NULL, NULL),
    (gen_random_uuid(), 'Remada Unilateral com Halter', NULL, NULL),
    (gen_random_uuid(), 'Barra Fixa (Pull-up)', NULL, NULL),
    (gen_random_uuid(), 'Levantamento Terra', NULL, NULL),
    (gen_random_uuid(), 'Hiperextensão Lombar (Banco Romano)', NULL, NULL);

-- Trapézio e Ombros
INSERT INTO exercises (id, name, photo, video) VALUES
    (gen_random_uuid(), 'Encolhimento de Ombros com Halteres', NULL, NULL),
    (gen_random_uuid(), 'Remada Alta', NULL, NULL),
    (gen_random_uuid(), 'Desenvolvimento com Halteres', NULL, NULL),
    (gen_random_uuid(), 'Desenvolvimento Militar com Barra', NULL, NULL),
    (gen_random_uuid(), 'Elevação Lateral', NULL, NULL),
    (gen_random_uuid(), 'Elevação Frontal', NULL, NULL),
    (gen_random_uuid(), 'Crucifixo Invertido (Posterior de Ombro)', NULL, NULL);

-- Bíceps, Tríceps e Antebraço
INSERT INTO exercises (id, name, photo, video) VALUES
    (gen_random_uuid(), 'Rosca Direta com Barra', NULL, NULL),
    (gen_random_uuid(), 'Rosca Alternada com Halteres', NULL, NULL),
    (gen_random_uuid(), 'Rosca Martelo', NULL, NULL),
    (gen_random_uuid(), 'Rosca Scott', NULL, NULL),
    (gen_random_uuid(), 'Tríceps Corda (Pulley)', NULL, NULL),
    (gen_random_uuid(), 'Tríceps Testa', NULL, NULL),
    (gen_random_uuid(), 'Tríceps Francês', NULL, NULL),
    (gen_random_uuid(), 'Supino Fechado', NULL, NULL),
    (gen_random_uuid(), 'Mergulho em Paralelas (Dips)', NULL, NULL),
    (gen_random_uuid(), 'Rosca de Punho', NULL, NULL);

-- Abdômen
INSERT INTO exercises (id, name, photo, video) VALUES
    (gen_random_uuid(), 'Abdominal Supra', NULL, NULL),
    (gen_random_uuid(), 'Abdominal Infra', NULL, NULL),
    (gen_random_uuid(), 'Abdominal Oblíquo', NULL, NULL),
    (gen_random_uuid(), 'Prancha Isométrica', NULL, NULL),
    (gen_random_uuid(), 'Elevação de Pernas na Barra', NULL, NULL);

-- Pernas (Quadríceps, Posterior de Coxa, Glúteos, Adutores, Abdutores)
INSERT INTO exercises (id, name, photo, video) VALUES
    (gen_random_uuid(), 'Agachamento Livre', NULL, NULL),
    (gen_random_uuid(), 'Leg Press 45°', NULL, NULL),
    (gen_random_uuid(), 'Cadeira Extensora', NULL, NULL),
    (gen_random_uuid(), 'Agachamento Búlgaro', NULL, NULL),
    (gen_random_uuid(), 'Afundo (Passada)', NULL, NULL),
    (gen_random_uuid(), 'Mesa Flexora', NULL, NULL),
    (gen_random_uuid(), 'Cadeira Flexora', NULL, NULL),
    (gen_random_uuid(), 'Stiff (Levantamento Terra Romeno)', NULL, NULL),
    (gen_random_uuid(), 'Elevação Pélvica (Hip Thrust)', NULL, NULL),
    (gen_random_uuid(), 'Agachamento Sumô', NULL, NULL),
    (gen_random_uuid(), 'Cadeira Adutora', NULL, NULL),
    (gen_random_uuid(), 'Cadeira Abdutora', NULL, NULL),
    (gen_random_uuid(), 'Coice na Polia (Glute Kickback)', NULL, NULL);

-- Panturrilha
INSERT INTO exercises (id, name, photo, video) VALUES
    (gen_random_uuid(), 'Elevação de Panturrilha em Pé', NULL, NULL),
    (gen_random_uuid(), 'Elevação de Panturrilha Sentado', NULL, NULL),
    (gen_random_uuid(), 'Panturrilha no Leg Press', NULL, NULL);

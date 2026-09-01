-- Exercícios comuns de academia, organizados por grupo muscular predominante
-- (o vínculo formal com muscle_groups acontece via Training, não aqui)

-- Peito
INSERT INTO exercises (id, name, photo, video) VALUES
    (UUID(), 'Supino Reto com Barra', NULL, NULL),
    (UUID(), 'Supino Inclinado com Halteres', NULL, NULL),
    (UUID(), 'Supino Declinado com Barra', NULL, NULL),
    (UUID(), 'Crucifixo Reto com Halteres', NULL, NULL),
    (UUID(), 'Crossover no Cabo', NULL, NULL),
    (UUID(), 'Peck Deck (Voador)', NULL, NULL),
    (UUID(), 'Flexão de Braço', NULL, NULL);

-- Costas
INSERT INTO exercises (id, name, photo, video) VALUES
    (UUID(), 'Puxada Frontal (Pulley)', NULL, NULL),
    (UUID(), 'Puxada Atrás da Nuca', NULL, NULL),
    (UUID(), 'Remada Curvada com Barra', NULL, NULL),
    (UUID(), 'Remada Baixa no Cabo', NULL, NULL),
    (UUID(), 'Remada Unilateral com Halter', NULL, NULL),
    (UUID(), 'Barra Fixa (Pull-up)', NULL, NULL),
    (UUID(), 'Levantamento Terra', NULL, NULL),
    (UUID(), 'Hiperextensão Lombar (Banco Romano)', NULL, NULL);

-- Trapézio e Ombros
INSERT INTO exercises (id, name, photo, video) VALUES
    (UUID(), 'Encolhimento de Ombros com Halteres', NULL, NULL),
    (UUID(), 'Remada Alta', NULL, NULL),
    (UUID(), 'Desenvolvimento com Halteres', NULL, NULL),
    (UUID(), 'Desenvolvimento Militar com Barra', NULL, NULL),
    (UUID(), 'Elevação Lateral', NULL, NULL),
    (UUID(), 'Elevação Frontal', NULL, NULL),
    (UUID(), 'Crucifixo Invertido (Posterior de Ombro)', NULL, NULL);

-- Bíceps, Tríceps e Antebraço
INSERT INTO exercises (id, name, photo, video) VALUES
    (UUID(), 'Rosca Direta com Barra', NULL, NULL),
    (UUID(), 'Rosca Alternada com Halteres', NULL, NULL),
    (UUID(), 'Rosca Martelo', NULL, NULL),
    (UUID(), 'Rosca Scott', NULL, NULL),
    (UUID(), 'Tríceps Corda (Pulley)', NULL, NULL),
    (UUID(), 'Tríceps Testa', NULL, NULL),
    (UUID(), 'Tríceps Francês', NULL, NULL),
    (UUID(), 'Supino Fechado', NULL, NULL),
    (UUID(), 'Mergulho em Paralelas (Dips)', NULL, NULL),
    (UUID(), 'Rosca de Punho', NULL, NULL);

-- Abdômen
INSERT INTO exercises (id, name, photo, video) VALUES
    (UUID(), 'Abdominal Supra', NULL, NULL),
    (UUID(), 'Abdominal Infra', NULL, NULL),
    (UUID(), 'Abdominal Oblíquo', NULL, NULL),
    (UUID(), 'Prancha Isométrica', NULL, NULL),
    (UUID(), 'Elevação de Pernas na Barra', NULL, NULL);

-- Pernas (Quadríceps, Posterior de Coxa, Glúteos, Adutores, Abdutores)
INSERT INTO exercises (id, name, photo, video) VALUES
    (UUID(), 'Agachamento Livre', NULL, NULL),
    (UUID(), 'Leg Press 45°', NULL, NULL),
    (UUID(), 'Cadeira Extensora', NULL, NULL),
    (UUID(), 'Agachamento Búlgaro', NULL, NULL),
    (UUID(), 'Afundo (Passada)', NULL, NULL),
    (UUID(), 'Mesa Flexora', NULL, NULL),
    (UUID(), 'Cadeira Flexora', NULL, NULL),
    (UUID(), 'Stiff (Levantamento Terra Romeno)', NULL, NULL),
    (UUID(), 'Elevação Pélvica (Hip Thrust)', NULL, NULL),
    (UUID(), 'Agachamento Sumô', NULL, NULL),
    (UUID(), 'Cadeira Adutora', NULL, NULL),
    (UUID(), 'Cadeira Abdutora', NULL, NULL),
    (UUID(), 'Coice na Polia (Glute Kickback)', NULL, NULL);

-- Panturrilha
INSERT INTO exercises (id, name, photo, video) VALUES
    (UUID(), 'Elevação de Panturrilha em Pé', NULL, NULL),
    (UUID(), 'Elevação de Panturrilha Sentado', NULL, NULL),
    (UUID(), 'Panturrilha no Leg Press', NULL, NULL);

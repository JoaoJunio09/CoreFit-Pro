-- Exercícios do sistema (system = TRUE), com alguns marcados como favoritos

INSERT INTO exercises (id, name, system, favorite, photo, video) VALUES
    (gen_random_uuid(), 'Supino Reto com Barra', TRUE, TRUE,  NULL, NULL),
    (gen_random_uuid(), 'Supino Inclinado com Halteres', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Supino Declinado com Barra', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Crucifixo Reto com Halteres', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Crossover no Cabo', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Peck Deck (Voador)', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Flexão de Braço', TRUE, FALSE, NULL, NULL);

INSERT INTO exercises (id, name, system, favorite, photo, video) VALUES
    (gen_random_uuid(), 'Puxada Frontal (Pulley)', TRUE, TRUE,  NULL, NULL),
    (gen_random_uuid(), 'Puxada Atrás da Nuca', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Remada Curvada com Barra', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Remada Baixa no Cabo', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Remada Unilateral com Halter', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Barra Fixa (Pull-up)', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Levantamento Terra', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Hiperextensão Lombar (Banco Romano)', TRUE, FALSE, NULL, NULL);

INSERT INTO exercises (id, name, system, favorite, photo, video) VALUES
    (gen_random_uuid(), 'Encolhimento de Ombros com Halteres', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Remada Alta', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Desenvolvimento com Halteres', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Desenvolvimento Militar com Barra', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Elevação Lateral', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Elevação Frontal', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Crucifixo Invertido (Posterior de Ombro)', TRUE, FALSE, NULL, NULL);

INSERT INTO exercises (id, name, system, favorite, photo, video) VALUES
    (gen_random_uuid(), 'Rosca Direta com Barra', TRUE, TRUE,  NULL, NULL),
    (gen_random_uuid(), 'Rosca Alternada com Halteres', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Rosca Martelo', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Rosca Scott', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Tríceps Corda (Pulley)', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Tríceps Testa', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Tríceps Francês', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Supino Fechado', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Mergulho em Paralelas (Dips)', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Rosca de Punho', TRUE, FALSE, NULL, NULL);

INSERT INTO exercises (id, name, system, favorite, photo, video) VALUES
    (gen_random_uuid(), 'Abdominal Supra', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Abdominal Infra', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Abdominal Oblíquo', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Prancha Isométrica', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Elevação de Pernas na Barra', TRUE, FALSE, NULL, NULL);

INSERT INTO exercises (id, name, system, favorite, photo, video) VALUES
    (gen_random_uuid(), 'Agachamento Livre', TRUE, TRUE,  NULL, NULL),
    (gen_random_uuid(), 'Leg Press 45°', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Cadeira Extensora', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Agachamento Búlgaro', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Afundo (Passada)', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Mesa Flexora', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Cadeira Flexora', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Stiff (Levantamento Terra Romeno)', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Elevação Pélvica (Hip Thrust)', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Agachamento Sumô', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Cadeira Adutora', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Cadeira Abdutora', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Coice na Polia (Glute Kickback)', TRUE, FALSE, NULL, NULL);

INSERT INTO exercises (id, name, system, favorite, photo, video) VALUES
    (gen_random_uuid(), 'Elevação de Panturrilha em Pé', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Elevação de Panturrilha Sentado', TRUE, FALSE, NULL, NULL),
    (gen_random_uuid(), 'Panturrilha no Leg Press', TRUE, FALSE, NULL, NULL);

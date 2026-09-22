-- Vínculo de cada exercício (do sistema e personalizado) com seus grupos musculares

INSERT INTO exercise_muscle_groups (exercise_id, muscle_group_id)
SELECT e.id, mg.id
FROM (VALUES
    -- Peito
    ('Supino Reto com Barra', 'Peito'), ('Supino Reto com Barra', 'Tríceps'),
    ('Supino Inclinado com Halteres', 'Peito'), ('Supino Inclinado com Halteres', 'Ombros'),
    ('Supino Declinado com Barra', 'Peito'),
    ('Crucifixo Reto com Halteres', 'Peito'),
    ('Crossover no Cabo', 'Peito'),
    ('Peck Deck (Voador)', 'Peito'),
    ('Flexão de Braço', 'Peito'), ('Flexão de Braço', 'Tríceps'),
    -- Costas
    ('Puxada Frontal (Pulley)', 'Costas'), ('Puxada Frontal (Pulley)', 'Bíceps'),
    ('Puxada Atrás da Nuca', 'Costas'),
    ('Remada Curvada com Barra', 'Costas'), ('Remada Curvada com Barra', 'Bíceps'),
    ('Remada Baixa no Cabo', 'Costas'),
    ('Remada Unilateral com Halter', 'Costas'), ('Remada Unilateral com Halter', 'Bíceps'),
    ('Barra Fixa (Pull-up)', 'Costas'), ('Barra Fixa (Pull-up)', 'Bíceps'),
    ('Levantamento Terra', 'Costas'), ('Levantamento Terra', 'Lombar'), ('Levantamento Terra', 'Posterior de Coxa'), ('Levantamento Terra', 'Glúteos'),
    ('Hiperextensão Lombar (Banco Romano)', 'Lombar'),
    -- Trapézio e Ombros
    ('Encolhimento de Ombros com Halteres', 'Trapézio'),
    ('Remada Alta', 'Trapézio'), ('Remada Alta', 'Ombros'),
    ('Desenvolvimento com Halteres', 'Ombros'), ('Desenvolvimento com Halteres', 'Tríceps'),
    ('Desenvolvimento Militar com Barra', 'Ombros'), ('Desenvolvimento Militar com Barra', 'Tríceps'),
    ('Elevação Lateral', 'Ombros'),
    ('Elevação Frontal', 'Ombros'),
    ('Crucifixo Invertido (Posterior de Ombro)', 'Ombros'),
    -- Bíceps, Tríceps, Antebraço
    ('Rosca Direta com Barra', 'Bíceps'),
    ('Rosca Alternada com Halteres', 'Bíceps'),
    ('Rosca Martelo', 'Bíceps'), ('Rosca Martelo', 'Antebraço'),
    ('Rosca Scott', 'Bíceps'),
    ('Tríceps Corda (Pulley)', 'Tríceps'),
    ('Tríceps Testa', 'Tríceps'),
    ('Tríceps Francês', 'Tríceps'),
    ('Supino Fechado', 'Tríceps'), ('Supino Fechado', 'Peito'),
    ('Mergulho em Paralelas (Dips)', 'Tríceps'), ('Mergulho em Paralelas (Dips)', 'Peito'),
    ('Rosca de Punho', 'Antebraço'),
    -- Abdômen
    ('Abdominal Supra', 'Abdômen'),
    ('Abdominal Infra', 'Abdômen'),
    ('Abdominal Oblíquo', 'Abdômen'),
    ('Prancha Isométrica', 'Abdômen'),
    ('Elevação de Pernas na Barra', 'Abdômen'),
    -- Pernas
    ('Agachamento Livre', 'Quadríceps'), ('Agachamento Livre', 'Glúteos'),
    ('Leg Press 45°', 'Quadríceps'), ('Leg Press 45°', 'Glúteos'),
    ('Cadeira Extensora', 'Quadríceps'),
    ('Agachamento Búlgaro', 'Quadríceps'), ('Agachamento Búlgaro', 'Glúteos'),
    ('Afundo (Passada)', 'Quadríceps'), ('Afundo (Passada)', 'Glúteos'),
    ('Mesa Flexora', 'Posterior de Coxa'),
    ('Cadeira Flexora', 'Posterior de Coxa'),
    ('Stiff (Levantamento Terra Romeno)', 'Posterior de Coxa'), ('Stiff (Levantamento Terra Romeno)', 'Glúteos'),
    ('Elevação Pélvica (Hip Thrust)', 'Glúteos'),
    ('Agachamento Sumô', 'Quadríceps'), ('Agachamento Sumô', 'Glúteos'), ('Agachamento Sumô', 'Adutores'),
    ('Cadeira Adutora', 'Adutores'),
    ('Cadeira Abdutora', 'Abdutores'),
    ('Coice na Polia (Glute Kickback)', 'Glúteos'),
    -- Panturrilha
    ('Elevação de Panturrilha em Pé', 'Panturrilha'),
    ('Elevação de Panturrilha Sentado', 'Panturrilha'),
    ('Panturrilha no Leg Press', 'Panturrilha'),
    -- Exercícios personalizados
    ('Burpee com Salto', 'Quadríceps'), ('Burpee com Salto', 'Peito'), ('Burpee com Salto', 'Abdômen'),
    ('Prancha com Toque no Ombro', 'Abdômen'), ('Prancha com Toque no Ombro', 'Ombros'),
    ('Remada Invertida na TRX', 'Costas'), ('Remada Invertida na TRX', 'Bíceps'),
    ('Agachamento Pistol', 'Quadríceps'), ('Agachamento Pistol', 'Glúteos'), ('Agachamento Pistol', 'Abdutores'),
    ('Flexão Diamante', 'Tríceps'), ('Flexão Diamante', 'Peito')
) AS v(exercise_name, muscle_group_name)
JOIN exercises e ON e.name = v.exercise_name
JOIN muscle_groups mg ON mg.name = v.muscle_group_name;

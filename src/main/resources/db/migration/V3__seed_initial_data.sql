-- V3: seed of data

-- 1. Insertar Clanes
INSERT INTO clans (name, description) VALUES
                                             ('Meta-Galactics', 'Clan enfocado en backend avanzado y arquitectura cloud'),
                                             ('Cyber-Coders', 'Especialistas en desarrollo frontend interactivo y UX');

-- 2. Insert categories (Languages)
INSERT INTO categories(name) VALUES
                                    ('Java'),
                                    ('TypeScript'),
                                    ('PostgreSQL'),
                                    ('Python');

-- 3. Insert coders with his Id to the Clans.
INSERT INTO coders (name, active, clan_id) VALUES
                                               ('Emmanuel Garcia', true, (SELECT id FROM clans WHERE name = 'Meta-Galactics')),
                                               ('Steven Developer', true, (SELECT id FROM clans WHERE name = 'Meta-Galactics')),
                                               ('Yolanda Code', true, (SELECT id FROM clans WHERE name = 'Cyber-Coders')),
                                               ('Sebastian Dev', true, (SELECT id FROM clans WHERE name = 'Cyber-Coders'));

-- 4. Middle table (Many to Many)
INSERT INTO coders_categories (coder_id, categoria_id) VALUES
                                                           ((SELECT id FROM coders WHERE name = 'Emmanuel Garcia'), (SELECT id FROM categories WHERE name = 'Java')),
                                                           ((SELECT id FROM coders WHERE name = 'Emmanuel Garcia'), (SELECT id FROM categories WHERE name = 'PostgreSQL')),
                                                           ((SELECT id FROM coders WHERE name = 'Steven Developer'), (SELECT id FROM categories WHERE name = 'Java')),
                                                           ((SELECT id FROM coders WHERE name = 'Yolanda Code'), (SELECT id FROM categories WHERE name = 'TypeScript')),
                                                           ((SELECT id FROM coders WHERE name = 'Sebastian Dev'), (SELECT id FROM categories WHERE name = 'TypeScript')),
                                                           ((SELECT id FROM coders WHERE name = 'Sebastian Dev'), (SELECT id FROM categories WHERE name = 'Python'));
-- V3: seed of data

-- 1. Insertar Clanes
INSERT INTO clanes (nombre, descripcion) VALUES
                                             ('Meta-Galactics', 'Clan enfocado en backend avanzado y arquitectura cloud'),
                                             ('Cyber-Coders', 'Especialistas en desarrollo frontend interactivo y UX');

-- 2. Insert categories (Languages)
INSERT INTO categories(nombre) VALUES
                                    ('Java'),
                                    ('TypeScript'),
                                    ('PostgreSQL'),
                                    ('Python');

-- 3. Insert coders with his Id to the Clans.
INSERT INTO coders (name, activo, clan_id) VALUES
                                               ('Emmanuel Garcia', true, (SELECT id FROM clanes WHERE nombre = 'Meta-Galactics')),
                                               ('Steven Developer', true, (SELECT id FROM clanes WHERE nombre = 'Meta-Galactics')),
                                               ('Yolanda Code', true, (SELECT id FROM clanes WHERE nombre = 'Cyber-Coders')),
                                               ('Sebastian Dev', true, (SELECT id FROM clanes WHERE nombre = 'Cyber-Coders'));

-- 4. Middle table (Many to Many)
INSERT INTO coders_categories (coder_id, categoria_id) VALUES
                                                           ((SELECT id FROM coders WHERE name = 'Emmanuel Garcia'), (SELECT id FROM categorias WHERE nombre = 'Java')),
                                                           ((SELECT id FROM coders WHERE name = 'Emmanuel Garcia'), (SELECT id FROM categorias WHERE nombre = 'PostgreSQL')),
                                                           ((SELECT id FROM coders WHERE name = 'Steven Developer'), (SELECT id FROM categorias WHERE nombre = 'Java')),
                                                           ((SELECT id FROM coders WHERE name = 'Yolanda Code'), (SELECT id FROM categorias WHERE nombre = 'TypeScript')),
                                                           ((SELECT id FROM coders WHERE name = 'Sebastian Dev'), (SELECT id FROM categorias WHERE nombre = 'TypeScript')),
                                                           ((SELECT id FROM coders WHERE name = 'Sebastian Dev'), (SELECT id FROM categorias WHERE nombre = 'Python'));
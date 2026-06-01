-- V1: Base structure to coders managment PostgreSQL

CREATE TABLE clans (
                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                        name VARCHAR(255) NOT NULL UNIQUE,
                        description TEXT
);

CREATE TABLE categories (
                            id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                            name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE coders (
                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                        name VARCHAR(255) NOT NULL,
                        active BOOLEAN NOT NULL DEFAULT TRUE,
                        clan_id UUID NOT NULL,
                        CONSTRAINT fk_coder_clan FOREIGN KEY (clan_id) REFERENCES clans(id) ON DELETE RESTRICT
);
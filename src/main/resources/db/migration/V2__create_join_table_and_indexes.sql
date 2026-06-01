-- V2: Table to  make the relation many to many between coders and category

CREATE TABLE coders_categories (
                                   coder_id UUID NOT NULL,
                                   categoria_id UUID NOT NULL,
                                   PRIMARY KEY (coder_id, categoria_id),
                                   CONSTRAINT fk_cc_coder FOREIGN KEY (coder_id) REFERENCES coders(id) ON DELETE CASCADE,
                                   CONSTRAINT fk_cc_categoria FOREIGN KEY (categoria_id) REFERENCES categories(id) ON DELETE CASCADE
);

-- index to improve the performance in supabase
CREATE INDEX idx_coders_clan ON coders(clan_id);
CREATE INDEX idx_coders_active ON coders(active);
CREATE INDEX idx_clans_names ON clans(name);
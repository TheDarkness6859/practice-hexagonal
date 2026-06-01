ALTER TABLE coders_categories DROP CONSTRAINT fk_cc_categoria;

ALTER TABLE coders_categories RENAME COLUMN categoria_id TO category_id;

ALTER TABLE coders_categories
    ADD CONSTRAINT fk_cc_category FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE;
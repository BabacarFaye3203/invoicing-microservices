-- Création de la table
CREATE TABLE public.currency (
                          id SERIAL PRIMARY KEY,
                          uuid VARCHAR(255) NOT NULL,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          is_active BOOLEAN DEFAULT TRUE
);

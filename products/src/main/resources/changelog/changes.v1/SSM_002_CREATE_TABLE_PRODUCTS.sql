CREATE TABLE public.products (
                          id SERIAL PRIMARY KEY,
                          uuid VARCHAR(255),
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          price NUMERIC(10,2),
                          image VARCHAR(255),
                          category VARCHAR(100),
                          is_active BOOLEAN DEFAULT TRUE,
                          stock_level DOUBLE PRECISION DEFAULT 0
);


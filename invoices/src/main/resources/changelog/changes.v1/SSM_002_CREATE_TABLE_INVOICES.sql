CREATE TABLE public.invoices (
                          id SERIAL PRIMARY KEY,
                          uuid VARCHAR(255),
                          date DATE,
                          language VARCHAR(100),
                          number VARCHAR(100),
                          status VARCHAR(100),
                          creation_date TIMESTAMP,
                          note TEXT,
                          individual_customer VARCHAR(255),
                          invoice_products VARCHAR(255),
                          payment VARCHAR(255),
                          currency varchar(50)
);


CREATE TABLE public.invoices (
                          id SERIAL PRIMARY KEY,
                          uuid VARCHAR(255),
                          date DATE,
                          language VARCHAR(100),
                          number VARCHAR(100),
                          status VARCHAR(100),
                          creation_date TIMESTAMP,
                          note TEXT,
                          is_sent BOOLEAN,
                          individual_customer VARCHAR(255),
                          enterprise_customer VARCHAR(255),
                          invoice_products VARCHAR(255),
                          invoice_services VARCHAR(255),
                          invoice_payments VARCHAR(255)
);


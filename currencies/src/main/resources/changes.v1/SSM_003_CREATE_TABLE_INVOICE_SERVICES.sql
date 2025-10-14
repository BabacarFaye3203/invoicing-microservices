CREATE TABLE invoice_services (
                                  id SERIAL PRIMARY KEY,
                                  uuid VARCHAR(255),
                                  service_uuid VARCHAR(255),
                                  designation VARCHAR(255),
                                  unit_price DOUBLE PRECISION,
                                  quantity DOUBLE PRECISION,
                                  discount DOUBLE PRECISION,
                                  taxe DOUBLE PRECISION,
                                  total_price DOUBLE PRECISION,
                                  discount_type VARCHAR(100),
                                  invoice_id BIGINT,
                                  CONSTRAINT fk_invoice
                                      FOREIGN KEY (invoice_id)
                                          REFERENCES public.invoices(id)
                                          ON DELETE CASCADE
);

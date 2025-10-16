CREATE TABLE invoice_products (
                                  id SERIAL PRIMARY KEY,
                                  uuid VARCHAR(255),
                                  product_uuid VARCHAR(255),
                                  designation VARCHAR(255),
                                  unit_price DOUBLE PRECISION,
                                  quantity DOUBLE PRECISION,
                                  discount DOUBLE PRECISION,
                                  taxe DOUBLE PRECISION,
                                  total_price DOUBLE PRECISION,
                                  discount_type VARCHAR(100),
                                  invoice VARCHAR(50)
);

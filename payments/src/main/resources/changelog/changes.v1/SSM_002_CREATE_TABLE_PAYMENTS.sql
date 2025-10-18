CREATE TABLE public.payments (
                                  id SERIAL PRIMARY KEY,
                                  uuid VARCHAR(255),
                                  prix VARCHAR(255),
                                  payment_method VARCHAR(255),
                                  payment_date DATE
);

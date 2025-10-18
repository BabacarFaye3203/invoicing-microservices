ALTER TABLE public.invoices
ADD COLUMN currency varchar(50);

ALTER TABLE public.invoices
    ADD COLUMN payment varchar(50);
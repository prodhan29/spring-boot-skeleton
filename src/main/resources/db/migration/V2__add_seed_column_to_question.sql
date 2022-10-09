ALTER TABLE  public.question
    ADD COLUMN IF NOT EXISTS seed character varying(255) COLLATE pg_catalog."default";
-- Table: public.question

-- DROP TABLE IF EXISTS public.question;

CREATE TABLE IF NOT EXISTS public.question
(
    id integer NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    hint character varying(255) COLLATE pg_catalog."default",
    mandatory character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT question_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.question
    OWNER to postgres;
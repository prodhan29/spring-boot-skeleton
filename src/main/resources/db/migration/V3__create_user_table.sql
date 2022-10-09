CREATE TABLE public.app_user (
     id integer NOT NULL,
     created_at timestamp without time zone,
     updated_at timestamp without time zone,
     account_non_expired boolean NOT NULL,
     account_non_locked boolean NOT NULL,
     credentials_non_expired boolean NOT NULL,
     enabled boolean NOT NULL,
     name character varying(255),
     password character varying(255),
     username character varying(255)
);


ALTER TABLE public.app_user OWNER TO postgres;

ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT app_user_pkey PRIMARY KEY (id);
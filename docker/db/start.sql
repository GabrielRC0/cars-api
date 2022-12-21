-- Table: brand
CREATE TABLE IF NOT EXISTS public.brand
(
    id BIGINT NOT NULL,
    name VARCHAR(255),

    CONSTRAINT pk_brand PRIMARY KEY (id)
);


CREATE SEQUENCE brand_seq
    AS BIGINT
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY public.brand.id;

ALTER TABLE public.brand ALTER COLUMN id SET DEFAULT nextval('brand_seq'::regclass);


-- Table: model
CREATE TABLE IF NOT EXISTS public.model
(
    id BIGINT NOT NULL,
    brand_id BIGINT NOT NULL,
    name VARCHAR(255),
    fipe_value DECIMAL,

    CONSTRAINT pk_model PRIMARY KEY (id)
);


CREATE SEQUENCE model_seq
    AS BIGINT
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY public.model.id;

ALTER TABLE public.model ALTER COLUMN id SET DEFAULT nextval('model_seq'::regclass);

ALTER TABLE public.model ADD CONSTRAINT fk_model_brand_id FOREIGN KEY (brand_id) REFERENCES public.brand (id);

-- Table: car
CREATE TABLE IF NOT EXISTS public.car
(
    id BIGINT NOT NULL,
    model_id BIGINT NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE,
    year INTEGER,
    fuel VARCHAR(255),
    doors_amount INTEGER,
    color VARCHAR(255),

    CONSTRAINT pk_car PRIMARY KEY (id)
);


CREATE SEQUENCE car_seq
    AS BIGINT
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY public.car.id;

ALTER TABLE public.car ALTER COLUMN id SET DEFAULT nextval('car_seq'::regclass);

ALTER TABLE public.car ADD CONSTRAINT fk_car_model_id FOREIGN KEY (model_id) REFERENCES public.model (id);
--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3
-- Dumped by pg_dump version 14.3

-- Started on 2022-05-30 14:11:37

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 212 (class 1259 OID 17161)
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    id integer NOT NULL,
    name character(45) NOT NULL,
    img character(255),
    created_at timestamp with time zone DEFAULT now() NOT NULL,
    updated_at timestamp with time zone DEFAULT now() NOT NULL
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 17160)
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categories_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categories_id_seq OWNER TO postgres;

--
-- TOC entry 3368 (class 0 OID 0)
-- Dependencies: 211
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categories_id_seq OWNED BY public.categories.id;


--
-- TOC entry 214 (class 1259 OID 17174)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id integer NOT NULL,
    name character(45) NOT NULL,
    img character(255) NOT NULL,
    description text,
    price double precision NOT NULL,
    unit character(18) NOT NULL,
    city character(25) NOT NULL,
    category_id integer,
    created_at timestamp with time zone DEFAULT now() NOT NULL,
    updated_at timestamp with time zone DEFAULT now() NOT NULL
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 17173)
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_id_seq OWNER TO postgres;

--
-- TOC entry 3369 (class 0 OID 0)
-- Dependencies: 213
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- TOC entry 210 (class 1259 OID 17146)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character(45) NOT NULL,
    password character(45) NOT NULL,
    first_name character(25) NOT NULL,
    last_name character(25) NOT NULL,
    approved boolean DEFAULT false NOT NULL,
    created_at timestamp with time zone DEFAULT now() NOT NULL,
    updated_at timestamp with time zone DEFAULT now() NOT NULL,
    role_type character(6) DEFAULT 'client'::bpchar
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 17145)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3370 (class 0 OID 0)
-- Dependencies: 209
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 216 (class 1259 OID 17194)
-- Name: votes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.votes (
    id integer NOT NULL,
    vote_percent integer NOT NULL,
    client_id integer NOT NULL,
    product_id integer NOT NULL,
    created_at timestamp with time zone DEFAULT now() NOT NULL,
    updated_at timestamp with time zone DEFAULT now() NOT NULL
);


ALTER TABLE public.votes OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 17193)
-- Name: votes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.votes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.votes_id_seq OWNER TO postgres;

--
-- TOC entry 3371 (class 0 OID 0)
-- Dependencies: 215
-- Name: votes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.votes_id_seq OWNED BY public.votes.id;


--
-- TOC entry 3184 (class 2604 OID 17164)
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories ALTER COLUMN id SET DEFAULT nextval('public.categories_id_seq'::regclass);


--
-- TOC entry 3187 (class 2604 OID 17177)
-- Name: products id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- TOC entry 3179 (class 2604 OID 17149)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3190 (class 2604 OID 17197)
-- Name: votes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes ALTER COLUMN id SET DEFAULT nextval('public.votes_id_seq'::regclass);


--
-- TOC entry 3358 (class 0 OID 17161)
-- Dependencies: 212
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categories (id, name, img, created_at, updated_at) FROM stdin;
1	oils                                         	oils.jpg                                                                                                                                                                                                                                                       	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02
2	spices                                       	spices.jpg                                                                                                                                                                                                                                                     	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02
3	vegetables                                   	vegetables.jpg                                                                                                                                                                                                                                                 	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02
\.


--
-- TOC entry 3360 (class 0 OID 17174)
-- Dependencies: 214
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (id, name, img, description, price, unit, city, category_id, created_at, updated_at) FROM stdin;
1	Saffron                                      	saffron.jpg                                                                                                                                                                                                                                                    	Saffron is a spice derived from the flower of Crocus sativus, commonly known as the "saffron crocus".	25	gram              	Taliouine                	2	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02
2	Garlic                                       	garlic.jpg                                                                                                                                                                                                                                                     	Garlic is a species of bulbous flowering plant in the genus Allium. Its close relatives include the onion...	40	kilogram          	Asakui                   	2	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02
3	Argan                                        	argan.jpg                                                                                                                                                                                                                                                      	Argan oil is a plant oil produced from the kernels of the argan tree that is endemic to Morocco. In Morocco...	400	liter             	Taroudant                	1	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02
4	Ratte potato                                 	ratte-potato.jpg                                                                                                                                                                                                                                               	The Ratte potato is a small potato with a unique nutty flavor and smooth, buttery texture...	15	kilogram          	Tiznit                   	3	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02
\.


--
-- TOC entry 3356 (class 0 OID 17146)
-- Dependencies: 210
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, email, password, first_name, last_name, approved, created_at, updated_at, role_type) FROM stdin;
2	mustapha@anmon.ma                            	password                                     	mustapha                 	ihoum                    	t	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02	client
3	nawal@anmoon.ma                              	password                                     	nawal                    	boulahsaire              	f	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02	client
1	najib@anmoon.ma                              	password                                     	najib                    	rachid                   	t	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02	admin 
\.


--
-- TOC entry 3362 (class 0 OID 17194)
-- Dependencies: 216
-- Data for Name: votes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.votes (id, vote_percent, client_id, product_id, created_at, updated_at) FROM stdin;
1	85	3	3	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02
2	90	3	1	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02
3	100	2	4	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02
4	30	2	3	2022-05-30 14:11:18.991076+02	2022-05-30 14:11:18.991076+02
\.


--
-- TOC entry 3372 (class 0 OID 0)
-- Dependencies: 211
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categories_id_seq', 3, true);


--
-- TOC entry 3373 (class 0 OID 0)
-- Dependencies: 213
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_id_seq', 4, true);


--
-- TOC entry 3374 (class 0 OID 0)
-- Dependencies: 209
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 3, true);


--
-- TOC entry 3375 (class 0 OID 0)
-- Dependencies: 215
-- Name: votes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.votes_id_seq', 4, true);


--
-- TOC entry 3194 (class 2606 OID 17154)
-- Name: users Users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY (id, email);


--
-- TOC entry 3200 (class 2606 OID 17170)
-- Name: categories categories_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_id_key UNIQUE (id);


--
-- TOC entry 3202 (class 2606 OID 17172)
-- Name: categories categories_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_name_key UNIQUE (name);


--
-- TOC entry 3204 (class 2606 OID 17168)
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id, name);


--
-- TOC entry 3206 (class 2606 OID 17185)
-- Name: products products_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_id_key UNIQUE (id);


--
-- TOC entry 3208 (class 2606 OID 17187)
-- Name: products products_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_name_key UNIQUE (name);


--
-- TOC entry 3210 (class 2606 OID 17183)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id, name);


--
-- TOC entry 3196 (class 2606 OID 17158)
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- TOC entry 3198 (class 2606 OID 17156)
-- Name: users users_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_id_key UNIQUE (id);


--
-- TOC entry 3212 (class 2606 OID 17201)
-- Name: votes votes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes
    ADD CONSTRAINT votes_pkey PRIMARY KEY (id);


--
-- TOC entry 3213 (class 2606 OID 17188)
-- Name: products category_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT category_fkey FOREIGN KEY (category_id) REFERENCES public.categories(id) ON DELETE SET NULL;


--
-- TOC entry 3214 (class 2606 OID 17202)
-- Name: votes client_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes
    ADD CONSTRAINT client_fkey FOREIGN KEY (client_id) REFERENCES public.users(id) ON DELETE CASCADE;


--
-- TOC entry 3215 (class 2606 OID 17207)
-- Name: votes product_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes
    ADD CONSTRAINT product_fkey FOREIGN KEY (product_id) REFERENCES public.products(id) ON DELETE CASCADE;


-- Completed on 2022-05-30 14:11:38

--
-- PostgreSQL database dump complete
--


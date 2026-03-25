--
-- PostgreSQL database dump
--

\restrict GhfrlDuj17RZ0WgG5NtczgaZPxhI4Z2hehqBtWfV0HjCFrErtTGFCO6cOdqjFTs

-- Dumped from database version 14.8 (Ubuntu 14.8-0ubuntu0.22.10.1)
-- Dumped by pg_dump version 18.2

-- Started on 2026-03-23 20:41:44

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 209 (class 1259 OID 50562)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    dni character(10) NOT NULL,
    apellidos character varying(60),
    nombre character varying(80),
    fecha_nac date,
    tfno character varying(10)
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 50565)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.producto (
    codigo integer NOT NULL,
    ruc character(10) NOT NULL,
    descripcion character varying(60),
    precio double precision
);


ALTER TABLE public.producto OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 50568)
-- Name: proveedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.proveedor (
    ruc character(10) NOT NULL,
    empresa character varying(60),
    direccion character varying(100)
);


ALTER TABLE public.proveedor OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 50571)
-- Name: venta_cab; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.venta_cab (
    numero integer NOT NULL,
    fecha date NOT NULL,
    dni character(10) NOT NULL
);


ALTER TABLE public.venta_cab OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 50574)
-- Name: venta_det; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.venta_det (
    numero integer NOT NULL,
    codigo integer NOT NULL,
    pu double precision,
    dscto double precision,
    cantidad integer,
    subtotal double precision
);


ALTER TABLE public.venta_det OWNER TO postgres;

--
-- TOC entry 3356 (class 0 OID 50562)
-- Dependencies: 209
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (dni, apellidos, nombre, fecha_nac, tfno) FROM stdin;
\.


--
-- TOC entry 3357 (class 0 OID 50565)
-- Dependencies: 210
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.producto (codigo, ruc, descripcion, precio) FROM stdin;
\.


--
-- TOC entry 3358 (class 0 OID 50568)
-- Dependencies: 211
-- Data for Name: proveedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.proveedor (ruc, empresa, direccion) FROM stdin;
\.


--
-- TOC entry 3359 (class 0 OID 50571)
-- Dependencies: 212
-- Data for Name: venta_cab; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venta_cab (numero, fecha, dni) FROM stdin;
\.


--
-- TOC entry 3360 (class 0 OID 50574)
-- Dependencies: 213
-- Data for Name: venta_det; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venta_det (numero, codigo, pu, dscto, cantidad, subtotal) FROM stdin;
\.


--
-- TOC entry 3199 (class 2606 OID 50578)
-- Name: cliente pk_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT pk_cliente PRIMARY KEY (dni);


--
-- TOC entry 3201 (class 2606 OID 50580)
-- Name: producto pk_producto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT pk_producto PRIMARY KEY (codigo);


--
-- TOC entry 3205 (class 2606 OID 50582)
-- Name: proveedor pk_proveedor; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT pk_proveedor PRIMARY KEY (ruc);


--
-- TOC entry 3208 (class 2606 OID 50584)
-- Name: venta_cab pk_venta_cab; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venta_cab
    ADD CONSTRAINT pk_venta_cab PRIMARY KEY (numero);


--
-- TOC entry 3212 (class 2606 OID 50586)
-- Name: venta_det pk_venta_det; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venta_det
    ADD CONSTRAINT pk_venta_det PRIMARY KEY (numero, codigo);


--
-- TOC entry 3197 (class 1259 OID 50587)
-- Name: cliente_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX cliente_pk ON public.cliente USING btree (dni);


--
-- TOC entry 3202 (class 1259 OID 50588)
-- Name: producto_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX producto_pk ON public.producto USING btree (codigo);


--
-- TOC entry 3206 (class 1259 OID 50589)
-- Name: proveedor_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX proveedor_pk ON public.proveedor USING btree (ruc);


--
-- TOC entry 3203 (class 1259 OID 50590)
-- Name: suministra_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX suministra_fk ON public.producto USING btree (ruc);


--
-- TOC entry 3209 (class 1259 OID 50591)
-- Name: venta_cab_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX venta_cab_fk ON public.venta_cab USING btree (dni);


--
-- TOC entry 3210 (class 1259 OID 50592)
-- Name: venta_cab_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX venta_cab_pk ON public.venta_cab USING btree (numero);


--
-- TOC entry 3213 (class 2606 OID 50593)
-- Name: producto fk_producto_suministr_proveedo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT fk_producto_suministr_proveedo FOREIGN KEY (ruc) REFERENCES public.proveedor(ruc) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3214 (class 2606 OID 50598)
-- Name: venta_cab fk_venta_ca_venta_cab_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venta_cab
    ADD CONSTRAINT fk_venta_ca_venta_cab_cliente FOREIGN KEY (dni) REFERENCES public.cliente(dni) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3215 (class 2606 OID 50603)
-- Name: venta_det fk_venta_de_reference_producto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venta_det
    ADD CONSTRAINT fk_venta_de_reference_producto FOREIGN KEY (codigo) REFERENCES public.producto(codigo) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3216 (class 2606 OID 50608)
-- Name: venta_det fk_venta_de_reference_venta_ca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venta_det
    ADD CONSTRAINT fk_venta_de_reference_venta_ca FOREIGN KEY (numero) REFERENCES public.venta_cab(numero) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3366 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 3367 (class 0 OID 0)
-- Dependencies: 209
-- Name: TABLE cliente; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,REFERENCES,DELETE,TRIGGER,TRUNCATE,UPDATE ON TABLE public.cliente TO modulo4;


--
-- TOC entry 3368 (class 0 OID 0)
-- Dependencies: 210
-- Name: TABLE producto; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,REFERENCES,DELETE,TRIGGER,TRUNCATE,UPDATE ON TABLE public.producto TO modulo4;


--
-- TOC entry 3369 (class 0 OID 0)
-- Dependencies: 211
-- Name: TABLE proveedor; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,REFERENCES,DELETE,TRIGGER,TRUNCATE,UPDATE ON TABLE public.proveedor TO modulo4;


--
-- TOC entry 3370 (class 0 OID 0)
-- Dependencies: 212
-- Name: TABLE venta_cab; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,REFERENCES,DELETE,TRIGGER,TRUNCATE,UPDATE ON TABLE public.venta_cab TO modulo4;


--
-- TOC entry 3371 (class 0 OID 0)
-- Dependencies: 213
-- Name: TABLE venta_det; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,REFERENCES,DELETE,TRIGGER,TRUNCATE,UPDATE ON TABLE public.venta_det TO modulo4;


-- Completed on 2026-03-23 20:41:57

--
-- PostgreSQL database dump complete
--

\unrestrict GhfrlDuj17RZ0WgG5NtczgaZPxhI4Z2hehqBtWfV0HjCFrErtTGFCO6cOdqjFTs


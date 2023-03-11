-- Adminer 4.8.1 PostgreSQL 15.2 (Debian 15.2-1.pgdg110+1) dump

\connect "vaccination_inventory";

DROP TABLE IF EXISTS "employee";
DROP SEQUENCE IF EXISTS employee_id_seq;
CREATE SEQUENCE employee_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."employee" (
    "id" bigint DEFAULT nextval('employee_id_seq') NOT NULL,
    "address" character varying(200),
    "birth_date" date,
    "celphone" character varying(20),
    "dni" character varying(10) NOT NULL,
    "email" character varying(100),
    "last_name" character varying(100),
    "name" character varying(100),
    "vaccination_status" character varying(255),
    CONSTRAINT "employee_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "uk_gwcmllong7g1rcmikpkebtgm3" UNIQUE ("dni")
) WITH (oids = false);


DROP TABLE IF EXISTS "role";
DROP SEQUENCE IF EXISTS role_id_seq;
CREATE SEQUENCE role_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."role" (
    "id" bigint DEFAULT nextval('role_id_seq') NOT NULL,
    "abbreviation" character varying(255) NOT NULL,
    "name" character varying(255) NOT NULL,
    CONSTRAINT "role_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "uk_8sewwnpamngi6b1dwaa88askk" UNIQUE ("name"),
    CONSTRAINT "uk_d7hmpsfvj3jk95cd592pfi6gv" UNIQUE ("abbreviation")
) WITH (oids = false);

INSERT INTO "role" ("id", "abbreviation", "name") VALUES
(1,	'ADMIN',	'administrator'),
(2,	'EMPLOYEE',	'employee');

DROP TABLE IF EXISTS "users";
DROP SEQUENCE IF EXISTS users_id_seq;
CREATE SEQUENCE users_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."users" (
    "id" bigint DEFAULT nextval('users_id_seq') NOT NULL,
    "password" character varying(255),
    "username" character varying(255),
    "employee_id" bigint,
    "rol_id" bigint NOT NULL,
    CONSTRAINT "users_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


DROP TABLE IF EXISTS "vaccination_employee";
DROP SEQUENCE IF EXISTS vaccination_employee_id_seq;
CREATE SEQUENCE vaccination_employee_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."vaccination_employee" (
    "id" bigint DEFAULT nextval('vaccination_employee_id_seq') NOT NULL,
    "dose_number" integer,
    "vaccine_type" character varying(50),
    "vaccinated_at" date,
    "employee_id" bigint NOT NULL,
    CONSTRAINT "uk_1l5xh0cfb90rx43wmp8pye1at" UNIQUE ("employee_id"),
    CONSTRAINT "vaccination_employee_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


ALTER TABLE ONLY "public"."users" ADD CONSTRAINT "fkfndbe67uw6silwqnlyudtwqmo" FOREIGN KEY (employee_id) REFERENCES employee(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."users" ADD CONSTRAINT "fkkksicer153k41riohscihua60" FOREIGN KEY (rol_id) REFERENCES role(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."vaccination_employee" ADD CONSTRAINT "fkiosud1qtr6qs5culdlcb1ttlq" FOREIGN KEY (employee_id) REFERENCES employee(id) NOT DEFERRABLE;

-- 2023-03-11 19:04:55.095906+00

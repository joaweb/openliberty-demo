-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE IF NOT EXISTS users
(
    id                   SERIAL PRIMARY KEY ,
    bank_name            varchar(30) NOT NULL,
    account_holder_name  varchar(100) NOT NULL,
    account_number       varchar(10) DEFAULT NULL,
    account_holder_email varchar(100)     NOT NULL
);

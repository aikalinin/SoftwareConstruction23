-- liquibase formatted sql
-- changeset aikalinin@hse.ru:1
alter table person add column address varchar null;
-- rollback alter table person drop column address;
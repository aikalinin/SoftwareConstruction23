-- liquibase formatted sql
-- changeset aikalinin@hse.ru:1 logicalFilePath:1.0.0/default_user.sql
create table default_user
(
    id       uuid default gen_random_uuid(),
    name     varchar(255),
    password varchar(255),
    role     varchar(10)
        constraint ch_role check (role in ('ADMIN', 'DEFAULT'))
)
-- rollback delete default_user;

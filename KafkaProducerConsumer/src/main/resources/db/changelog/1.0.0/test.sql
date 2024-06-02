-- liquibase formatted sql
-- changeset aikalinin@hse.ru:1 logicalFilePath:1.0.0/test.sql
create table test
(
    id   uuid default gen_random_uuid(),
    name varchar(255)
)
-- rollback delete test;

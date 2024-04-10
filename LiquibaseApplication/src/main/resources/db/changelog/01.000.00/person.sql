-- liquibase formatted sql
-- changeset aikalinin@hse.ru:1 -comment:Comment for person
create table person
(
    id   int primary key,
    name varchar(10) not null
)
-- rollback delete person;

-- changeset aikalinin@hse.ru:2
insert into person (id, name) values (1, 'vasya');

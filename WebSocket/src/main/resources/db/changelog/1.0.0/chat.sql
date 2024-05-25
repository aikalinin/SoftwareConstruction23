-- liquibase formatted sql
-- changeset aikalinin@hse.ru:1 logicalFilePath:1.0.0/chat.sql
create table chat
(
    id        uuid default gen_random_uuid()
        primary key,
    name varchar(255)
)
-- rollback delete chat;

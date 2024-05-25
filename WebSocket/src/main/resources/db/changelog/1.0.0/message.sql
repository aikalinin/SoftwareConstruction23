-- liquibase formatted sql
-- changeset aikalinin@hse.ru:1 logicalFilePath:1.0.0/message.sql
create table message
(
    id           uuid default gen_random_uuid()
        primary key,
    chat_id      uuid references chat (id),
    message_time timestamp,
    content      varchar(255),
    author_name  varchar(128)
)
-- rollback delete message;

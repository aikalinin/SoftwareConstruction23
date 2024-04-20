\c

create user "postgres-user" with password 'postgres-password';

create database hse_sc with owner = 'postgres';

\c hse_sc

create schema ext;

grant usage on schema ext to "postgres-user";
alter role "postgres-user" set search_path = template, ext, public;

create extension "uuid-ossp" schema ext;
create schema template authorization "postgres-user";

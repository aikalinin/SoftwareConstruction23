create table if not exists chief
(
    id   int          not null primary key,
    name varchar(128) not null
    );

create table if not exists cookie
(
    name   varchar(128) not null primary key,
    weight float        null,
    chief  int          not null references chief (id)
    );

-- chief 1 - 1..* cookie
--

insert into chief (name, id)
values ('Vasya', 1);
insert into chief (id, name)
values (2, 'Alexey');

select c.name
from chief c
where c.id = 1;
select c.name
from chief c;

insert into cookie (name, weight, chief)
values ('Шоколад', 10, 2);

insert into cookie (name, weight, chief)
values ('Без начинки', 10, 1);

select *
from cookie;

update cookie
set name   = 'Ваниль',
    weight = 5
where chief = 2;

delete
from cookie;

create table hall
(
    id   uuid         not null primary key,
    name varchar(255) not null
);

create table ticket
(
    id          uuid not null primary key,
    seat_number int  not null,
    hall_id     uuid not null references hall (id)
);

select h from hall h where h.name = 'First';

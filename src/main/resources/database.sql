use ht10;

create table users
(
    id         integer auto_increment primary key,
    login      varchar(50) not null,
    password   varchar(50) not null,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    age        integer     not null
);

insert into users (login, password, first_name, last_name, age) value ('tom','tom','tom','tison',15);
insert into users (login, password, first_name, last_name, age) value ('bob','bob','bob','vice',30);
insert into users (login, password, first_name, last_name, age) value ('kate','kate','kate','liper',25);
insert into users (login, password, first_name, last_name, age) value ('mike','mike','mike','bile',22);
insert into users (login, password, first_name, last_name, age) value ('vlad','vlad','vlad','lailo',19);
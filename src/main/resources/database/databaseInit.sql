use ct19;

create table shop
(
    shop_id   integer auto_increment primary key,
    shop_name varchar(20) not null
);

create table position
(
    position_id   integer auto_increment primary key,
    position_name varchar(20) not null,
    shop_id       integer,
    foreign key (shop_id) references shop (shop_id)
);

create table person
(
    person_id   integer auto_increment primary key,
    first_name  varchar(20),
    position_id integer,
    foreign key (position_id) references position (position_id)
);

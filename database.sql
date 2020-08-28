-- auto-generated definition
create table vehicles
(
    name varchar(100) null comment 'resource path:vehicles/{vin}',
    vin  varchar(128) null,
    id   varchar(36)  not null comment 'just used in db'
        primary key
);


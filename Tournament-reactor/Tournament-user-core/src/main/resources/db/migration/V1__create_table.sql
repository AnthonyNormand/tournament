CREATE TABLE USERS (
    ID serial primary key,
    LOGIN varchar(256) not null,
    PASSWORD varchar(512) not null,
    SALT varchar(512) not null,
    EMAIL varchar(256) not null,
    FIRSTNAME varchar(100) not null,
    LASTNAME varchar(100) not null
);

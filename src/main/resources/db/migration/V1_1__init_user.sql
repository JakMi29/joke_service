  create table _user (
       id SERIAL not null,
        email varchar(255),
        firstname varchar(255),
        lastname varchar(255),
        password varchar(255),
        role varchar(255),
        primary key (id)
    );
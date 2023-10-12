INSERT INTO _user (email, first_name, last_name, password, role)
VALUES("user@gmail.com","userName", "userLastname", "$2a$10$SNwa/sfgVcqc8NtFJDtLc.HhVgDxMEdP8iBKb4PsiHAEdxj80CRqS", "USER");
{
    "firstname": "firstname",
    "lastname": "lastname",
    "password": "password",
    "email": "email@gmail.com"
}
 create table _user (
       id SERIAL not null,
        email varchar(255),
        firstname varchar(255),
        lastname varchar(255),
        password varchar(255),
        role varchar(255),
        primary key (id)
    );
  CREATE TABLE joke_service_user (
        id SERIAL NOT NULL,
        email VARCHAR(255),
        username VARCHAR(255),
        user_id INT NOT NULL,
        PRIMARY KEY (id),
        CONSTRAINT fk_user_id
            FOREIGN KEY (user_id)
                REFERENCES _user(id)
    );
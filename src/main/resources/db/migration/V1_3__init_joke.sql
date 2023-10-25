CREATE TABLE joke (
        id SERIAL NOT NULL,
        description VARCHAR(255),
        contents VARCHAR(255),
        category VARCHAR(255),
        joke_service_user_id INT NOT NULL,
        PRIMARY KEY (id),
        CONSTRAINT fk_joke_service_user_id
            FOREIGN KEY (joke_service_user_id)
                REFERENCES joke_service_user (id)
    );
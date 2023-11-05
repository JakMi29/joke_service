CREATE TABLE joke (
        id SERIAL NOT NULL,
        name VARCHAR(255),
        contents VARCHAR(255),
        category VARCHAR(255),
        service_user_id INT NOT NULL,
        PRIMARY KEY (id),
        CONSTRAINT fk_service_user_id
            FOREIGN KEY (service_user_id)
                REFERENCES service_user (id)
    );
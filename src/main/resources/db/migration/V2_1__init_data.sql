INSERT INTO _user (email, firstname, lastname, password, role)
VALUES('user@gmail.com','userName', 'userLastname', '$2a$10$SNwa/sfgVcqc8NtFJDtLc.HhVgDxMEdP8iBKb4PsiHAEdxj80CRqS', 'USER');

INSERT INTO joke_service_user(email,username,user_id)
VALUES('user@gmail.com', 'username',1);

INSERT INTO joke (description,contents,joke_service_user_id)
VALUES('description', 'this is joke', 1);
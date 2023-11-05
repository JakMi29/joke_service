INSERT INTO _user (email, firstname, lastname, password, role)
VALUES('user@gmail.com','userName', 'userLastname', '$2a$10$SNwa/sfgVcqc8NtFJDtLc.HhVgDxMEdP8iBKb4PsiHAEdxj80CRqS', 'USER');

INSERT INTO service_user(email,username)
VALUES('user@gmail.com', 'username');

INSERT INTO joke (name, category, contents, service_user_id)
VALUES ('Koala and the Eucalyptus Tree', 'ANIMAL', 'Why did the koala break up with the eucalyptus tree? Because it had too many leaves and couldn''t commit!', 1),
       ('The Frog and the Loan', 'ANIMAL', 'Why did the frog take out a loan? He wanted to jumpstart his business!', 1),
       ('The Dancing Dog', 'ANIMAL', 'What do you call a dog that loves to dance? A disco retriever!', 1),
       ('The Talkative Tomato', 'FOOD', 'Why was the tomato blushing? Because it saw the salad dressing!', 1),
       ('The Speeding Lettuce', 'FOOD', 'How fast does lettuce run? As fast as it can salad away!', 1),
       ('The Hamburger''s Diary', 'FOOD', 'What did the hamburger name its autobiography? "Between the Buns: A Life Well Stacked!"', 1),
       ('The Calculus Student''s Dilemma', 'SCHOOL', 'Why did the calculus student bring a ladder to class? Because he heard the course was about limits!', 1),
       ('The Science Experiment', 'SCHOOL', 'What did one test tube say to the other? "You complete me!"', 1),
       ('The Missing Homework', 'SCHOOL', 'Why did the student bring a ladder to school? Because he thought it was high school!', 1),
       ('The Angry Computer', 'TECHNOLOGY', 'Why was the computer cold? It left its Windows open!', 1),
       ('The Smartphone''s Vacation', 'TECHNOLOGY', 'What did the smartphone say to its charger? "You charge me up when I''m down!"', 1),
       ('The Social Media Dilemma', 'TECHNOLOGY', 'Why did the social media influencer go to jail? Because they couldn''t find the "unfollow" button!', 1),
       ('The Golfing Frog', 'SPORT', 'What''s a frog''s favorite golf club? The "jumping" wood!', 1),
       ('The Soccer Mystery', 'SPORT', 'Why did the soccer player bring string to the game? Because he wanted to tie the score!', 1),
       ('The Gym Rat', 'SPORT', 'What did the gym rat say to the dumbbell? "You lift me up, bro!"', 1);
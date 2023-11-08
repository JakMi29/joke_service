INSERT INTO _user (email, firstname, lastname, password, role)
VALUES
('userAdam@gmail.com','Adam', 'Nowak', '$2a$10$SNwa/sfgVcqc8NtFJDtLc.HhVgDxMEdP8iBKb4PsiHAEdxj80CRqS', 'USER'),
('userPiotr@gmail.com','Piotr', 'Duda', '$2a$10$SNwa/sfgVcqc8NtFJDtLc.HhVgDxMEdP8iBKb4PsiHAEdxj80CRqS', 'USER'),
('adminKacper@gmail.com','Kacper', 'Kowalczyk', '$2a$10$SNwa/sfgVcqc8NtFJDtLc.HhVgDxMEdP8iBKb4PsiHAEdxj80CRqS', 'ADMIN');

INSERT INTO service_user(email,username)
VALUES
('userAdam@gmail.com', 'userAdam'),
('userPiotr@gmail.com', 'userPiotr'),
('adminKacper@gmail.com', 'adminKacper');

INSERT INTO joke (name, category, contents, service_user_id)
VALUES
('Koala and the Eucalyptus Tree', 'ANIMAL', 'Why did the koala break up with the eucalyptus tree? Because it had too many leaves and couldn''t commit!', 1),
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
('The Gym Rat', 'SPORT', 'What did the gym rat say to the dumbbell? "You lift me up, bro!"', 1),
('The Panda and the Bamboo', 'ANIMAL', 'Why did the panda choose bamboo over everything else? Because it''s all about that plant-based lifestyle!', 2),
('The Squirrel and the Nut Job', 'ANIMAL', 'What do you call a squirrel with a lot of nuts? A wealthy rodent!', 2),
('The Tap-Dancing Penguin', 'ANIMAL', 'Why did the penguin take up tap dancing? Because he wanted to break the ice on the dance floor!', 2),
('The Hungry Potato', 'FOOD', 'Why did the potato go to the doctor? Because it was feeling mashed!', 2),
('The Fruit Basket', 'FOOD', 'What did one fruit say to the other fruit? "We make a great pear!"', 2),
('The Coffee''s Confession', 'FOOD', 'Why did the coffee file a police report? It got mugged!', 2),
('The Math Teacher''s Conundrum', 'SCHOOL', 'Why did the math teacher go broke? Because he spent all his money on pi!', 2),
('The Chemistry Joke', 'SCHOOL', 'Did you hear about the famous microbiologist who visited 30 different schools and spoke about 30 different elements? He''s a man of many talents!', 2),
('The Lost Pencil', 'SCHOOL', 'Why did the pencil go to school? It wanted to improve its "write" education!', 2),
('The Robot''s Apology', 'TECHNOLOGY', 'Why did the robot apologize? Because it had a byte problem!', 2),
('The Smartphone''s Reunion', 'TECHNOLOGY', 'Why did the smartphone go to the class reunion? To reconnect with old friends!', 2),
('The Tech Support Dilemma', 'TECHNOLOGY', 'Why was the computer cold? It left its Windows open!', 2),
('The Golfing Gator', 'SPORT', 'What''s an alligator''s favorite sport? Gator-golf!', 2),
('The Tennis Racket', 'SPORT', 'Why did the tennis player bring a ladder to the match? Because they heard the competition was fierce at the net!', 2),
('The Weightlifting Elephant', 'SPORT', 'What''s the secret to an elephant''s strength? Heavy lifting!', 2),
('The Chatty Parrot', 'ANIMAL', 'Why did the parrot get kicked out of the pet store? Because it wouldn''t stop squawking politics!', 3),
('The Octopus Stand-Up', 'ANIMAL', 'How do octopuses make each other laugh? With tentickles!', 3),
('The Breakdancing Giraffe', 'ANIMAL', 'Why did the giraffe start breakdancing? Because it wanted to stand out in the crowd!', 3),
('The Wise Banana', 'FOOD', 'What did the banana say to the other fruit? "You''re a-peeling!"', 3),
('The Mischievous Tomato', 'FOOD', 'Why did the tomato turn red? Because it saw the salad dressing!', 3),
('The Pizza''s Secret', 'FOOD', 'What''s the pizza''s secret to a successful life? A lot of dough and a good crust!', 3),
('The Absent-Minded Professor', 'SCHOOL', 'Why did the absent-minded professor bring a ladder to the lecture? He wanted to go to new heights in education!', 3),
('The Book Lover', 'SCHOOL', 'Why did the book go to therapy? It had too many issues!', 3),
('The Lost Student', 'SCHOOL', 'Why did the student bring a ladder to school? Because he thought it was high school!', 3),
('The Robot''s Birthday', 'TECHNOLOGY', 'Why did the robot have a birthday party? Because it had too many bytes to celebrate!', 3),
('The Smartphone''s Confession', 'TECHNOLOGY', 'Why did the smartphone go to therapy? It had too many app-blems!', 3),
('The Password Dilemma', 'TECHNOLOGY', 'Why did the password go to a therapist? It had too many issues with its identity!', 3),
('The Golfing Zebra', 'SPORT', 'What do you call a zebra on the golf course? A referee!', 3),
('The Marathon Snail', 'SPORT', 'Why did the snail participate in the marathon? To prove that slow and steady can win the race!', 3),
('The Ping Pong Frog', 'SPORT', 'What do you call a frog that''s good at ping pong? A jump shot!', 3);
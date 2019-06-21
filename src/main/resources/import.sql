INSERT INTO FILM (id, title) VALUES (1, 'The Lion King') 
INSERT INTO FILM (id, title) VALUES (2, 'Coco') 
INSERT INTO FILM (id, title) VALUES (3, 'Zootopia') 
INSERT INTO FILM (id, title) VALUES (4, 'Beauty and the beast') 
INSERT INTO FILM (id, title) VALUES (5, 'Aladin') 
INSERT INTO FILM (id, title) VALUES (6, 'Tangled') 
INSERT INTO FILM (id, title) VALUES (7, 'Big Hero 6') 
INSERT INTO FILM (id, title) VALUES (8, 'Wreck-It Ralph') 
INSERT INTO FILM (id, title) VALUES (9, 'Mulan') 
INSERT INTO FILM (id, title) VALUES (10, 'Moana') 
INSERT INTO FILM (id, title) VALUES (11, 'Snow White and the Seven Dwafs')
INSERT INTO FILM (id, title) VALUES (12, 'The Jungle Book') 
INSERT INTO FILM (id, title) VALUES (13, 'Frozen') 
INSERT INTO FILM (id, title) VALUES (14, 'Pinocchio') 
INSERT INTO FILM (id, title) VALUES (15, 'Bambi') 
INSERT INTO FILM (id, title) VALUES (16, 'Peter Pan') 
INSERT INTO FILM (id, title) VALUES (17, 'Lady and the Tramp')
INSERT INTO FILM (id, title) VALUES (18, 'Tarzan')
INSERT INTO FILM (id, title) VALUES (19, 'One Hundred and One Dalmatians')
INSERT INTO FILM (id, title) VALUES (20, 'Lilo & Stitch')
INSERT INTO FILM (id, title) VALUES (21, 'The Princess and the Frog')
INSERT INTO FILM (id, title) VALUES (22, 'Treasure Planet')
INSERT INTO FILM (id, title) VALUES (23, 'The Aristocats')
INSERT INTO FILM (id, title) VALUES (24, 'Pocahontas')
INSERT INTO FILM (id, title) VALUES (25, 'Cars')
INSERT INTO FILM (id, title) VALUES (26, 'Monsters, Inc.')
INSERT INTO FILM (id, title) VALUES (27, 'Toy Story')
INSERT INTO FILM (id, title) VALUES (28, 'Finding Nemo')

INSERT INTO CHARACTER(id, name) VALUES (1, 'Nemo')
INSERT INTO CHARACTER(id, name) VALUES (2, 'Tarzan')

INSERT INTO USER (id, username, password, email) VALUES (1, 'user1', 'pass1', 'user1@gmail.com')
INSERT INTO USER (id, username, password, email) VALUES (2, 'user2', 'password', 'user2@gmail.com')
INSERT INTO USER (id, username, password, email) VALUES (3, 'user3', 'password2', 'user3@gmail.com')
INSERT INTO USER (id, username, password, email) VALUES (4, 'user4', 'apassword', 'user4@hotmail.com')

INSERT INTO USER_FILM(user_id, film_id) VALUES (1,2)
INSERT INTO USER_FILM(user_id, film_id) VALUES (1,3)
INSERT INTO USER_FILM(user_id, film_id) VALUES (2,3)
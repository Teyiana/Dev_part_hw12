INSERT INTO client (NAME)
VALUES('Alla'), ('Emma'), ('James'), ('Henry'),
    ('Evelyn'), ('William'), ('Sophia'), ('Stepan'),
    ('Ivan'), ('Pavlo'), ('Olivia');



INSERT INTO planet (ID, NAME)
VALUES('MAR1', 'MARS'),('EAR2','EARTH'), ('JUP3','JUPITER'), ('MER4','MERCURY'),
    ('VEN5','VENUS'), ('SAT6','SATURN'), ('URAN7','URANUS'), ('NEP8','NEPTUNE'),
    ('PLU9','PLUTO'), ('SUN10','SUN'), ('MOON11','MOON');

INSERT INTO ticket (CREATED_AT, CLIENT_ID, FROM_PLANET_ID, TO_PLANET_ID)
VALUES ('2022-06-16 16:37:23', '1', 'MAR1', 'MOON11'),
       ('2023-07-13 18:47:29', '11', 'EAR2', 'SUN10'),
       ('2021-05-17 12:15:33', '10', 'JUP3', 'PLU9'),
       ('2024-04-19 11:55:51', '9', 'MER4', 'NEP8'),
       ('2020-01-21 21:03:22', '8', 'VEN5', 'URAN7'),
       ('2023-03-15 08:09:23', '7', 'SAT6', 'SAT6'),
       ('2024-02-23 17:15:34', '6', 'URAN7', 'VEN5'),
       ('2023-07-16 21:30:25', '5', 'NEP8', 'MER4'),
       ('2024-03-25 14:03:26', '4', 'PLU9', 'JUP3'),
       ('2023-08-21 18:09:47', '3', 'SUN10', 'EAR2'),
       ('2019-01-15 15:16:29', '2', 'MOON11', 'MAR1');
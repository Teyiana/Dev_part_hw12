-- CREATE TABLE PUBLIC.CLIENT (
--                                ID BIGINT NOT NULL,
--                                NAME CHARACTER VARYING(255),
--                                CONSTRAINT CONSTRAINT_7 PRIMARY KEY (ID)
-- );
-- CREATE UNIQUE INDEX PRIMARY_KEY_7 ON PUBLIC.CLIENT (ID);

CREATE TABLE client(
                       ID IDENTITY PRIMARY KEY,
                       NAME VARCHAR(200) NOT NULL,
                       CHECK (LENGTH(NAME) > 3)
);


CREATE TABLE planet (
                        ID VARCHAR(50)  PRIMARY KEY,
                        NAME VARCHAR(500) NOT NULL,
                        CHECK (LENGTH(NAME) > 1),
                        CHECK ( ID REGEXP '^[A-Z0-9]+$')

);


CREATE TABLE ticket (
                        ID             IDENTITY PRIMARY KEY,
                        CREATED_AT     TIMESTAMP,
                        CLIENT_ID      BIGINT  NOT NULL,
                        FOREIGN KEY (CLIENT_ID) REFERENCES client(ID),
                        FROM_PLANET_ID VARCHAR  NOT NULL,
                        FOREIGN KEY (FROM_PLANET_ID) REFERENCES planet(ID),
                        TO_PLANET_ID   VARCHAR  NOT NULL,
                        FOREIGN KEY (TO_PLANET_ID) REFERENCES planet(ID)
);

CREATE TABLE PLAYER_DETAIL
(
id INT NOT NULL,
player_name VARCHAR2(50) NOT NULL,
score INT NOT NULL,
score_created_datetime datetime NOT NULL,
primary key(id)
);

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

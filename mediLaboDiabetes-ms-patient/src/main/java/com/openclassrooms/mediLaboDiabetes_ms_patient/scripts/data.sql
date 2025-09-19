CREATE DATABASE db_patient;

USE db_patient;

CREATE table t_patient (
	id int NOT NULL AUTO_INCREMENT,
    firstname varchar(32),
    lastname varchar(32),
    birthdate date,
    gender varchar(32),
    address varchar(32),
    phone varchar(32),
    PRIMARY KEY (id)
);

INSERT INTO t_patient (lastname, firstname, birthdate, gender, address, phone) VALUES ("TestNone", "Test", "1966-12-31", "F", "1 Brookside St", "100-222-3333");
INSERT INTO t_patient (lastname, firstname, birthdate, gender, address, phone) VALUES ("TestBorderline", "Test", "1945-06-24", "M", "2 High St", "200-333-4444");
INSERT INTO t_patient (lastname, firstname, birthdate, gender, address, phone) VALUES ("TestInDanger", "Test", "2004-06-18", "M", "3 Club Road", "300-444-5555");
INSERT INTO t_patient (lastname, firstname, birthdate, gender, address, phone) VALUES ("TestEarlyOnset", "Test", "2002-06-28", "F", "4 Valley Dr", "400-555-6666");

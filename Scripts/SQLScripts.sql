CREATE DATABASE zp;

USE hp;
GO

SET NAMES 'utf8';

DROP TABLE IF EXISTS users;

CREATE TABLE users
(
UserID INT PRIMARY KEY,
UserName VARCHAR(30) NULL,
Pass VARCHAR(30) NULL,
Levl INT NULL
);

INSERT INTO users
VALUES (0,'admin','admin', 1);

INSERT INTO users
VALUES (1,'user','user', 2);

DROP TABLE IF EXISTS staff;

CREATE TABLE staff
(
TabN INT PRIMARY KEY,
F VARCHAR(50) NULL,
I VARCHAR(50) NULL,
O VARCHAR(50) NULL,
Otdel VARCHAR(50) NULL,
Position VARCHAR(50) NULL
);

INSERT INTO staff
VALUES (5148,'Данилюк','Александр','Игоревчи', 'Отдел АСУП','Инженер по АСУП');

DROP TABLE IF EXISTS otdelinfo;

CREATE TABLE otdelinfo
(
ID INT PRIMARY KEY,
Otdel VARCHAR(50) NULL,
Position VARCHAR(50) NULL
);

INSERT INTO otdelinfo
VALUES (12,'Отдел АСУП','Инженео по АСУП');

DROP TABLE IF EXISTS phistory;

CREATE TABLE phistory
(
TabN INT NULL,
Period VARCHAR(20) NULL,
Razmer FLOAT NULL
);


INSERT INTO phistory
VALUES (5148,'август 2020',278);
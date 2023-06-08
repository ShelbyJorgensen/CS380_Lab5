CREATE DATABASE cwulogin;

USE lab5;

CREATE TABLE users (
	id INT NOT NULL,
	username VARCHAR(30) NOT NULL,
	password VARCHAR(30) NOT NULL
);

INSERT INTO users
VALUES(1, "username", "password");

INSERT INTO users
VALUE(2, "user", "pass");
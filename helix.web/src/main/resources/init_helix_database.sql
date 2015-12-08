CREATE DATABASE IF NOT EXISTS helix;
USE helix;
CREATE TABLE IF NOT EXISTS Users(
	idUser Integer NOT NULL AUTO_INCREMENT,
	login Varchar(255),
	hashedPassword Varchar(255),
	type Varchar(255),
	role Varchar(255),
	PRIMARY KEY(idUser)
);
CREATE TABLE IF NOT EXISTS Images(
	idImage Integer NOT NULL AUTO_INCREMENT,
	description Varchar(255),
	PRIMARY KEY(idImage)
);
CREATE TABLE IF NOT EXISTS Containers(
	idContainer Varchar(255),
	idImage Integer,
	name Varchar(255),
	ip  Varchar(255),
	ram Integer,
	cpu Varchar(255),
	status Varchar(255),
	port Integer,
	idUser Integer,
	PRIMARY KEY(idContainer),
	FOREIGN KEY(idUser) REFERENCES Users(idUser),
	FOREIGN KEY(idImage) REFERENCES Images(idImage)
);

insert into Users(login,hashedPassword,role) values("admin","7c2ab87a34395892f10413db233c6420","admin");
insert into Users(login,hashedPassword,type, role) values("customer","7c2ab87a34395892f10413db233c6420","gold","customer");

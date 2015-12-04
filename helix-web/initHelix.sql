CREATE DATABASE IF NOT EXISTS helix;
USE helix;
CREATE TABLE IF NOT EXISTS Users(
	login Varchar(255),
	hashedPassword Varchar(255),
	kindOfMembership Varchar(255),
	type Varchar(255),
	PRIMARY KEY(login)
);
CREATE TABLE IF NOT EXISTS Containers(
	idContainer Varchar(255),
	name Varchar(255),
	ip  Varchar(255),
	ram Integer,
	cpu Integer,
	status Varchar(255),
	login Varchar(255),
	PRIMARY KEY(idContainer),
	FOREIGN KEY(login) REFERENCES Users(login)
);
CREATE TABLE IF NOT EXISTS Services(
	idService Integer AUTO_INCREMENT,
	name Varchar(255),
	status Integer,
	type Varchar(255),
	idContainer Varchar(255),
	PRIMARY KEY(idService),
	FOREIGN KEY(idContainer) REFERENCES Containers(idContainer)
);
insert into Users(login,hashedPassword,type) values("admin","7c2ab87a34395892f10413db233c6420","admin");
insert into Users values("customer","7c2ab87a34395892f10413db233c6420","gold","customer");

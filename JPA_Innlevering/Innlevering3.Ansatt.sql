DROP SCHEMA IF EXISTS Innlevering3 CASCADE;

CREATE SCHEMA Innlevering3;
SET search_path TO Innlevering3; -- Setter search_path til denne mappen (schema'et), public er standard

CREATE TABLE Ansatt
(
	id serial unique,
	brukernavn varchar(4) unique,
	navn varchar,
	etternavn varchar,
	ansettelse date,
	stilling varchar,
	lonn varchar,
	CONSTRAINT Ansatt_pk PRIMARY KEY (id)
);

INSERT INTO
	Ansatt(brukernavn, navn, etternavn, ansettelse, stilling, lonn)
VALUES
	('PV', 'Per', 'Viskeler', '2009-06-12', 'CEO', '1.200.000kr'),
	('AP', 'Atle', 'Patle', '2020-09-25', 'Programør', '850.000kr'),
	('DD', 'Donald', 'Duck', '2016-01-01', 'Vaskehjelp', '680.000kr');
	
	
--Foreign keys er laget manuelt i properties for avdeling!!
CREATE TABLE avdeling(avdelingsid serial unique primary key, navn varchar, int sjef);

INSERT INTO innlevering3.avdeling(navn, avdelingssjef) values ('Administrasjon', 1);
INSERT INTO innlevering3.avdeling(navn, avdelingssjef) values ('IT', 2);
INSERT INTO innlevering3.avdeling(navn, avdelingssjef) values ('Rengjøring', 3);

CREATE TABLE Prosjekt(prosjektid serial primary key, navn varchar, beskrivelse varchar);
CREATE TABLE Prosjektdeltagelse
(
	Ansatt_Id INTEGER,
  	Prosjekt_Id INTEGER,
  	Timer     INTEGER,
  	CONSTRAINT Prosjektdeltagelse_PK PRIMARY KEY (Ansatt_Id, Prosjekt_Id),
  	CONSTRAINT Ansatt_FK FOREIGN KEY (Ansatt_Id) REFERENCES Ansatt(id),
  	CONSTRAINT Prosjekt_FK FOREIGN KEY (Prosjekt_Id) REFERENCES Prosjekt(prosjektid)  
--);
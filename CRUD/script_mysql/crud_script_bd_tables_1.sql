create database crud;
use crud;

create table Persona
(
	id int not null auto_increment,
    dni varchar(10) not null,
    nombre varchar(45),
    edad varchar(45),
    genero varchar(45),
    primary key(id)
);


    
    
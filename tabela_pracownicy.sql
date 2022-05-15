use master;
create database company;

use company;

create table pracownicy(
prac_id int not null identity(1,1) constraint PK_prac primary key,
prac_imie varchar(50) not null,
prac_nazwisko varchar(50) not null,
prac_wiek int not null,
prac_nr_telefonu varchar(15) not null,
prac_email varchar(50)
);


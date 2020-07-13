create database scarper;
use scraper;

create table books(Name varchar(500), 
ImageLink varchar(100),
Rating varchar(10),
Price varchar(10),
InStockOrNot varchar(10), 
Category varchar(100));

create table category(Name varchar(500), 
Link varchar(100));

#Alter table category modify Name varchar(600);
#Alter table books modify Name varchar(600);
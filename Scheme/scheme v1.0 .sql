create database if not exists jrestaurant;
use jrestaurant;
create table if not exists reservation(
	id int auto_increment primary key,
    customerName varchar(15) not null,
    phone char(11) not null,
    data date
);
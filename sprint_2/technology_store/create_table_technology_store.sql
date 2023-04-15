create database technology_store;
use technology_store;
create table role (
id int primary key auto_increment,
name varchar(25)
);

create table account(
id bigint primary key auto_increment,
password varchar(225)
);

create table account_role (
id bigint  primary key auto_increment,
id_role int,
id_account bigint ,
foreign key (id_role) references `role`(id),
foreign key (id_account) references account(id)
);

create	table employee(
id bigint  primary key auto_increment,
name varchar(45),
phone_number varchar(45),
id_card varchar(45) unique,
address varchar (225),
gender boolean,
day_of_birth date,
email varchar(45) unicode,
account_id bigint,
foreign key (account_id) references account(id)
);

create table customer (
id bigint  primary key auto_increment,
name varchar(45),
day_of_birth varchar(45),
phone_number varchar(45),
id_card varchar(45) unicode,
address varchar (225),
gender boolean,
email varchar(45) unique,
account_id bigint,
foreign key (account_id) references account(id)
);

create table product_type(
id int primary key auto_increment, 
name varchar (45)
) ;

create table brands(
id int primary key auto_increment, 
name varchar (45)
) ;


create table product (
id bigint  primary key auto_increment,
image varchar(300),
name varchar(45),
price double,
description varchar(400),
release_date date,
product_quantity int ,
product_type_id int,
brands_id int,
foreign key (brands_id) references brands(id),
foreign key (product_type_id) references product_type(id)
);


create table `order` (
id bigint primary key auto_increment ,
date_purchase date ,
total_pay double,
is_paid boolean,
employee_id bigint ,
customer_id bigint ,
foreign key (employee_id) references employee(id),
foreign key (customer_id) references customer(id)
);

create table `order_detail` (
id int primary key auto_increment ,
ordered_quantity bigint,
product_id bigint ,
order_id bigint ,
foreign key (order_id) references `order`(id),
foreign key (product_id) references product(id)
);

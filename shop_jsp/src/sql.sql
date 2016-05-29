create database shop_jsp;

use shop_jsp;

create table user 
(
id int not null primary key auto_increment,
username varchar(40) not null,
password char(40) not null,
email varchar(40) not null,
phone varchar(20) not null,
address varchar(255) not null,
createdate timestamp not null default CURRENT_TIMESTAMP,
lastlogin timestamp not null default CURRENT_TIMESTAMP
)charset=utf8;

create table category
(
id int primary key auto_increment not null,
pid int not null, 
name varchar(255) not null, 
descr varchar(255) not null,
cno int not null, 
grade int not null
)charset=utf8;

create table product
(
id int primary key auto_increment not null,
name varchar(255) not null,
description varchar(255) not null,
price double not null,
categoryid int references catetory(id),
stock int not null default 0,
sales int not null default 0,
createtime timestamp not null default CURRENT_TIMESTAMP
)charset=utf8;

create table salesorder
(
id int primary key auto_increment not null,
userid int not null,
addrress varchar(255) not null,
phone varchar(20) not null,
ordertime timestamp not null default CURRENT_TIMESTAMP,
status tinyint(1) not null default 0
)charset=utf8;

create table salesitem 
(
id int primary key auto_increment not null,
productid int not null, 
uniprice double not null, 
productcount int not null,
orderid int not null
)charset=utf8;
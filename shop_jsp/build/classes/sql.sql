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
description varchar(255) not null,
grade int not null
)charset=utf8;

create table product
(
id int primary key auto_increment not null,
name varchar(255) not null,
description varchar(255) not null,
price double not null,
categoryid int references catetory(id),
sales int not null default 0,
createtime timestamp not null default CURRENT_TIMESTAMP,
is_offshelve tinyint(1) not null default 0
)charset=utf8;

create table salesorder
(
id int primary key auto_increment not null,
userid int not null,
addrress varchar(255) not null,
phone varchar(20) not null,
ordertime timestamp not null default CURRENT_TIMESTAMP,
is_payed tinyint(1) not null default 0,
is_shipped tinyint(1) not null default 0
)charset=utf8;

create table salesitem 
(
id int primary key auto_increment not null,
productid int not null, 
uniprice double not null, 
productcount int not null,
orderid int not null
)charset=utf8;

INSERT INTO user (username,password,email,phone,address) VALUES ("username","5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8","email@email.com","00000000000","adress")

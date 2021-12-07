drop database if exists `final-project`;
create database `final-project`;

use `final-project`;

drop table if exists `product`;
create table `product`(
	product_id int not null auto_increment,
    product_name varchar(45),
    product_img_url varchar(45),
    product_quantity int,
    product_price double,
    primary key	(product_id) );
    
Alter table `product` AUTO_INCREMENT=1000;

Insert into product values('1000', 'Apple Watch', './imgs/applewatch.jpg', '5', '125.00');
Insert into product values('1001', 'Bose Headphones', './imgs/boseheadphones.jpg', '15', '150.00');
Insert into product values('1002', 'LG Curved Monitor', './imgs/curved-monitor.jpg', '6', '525.00');
Insert into product values('1003', 'Dell XPS Laptop', './imgs/dellxps.jpg', '21', '1299.00');
Insert into product values('1004', 'Macbook Pro Laptop', './imgs/macpro.jpg', '25', '1499.00');
Insert into product values('1005', 'Next Gen-Keyboard', './imgs/nexgenkeyboard.jpg', '8', '85.00');
Insert into product values('1006', 'Samsung Watch', './imgs/samsungwatch.jpg', '12', '115.00');

drop table if exists `credentials`;
create table `credentials`(
 credentials_Id int not null auto_increment,
 username varchar(30),
 pass varchar(50),
 primary key (credentials_id)
);

Alter table `credentials` AUTO_INCREMENT=10;

insert into credentials values('10','jdoe', 'testpass');

drop table if exists `user`;
create table `user`(
 user_id int not null auto_increment,
 first_name varchar(35),
 last_name varchar(35),
 email varchar(50),
 credentials_id int not null,
 primary key (user_id),
 constraint FK_credentialsId_idx foreign key (credentials_id) references credentials (credentials_id)
);

insert into user values('1','John', 'Doe', 'jdoe@gmail.com', '10');
show databases;

drop database product_cart_coupon_account_basic_db;

create database CPA_app_db;

show databases;

use CPA_app_db;

CREATE TABLE user (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20),
    password VARCHAR(20)
);

create table supplier (
	supplierId int auto_increment primary key,
    username varchar(20),
    password varchar(20)
);

create table productTypes (
	productTypeId int auto_increment primary key,
    productType varchar(20)
);

create table product (
	productId int auto_increment primary key,
    productTypeId int,
    supplierId int,
	productName varchar(30),
    productPrice decimal(8,4),
    foreign key (productTypeId) references productTypes(productTypeId),
	foreign key (supplierId) references supplier(supplierId)
);

create table discountTypes (
	discountTypeId int auto_increment primary key,
    discountType varchar(20)
);

create table coupon (
	couponId int auto_increment primary key,
    discountTypeId int,
    productId int,
    discountValue decimal(8,4),
    foreign key (discountTypeId) references discountTypes(discountTypeId),
    foreign key (productId) references product(productId)
);

create table productMarketplace (
	productMarketplaceId int auto_increment primary key,
    productId int,
    foreign key (productId) references product(productId)
);

show tables;

select * from discounttypes;
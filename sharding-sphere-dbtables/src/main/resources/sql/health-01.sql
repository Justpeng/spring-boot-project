
# 分库
create database shardingsphere_dbtables0;
create database shardingsphere_dbtables1;
create database shardingsphere_dbtables2;
-- 0
use shardingsphere_dbtables0;
create table health_user0(
    id bigint unsigned primary key comment '主键id',
    user_name varchar(32) not null comment '姓名'
)ENGINE=InnoDB;

create table health_user1(
    id bigint unsigned primary key comment '主键id',
    user_name varchar(32) not null comment '姓名'
)ENGINE=InnoDB;

create table health_user2(
    id bigint unsigned primary key comment '主键id',
    user_name varchar(32) not null comment '姓名'
)ENGINE=InnoDB;

--1
use shardingsphere_dbtables1;
create table health_user0(
    id bigint unsigned primary key comment '主键id',
    user_name varchar(32) not null comment '姓名'
)ENGINE=InnoDB;

create table health_user1(
    id bigint unsigned primary key comment '主键id',
    user_name varchar(32) not null comment '姓名'
)ENGINE=InnoDB;

create table health_user2(
    id bigint unsigned primary key comment '主键id',
    user_name varchar(32) not null comment '姓名'
)ENGINE=InnoDB;


--2
use shardingsphere_dbtables2;
create table health_user0(
    id bigint unsigned primary key comment '主键id',
    user_name varchar(32) not null comment '姓名'
)ENGINE=InnoDB;

create table health_user1(
    id bigint unsigned primary key comment '主键id',
    user_name varchar(32) not null comment '姓名'
)ENGINE=InnoDB;

create table health_user2(
    id bigint unsigned primary key comment '主键id',
    user_name varchar(32) not null comment '姓名'
)ENGINE=InnoDB;



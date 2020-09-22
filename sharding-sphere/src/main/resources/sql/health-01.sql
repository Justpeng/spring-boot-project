create table health_user(
    id bigint unsigned primary key comment '主键id',
    user_name varchar(32) not null comment '姓名'
)ENGINE=InnoDB;


create table health_record(
    id bigint unsigned primary key comment '主键id',
    user_id bigint  not null comment '用户id',
    record_id bigint not null comment '记录id',
    level_id bigint not null comment '级别id',
    remark varchar(512) comment '内容'
)ENGINE=InnoDB;

create table health_level(
    id bigint unsigned primary key comment '主键id',
    level_name varchar(32) comment '级别名称'
)ENGINE=InnoDB;

create table health_task(
    id bigint unsigned primary key comment '主键id',
    record_id varchar(32) comment '任务id',
    user_id bigint not null comment '用户id',
    task_name varchar(32) not null comment '任务名称'
)ENGINE=InnoDB;


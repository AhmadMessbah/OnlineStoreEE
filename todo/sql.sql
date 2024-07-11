create table user_tbl
(
    user_name varchar(15) not null primary key,
    user_pass varchar(15) not null
);


create table roles
(
    role_name varchar(15) not null primary key
);

create table user_roles
(
    user_name varchar(15) not null,
    role_name varchar(15) not null,
    primary key( user_name, role_name )
);

create table LOGS_TBL
(
    ID         NUMBER(19) not null primary key,
    ACTION     VARCHAR2(255 char),
    CLASS_NAME VARCHAR2(255 char),
    DATA       VARCHAR2(255 char),
    LOG_TYPE   VARCHAR2(255 char),
    TIME_STAMP TIMESTAMP(6)
);

create sequence logs_seq start with 1 increment by 1;
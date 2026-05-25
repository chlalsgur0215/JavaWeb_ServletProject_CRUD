drop database if exists db_no;
create database db_no;
use db_no;
drop table if exists mb_no;
drop table if exists blog_no;

create table mb_no(
    id int(11) NOT NULL AUTO_INCREMENT,
    email varchar(30) not null unique,
    password varchar(20) not null,
    phone varchar(30),
    address varchar(50),
    role varchar(10),
    reg_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

select * from mb_no;

insert into mb_no(email, password, phone, address, role)
values('id1@induk.ac.kr', 'cometrue', '010-1111-0001', 'seoul', 'developer');
insert into mb_no(email, password, phone, address, role)
values('id2@induk.ac.kr', 'cometrue', '010-1111-0002', 'seoul', 'developer');
insert into mb_no(email, password, phone, address, role)
values('id3@induk.ac.kr', 'cometrue', '010-1111-0003', 'seoul', 'developer');
insert into mb_no(email, password, phone, address, role)
values('id4@induk.ac.kr', 'cometrue', '010-1111-0004', 'seoul', 'developer');
insert into mb_no(email, password, phone, address, role)
values('id5@induk.ac.kr', 'cometrue', '010-1111-0005', 'seoul', 'developer');
insert into mb_no(email, password, phone, address, role)
values('id6@induk.ac.kr', 'cometrue', '010-1111-0006', 'seoul', 'developer');
insert into mb_no(email, password, phone, address, role)
values('id7@induk.ac.kr', 'cometrue', '010-1111-0007', 'seoul', 'developer');
insert into mb_no(email, password, phone, address, role)
values('id8@induk.ac.kr', 'cometrue', '010-1111-0008', 'seoul', 'developer');
insert into mb_no(email, password, phone, address, role)
values('id9@induk.ac.kr', 'cometrue', '010-1111-0000', 'seoul', 'developer');
insert into mb_no(email, password, phone, address, role)
values('id10@induk.ac.kr', 'cometrue', '010-1111-0010', 'seoul', 'developer');
insert into mb_no(email, password, phone, address, role)
values('id11@induk.ac.kr', 'cometrue', '010-1111-0011', 'seoul', 'developer');


select * from mb_no order by id desc limit 1, 3;
select * from mb_no order by id desc limit 3, 3;

update mb_no set email='id1@induk.ac.kr', phone='010-2222-2222';

create table blog_no (
    id      int(11)      NOT NULL AUTO_INCREMENT,
    title   varchar(100) not null,
    content varchar(200),
    email   varchar(30)  not null,
    reg_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




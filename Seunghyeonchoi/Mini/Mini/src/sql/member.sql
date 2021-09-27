create table member(
    member_no int not null auto_increment,
    userId varchar(60) not null,
    password varchar(60) not null,
    nickname varchar(60) not null,
    reg_date timestamp not null default now(),
    primary key(member_no)
    )
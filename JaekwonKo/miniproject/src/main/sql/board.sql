create table board(
   board_no int not null auto_increment,
   content text null,
   writer varchar(50) not null,
   rating int not null default 0,
   area varchar(200) not null,
   store varchar(200) not null,
   regDate timestamp not null default now(),
   primary key(board_no)
);
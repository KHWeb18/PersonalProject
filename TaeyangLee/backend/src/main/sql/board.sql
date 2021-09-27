create table board(
   board_no int not null auto_increment,
   title varchar(50) not null,
   content text null,
   writer varchar(50) not null,
   funding int not null,
   nowfunding int,
   regDate timestamp not null default now(),
   primary key(board_no)
);

insert into board (title, content, writer, funding, nowfunding) values
 ('어린아이들을 도와주세요','도와줘','기업명','10000000','0');

 create table gongzi(
    gongzi_no int not null auto_increment,
    title varchar(50) not null,
    content text null,
    writer varchar(50) not null,
    regDate timestamp not null default now(),
    primary key(gongzi_no)
 );

 insert into gongzi (title, content, writer) values
  ('공지사항 입니다','지키세요','관리자');
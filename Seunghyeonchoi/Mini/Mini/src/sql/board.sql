create table board(
    board_no int not null auto_increment,
    title varchar(200) not null,
    content text null,
    writer varchar(50) not null,
    nickname varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(board_no)
);

create table freecomment(
    comment_no int not null auto_increment,
    board_no int not null,
    content text null,
    writer varchar(50) not null,
    nickname varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(comment_no)
);

insert into noticecomment(board_no, content, writer, nickname)
value (5, '5번 게시물 댓글입니다', 'admin01', '호랑이');


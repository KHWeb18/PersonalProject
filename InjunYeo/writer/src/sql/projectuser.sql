create table projectuser(
     user_no int not null auto_increment,
     id varchar(200) not null,
     pw varchar(250) not null,
     name varchar(50) not null,
     primary key(user_no)
);
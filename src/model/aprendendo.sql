CREATE TABLE usuarios (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
login VARCHAR(30) NOT NULL,
senha VARCHAR(30) NOT NULL,
email VARCHAR(50),
reg_date TIMESTAMP default now(),
admin BOOLEAN
) 

insert into usuarios values (1,'rodrigo','123','rt3@gm.c',null,1);


create table users (
  id int unsigned auto_increment not null,
  first_name varchar(32) not null,
  last_name varchar(32) not null,
  date_created timestamp default now(),
  is_admin boolean,
  num_points int,
  primary key (id)
);


create table pedidos (
  id int unsigned auto_increment not null,
  data_criacao timestamp default now(),
  atendido timestamp default null,
  cliente varchar(32) not null,
  comida varchar(32) not null,
  observacao varchar(32) not null,
  prioritario boolean default false,
  primary key (id)
);
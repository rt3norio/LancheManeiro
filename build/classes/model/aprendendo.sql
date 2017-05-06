CREATE TABLE usuarios (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
login VARCHAR(30) NOT NULL,
senha VARCHAR(30) NOT NULL,
email VARCHAR(50),
reg_date TIMESTAMP,
admin BOOLEAN
) 

insert into usuarios values (1,'rodrigo','123','rt3@gm.c',null,1);

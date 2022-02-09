create table chamadas(
id_chamada bigInt not null auto_increment,
nome_aluno varchar(100) not null,
data date not null,
presenca Boolean not null,
primary key (id_chamada)
);


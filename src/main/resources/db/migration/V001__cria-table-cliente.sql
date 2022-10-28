create table cliente(
	cpf bigint not null,
	nome varchar(60) not null,
	nascimento date not null,
	primary key(cpf)
);
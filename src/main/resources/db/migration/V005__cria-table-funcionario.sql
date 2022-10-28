create table funcionario(
	cpf bigint not null,
    nome varchar(128) not null,
    restaurante_id bigint not null,
    cargo_id varchar(5) not null,
    admissao date not null,
    ativo boolean not null,
    primary key (cpf),
    foreign key (restaurante_id) references restaurante(id),
    foreign key (cargo_id) references cargo(id)
);
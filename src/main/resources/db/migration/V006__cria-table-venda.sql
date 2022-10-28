create table venda(
	id BIGSERIAL,
    cliente_cpf bigint,
    funcionario_cpf bigint,
    valor float8 not null,
    descricao varchar(255),
    primary key (id),
    foreign key (funcionario_cpf) references funcionario(cpf) on delete set null,
    foreign key (cliente_cpf) references cliente(cpf) on delete set null
);
create table convenio(
	id BIGSERIAL,
    renovacao date not null,
    restaurante_id bigint not null,
    cliente_cpf bigint,
    valor float8 not null,
    primary key (id),
    foreign key (restaurante_id) references restaurante(id),
    foreign key (cliente_cpf) references cliente(cpf) on delete set null
);
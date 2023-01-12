create table alimento(
	lote char(20) not null,
	nome char(20) not null,
	validade date not null,
	origem varchar(50) not null,
    restaurante_id bigint not null,
	primary key (lote),
    foreign key (restaurante_id) references restaurante(id)
);
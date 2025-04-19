create table Lancamento(
    id bigint primary key auto_increment,
    descricao varchar(100),
    data_vencimento date,
    data_pagamento date,
    valor int,
    observacao varchar(100),
    tipo enum('RECEITA','DESPESA'),
    codigo_pessoa bigint,
    codigo_categoria bigint,
    foreign key (codigo_pessoa) references pessoa(id),
    foreign key (codigo_categoria) references categoria(id)
);
create table pessoa(
    id bigint primary key auto_increment,
    nome varchar(100),
    ativo boolean,
    logradouro varchar(100),
    cidade varchar(100),
    numero varchar(100),
    cep varchar(10),
    estado varchar(100),
    bairro varchar(100),
    complemento varchar(100)
)
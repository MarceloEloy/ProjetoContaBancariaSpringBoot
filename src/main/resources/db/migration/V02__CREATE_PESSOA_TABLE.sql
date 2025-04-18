create table Pessoa(
    id bigint primary key auto_increment,
    nome varchar(30),
    ativo boolean,
    logradouro varchar(50),
    numero varchar(10),
    cep varchar(10),
    estado varchar(30),
    bairro varchar(30),
    complemento varchar(30)
)
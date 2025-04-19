package com.Generico.ProjetoBanco.DTO;


import com.Generico.ProjetoBanco.Model.Usuarios.Endereco;
import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import jakarta.persistence.Embedded;

public record DTO_Pessoa(Long codigo,
                         String nome,
                         Boolean ativo,
                         DTO_Endereco endereco) {
}
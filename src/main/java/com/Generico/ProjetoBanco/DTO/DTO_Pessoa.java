package com.Generico.ProjetoBanco.DTO;


import com.Generico.ProjetoBanco.Model.Usuarios.Endereco;
import jakarta.persistence.Embedded;

public record DTO_Pessoa(
                         String nome,
                         Boolean ativo,
                         DTO_Endereco endereco) {
}

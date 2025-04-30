package com.Generico.ProjetoBanco.DTO;


import com.Generico.ProjetoBanco.Model.Usuarios.Endereco;
import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTO_Pessoa(Long codigo,
                         @NotNull
                         @NotBlank
                         String nome,
                         @NotNull
                         @NotBlank
                         Boolean ativo,
                         @NotNull
                         DTO_Endereco endereco) {
    public DTO_Pessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getAtivo(), new DTO_Endereco(pessoa.getEndereco()));
    }
}
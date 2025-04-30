package com.Generico.ProjetoBanco.DTO;

import com.Generico.ProjetoBanco.Model.Usuarios.Endereco;
import jakarta.validation.constraints.NotBlank;

public record DTO_Endereco(String logradouro,
        @NotBlank
                String numero,
        @NotBlank
                String bairro,
        @NotBlank
                String cep,
        @NotBlank
                String estado,
        @NotBlank
                String cidade,
        String complemento) {
    public DTO_Endereco(Endereco endereco){
        this(endereco.getLogradouro(), endereco.getNumero(), endereco.getCep(), endereco.getCep(), endereco.getEstado(), endereco.getCidade(), endereco.getComplemento());
    }
}


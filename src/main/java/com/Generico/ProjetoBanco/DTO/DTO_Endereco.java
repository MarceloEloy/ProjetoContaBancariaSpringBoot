package com.Generico.ProjetoBanco.DTO;

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
}

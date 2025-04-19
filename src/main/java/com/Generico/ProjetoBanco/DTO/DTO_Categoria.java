package com.Generico.ProjetoBanco.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTO_Categoria(
        Long codigo,
        @NotBlank
        @NotNull
        String nome
) {
}

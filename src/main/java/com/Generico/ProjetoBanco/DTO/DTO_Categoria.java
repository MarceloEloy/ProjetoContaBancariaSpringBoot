package com.Generico.ProjetoBanco.DTO;

import com.Generico.ProjetoBanco.Model.ContaBancaria.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTO_Categoria(
        Long codigo,
        @NotBlank
        @NotNull
        String nome
) {
        public DTO_Categoria(Categoria categoria){
                this(categoria.getId(), categoria.getNome());
        }
}

package com.Generico.ProjetoBanco.DTO;

import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import com.Generico.ProjetoBanco.Model.ContaBancaria.TipoLancamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record DTO_Lancamento(
        @NotNull
        @NotBlank
        String descricao,
        @NotNull
        Date data_vencimento,
        Date data_pagamento,
        @NotNull
        int valor,
        String observacao,
        @NotNull
        TipoLancamento tipo,
        @NotNull
        DTO_Pessoa pessoa,
        @NotNull
        DTO_Categoria categoria
) {
}

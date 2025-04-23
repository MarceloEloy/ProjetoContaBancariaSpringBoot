package com.Generico.ProjetoBanco.DTO;

import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import com.Generico.ProjetoBanco.Model.ContaBancaria.TipoLancamento;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record DTO_Lancamento(
        String descricao,
        @NotNull
        Date data_vencimento,
        Date data_pagamento,
        @NotNull
        int valor,
        String observacao,
        @NotNull
        TipoLancamento tipo,
        DTO_Pessoa pessoa,
        DTO_Categoria categoria
) {
}

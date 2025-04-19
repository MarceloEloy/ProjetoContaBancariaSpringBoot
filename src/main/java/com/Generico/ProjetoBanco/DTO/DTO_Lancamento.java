package com.Generico.ProjetoBanco.DTO;

import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import com.Generico.ProjetoBanco.Model.ContaBancaria.TipoLancamento;

import java.sql.Date;

public record DTO_Lancamento(
        String descricao,
        Date data_vencimento,
        Date data_pagamento,
        int valor,
        String observacao,
        TipoLancamento tipo,
        DTO_Pessoa pessoa,
        DTO_Categoria categoria
) {
}

package com.Generico.ProjetoBanco.DTO;

import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import com.Generico.ProjetoBanco.Model.ContaBancaria.TipoLancamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record DTO_Lancamento(
        Long id,
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
        public DTO_Lancamento(Lancamento lancamento){
                this(lancamento.getId(), lancamento.getDescricao(), lancamento.getData_vencimento(), lancamento.getData_pagamento(), lancamento.getValor(), lancamento.getObservacao(), lancamento.getTipo(), new DTO_Pessoa(lancamento.getLancamentoPessoa()), new DTO_Categoria(lancamento.getLancamentoCategoria()));
        }
}

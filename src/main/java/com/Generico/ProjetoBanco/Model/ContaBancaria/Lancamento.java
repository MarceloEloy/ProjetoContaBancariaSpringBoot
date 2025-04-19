package com.Generico.ProjetoBanco.Model.ContaBancaria;

import com.Generico.ProjetoBanco.DTO.DTO_Lancamento;
import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "Lancamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lancamento {
    public Lancamento(DTO_Lancamento lancamento, Pessoa pessoa, Categoria categoria){
        descricao = lancamento.descricao();
        data_pagamento = lancamento.data_pagamento();
        data_vencimento = lancamento.data_vencimento();
        valor = lancamento.valor();
        observacao = lancamento.observacao();
        tipo = lancamento.tipo();
        lancamentoCategoria = categoria;
        lancamentoPessoa = pessoa;
    };
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    private String descricao;
    @Column
    private Date data_vencimento;
    @Column
    private Date data_pagamento;
    @Column
    private int valor;
    @Column
    private String observacao;
    @Column
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;
    @ManyToOne
    @JoinColumn(name = "codigo_categoria")
    private Pessoa lancamentoPessoa;
    @ManyToOne
    @JoinColumn(name = "codigo_pessoa")
    private Categoria lancamentoCategoria;
}

package com.Generico.ProjetoBanco.Model.Usuarios;

import com.Generico.ProjetoBanco.DTO.DTO_Pessoa;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {
    public Pessoa(DTO_Pessoa pessoa, Long codigo){

    };
    public Pessoa(DTO_Pessoa pessoa){
        nome = pessoa.nome();
        ativo = pessoa.ativo();
        endereco = new Endereco(pessoa.endereco());
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull
    private Boolean ativo;
    @Column
    @NotNull
    private String nome;
    @Embedded
    private Endereco endereco;
    @OneToMany(mappedBy = "lancamentoPessoa")
    private Set<Lancamento> pessoaLancamentos = new HashSet<>();
}

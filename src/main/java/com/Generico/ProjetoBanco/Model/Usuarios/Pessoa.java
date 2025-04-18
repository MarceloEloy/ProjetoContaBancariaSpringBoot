package com.Generico.ProjetoBanco.Model.Usuarios;

import com.Generico.ProjetoBanco.DTO.DTO_Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {
    public Pessoa(DTO_Pessoa pessoa){
        nome = pessoa.nome();
        ativo = pessoa.ativo();
        endereco = new Endereco(pessoa.endereco());
    };
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    Boolean ativo;
    @Column
    String nome;
    @Embedded
    Endereco endereco;
}

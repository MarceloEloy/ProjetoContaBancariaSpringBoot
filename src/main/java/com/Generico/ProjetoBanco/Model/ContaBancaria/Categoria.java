package com.Generico.ProjetoBanco.Model.ContaBancaria;

import com.Generico.ProjetoBanco.DTO.DTO_Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "categoria")
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    public Categoria(DTO_Categoria categoria){
        nome = categoria.nome();
    }
    public Categoria(DTO_Categoria categoria, Long codigo){};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "lancamentoCategoria")
    private Set<Lancamento> categoriaLancamentos = new HashSet<>();
}

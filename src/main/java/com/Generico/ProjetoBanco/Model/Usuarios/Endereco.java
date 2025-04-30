package com.Generico.ProjetoBanco.Model.Usuarios;

import com.Generico.ProjetoBanco.DTO.DTO_Endereco;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco {
    public Endereco(DTO_Endereco endereco){
        logradouro = endereco.logradouro();
        numero = endereco.numero();
        bairro = endereco.bairro();
        cep = endereco.cep();
        cidade = endereco.cidade();
        estado = endereco.estado();
        complemento = endereco.complemento();
    }


    String logradouro;
    @NotBlank
    @NotNull
    private String numero;
    @NotBlank
    @NotNull
    private String bairro;
    @NotBlank
    @NotNull
    private String cep;
    @NotBlank
    @NotNull
    private String cidade;
    @NotBlank
    @NotNull
    private String estado;
    private String complemento;
}

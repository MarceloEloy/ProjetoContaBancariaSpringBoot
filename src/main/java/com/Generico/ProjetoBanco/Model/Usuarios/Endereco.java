package com.Generico.ProjetoBanco.Model.Usuarios;

import com.Generico.ProjetoBanco.DTO.DTO_Endereco;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    public Endereco(DTO_Endereco endereco){
        logradouro = endereco.logradouro();
        numero = endereco.numero();
        bairro = endereco.bairro();
        cep = endereco.cep();
        estado = endereco.estado();
        complemento = endereco.complemento();
    }

    String logradouro;
    @NotBlank
    String numero;
    @NotBlank
    String bairro;
    @NotBlank
    String cep;
    @NotBlank
    String estado;
    String complemento;
}

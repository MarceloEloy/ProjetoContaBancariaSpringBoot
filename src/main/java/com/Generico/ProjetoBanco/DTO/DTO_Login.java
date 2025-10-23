package com.Generico.ProjetoBanco.DTO;

import com.Generico.ProjetoBanco.Model.Usuarios.Seguranca.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public record DTO_Login(
                        @Null
                        Long id,
                        @Email
                        String email,
                        @NotBlank
                        @NotNull
                        String senha,
                        @NotNull
                        Roles roles) {

}

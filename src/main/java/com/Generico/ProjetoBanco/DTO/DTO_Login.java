package com.Generico.ProjetoBanco.DTO;

import com.Generico.ProjetoBanco.Model.Usuarios.Seguranca.Roles;
import jakarta.validation.constraints.Email;

public record DTO_Login(Long id,
                        @Email
                        String email,
                        String senha,
                        Roles roles) {

}

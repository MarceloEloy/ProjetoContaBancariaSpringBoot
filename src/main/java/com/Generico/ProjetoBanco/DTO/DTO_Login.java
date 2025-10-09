package com.Generico.ProjetoBanco.DTO;

import com.Generico.ProjetoBanco.Model.Usuarios.Seguranca.Roles;

public record DTO_Login(Long id,
                        String login,
                        String senha,
                        Roles roles) {

}

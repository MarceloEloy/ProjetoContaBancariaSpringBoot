package com.Generico.ProjetoBanco.Model.Usuarios;

import com.Generico.ProjetoBanco.DTO.DTO_Login;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "Logins")
public class Login_Pessoa implements UserDetails {
    public Login_Pessoa(DTO_Login login){
        if (login.id() != null){
            this.id = login.id();
        }
        this.login = login.login();
        this.senha = login.senha();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String login;

    @Column
    String senha;

    public Login_Pessoa(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }
}

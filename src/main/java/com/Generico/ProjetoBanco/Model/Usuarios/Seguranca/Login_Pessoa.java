package com.Generico.ProjetoBanco.Model.Usuarios.Seguranca;

import com.Generico.ProjetoBanco.DTO.DTO_Login;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
        this.email = login.email();
        this.senha = login.senha();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String email;

    @Column
    String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    Roles roles;

    public Login_Pessoa(String email, String senha, Roles roles) {
        this.email = email;
        this.senha = senha;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles.equals(Roles.ADMINISTRADOR)){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_BASIC"));
        }
        if (roles.equals(Roles.BASICO)) {
            return List.of(new SimpleGrantedAuthority("ROLE_BASIC"));
        }
        System.out.println(this.roles.name());
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}

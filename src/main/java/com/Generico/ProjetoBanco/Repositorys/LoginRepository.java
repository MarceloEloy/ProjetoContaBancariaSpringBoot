package com.Generico.ProjetoBanco.Repositorys;

import com.Generico.ProjetoBanco.Model.Usuarios.Login_Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login_Pessoa, Long>, PagingAndSortingRepository<Login_Pessoa, Long> {

    Login_Pessoa findByLogin(String username);

}

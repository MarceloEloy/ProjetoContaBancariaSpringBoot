package com.Generico.ProjetoBanco.Model.Repositorys;

import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}

package com.Generico.ProjetoBanco.Repositorys;

import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PagingAndSortingRepository<Pessoa, Long> {
    Page<Pessoa> findAll(Pageable pageable);
}

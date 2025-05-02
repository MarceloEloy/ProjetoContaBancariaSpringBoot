package com.Generico.ProjetoBanco.Repositorys;

import com.Generico.ProjetoBanco.Model.ContaBancaria.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>, PagingAndSortingRepository<Categoria, Long> {
    Page<Categoria> findAll(Pageable pageable);
}

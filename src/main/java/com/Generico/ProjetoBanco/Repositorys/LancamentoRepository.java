package com.Generico.ProjetoBanco.Repositorys;

import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, PagingAndSortingRepository<Lancamento, Long> {
    Page<Lancamento> findAll(Pageable pageable);
}

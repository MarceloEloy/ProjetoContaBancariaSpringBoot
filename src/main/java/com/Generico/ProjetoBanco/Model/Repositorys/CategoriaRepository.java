package com.Generico.ProjetoBanco.Model.Repositorys;

import com.Generico.ProjetoBanco.Model.ContaBancaria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
}

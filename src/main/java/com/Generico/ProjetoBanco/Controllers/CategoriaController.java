package com.Generico.ProjetoBanco.Controllers;

import com.Generico.ProjetoBanco.DTO.DTO_Categoria;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Categoria;
import com.Generico.ProjetoBanco.Model.Repositorys.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {
    @Autowired
    CategoriaRepository categoriaRepository;
    @PostMapping
    public void cadastrarCategoria(@RequestBody DTO_Categoria categoriaDTO){
        this.categoriaRepository.save(new Categoria(categoriaDTO));
    }
}

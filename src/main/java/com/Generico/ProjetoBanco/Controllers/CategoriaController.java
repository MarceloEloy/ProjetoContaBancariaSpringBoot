package com.Generico.ProjetoBanco.Controllers;

import com.Generico.ProjetoBanco.DTO.DTO_Categoria;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Categoria;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import com.Generico.ProjetoBanco.Repositorys.CategoriaRepository;
import com.Generico.ProjetoBanco.Services.SERVICE_CATEGORIA;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {
    @Autowired
    SERVICE_CATEGORIA serviceCategoria;
    @PostMapping
    public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody @Valid DTO_Categoria categoriaDTO) throws URISyntaxException {
        return serviceCategoria.adicionar(categoriaDTO);
    }
    @GetMapping("{id}")
    public ResponseEntity<Categoria> acharUnico(@PathVariable Long id){
        return  serviceCategoria.acharUnico(id);
    }
    @GetMapping
    public ResponseEntity<Page<Categoria>> listarCategoria(@RequestParam int page, @RequestParam int size){
        return serviceCategoria.listar(page, size);
    }
    @PutMapping
    public ResponseEntity<Categoria> alterarCategoria(@RequestParam Long id, @RequestBody DTO_Categoria dtoCategoria){
        return serviceCategoria.alterar(id, dtoCategoria);
    }
    @DeleteMapping
    public ResponseEntity<Categoria> deletarCategoria(@RequestParam Long id){
        return serviceCategoria.deletar(id);
    }
}

package com.Generico.ProjetoBanco.Services;

import com.Generico.ProjetoBanco.DTO.DTO_Categoria;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Categoria;
import com.Generico.ProjetoBanco.Repositorys.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class SERVICE_CATEGORIA {
    @Autowired
    private CategoriaRepository categoriaRepository;
    public ResponseEntity<Page<Categoria>> listar(int page, int size){
        return ResponseEntity.ok(categoriaRepository.findAll(PageRequest.of(page -1, size)));
    }
    public ResponseEntity<Categoria> acharUnico(Long id){
        return ResponseEntity.ok().body(categoriaRepository.findById(id).get());
    }
    public ResponseEntity<Categoria> deletar(Long id){
        categoriaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    public ResponseEntity<Categoria> alterar(Long id, DTO_Categoria dtoCategoria){
        Categoria c = categoriaRepository.findById(id).get();
        if (c.getNome() != dtoCategoria.nome()){
            c.setNome(dtoCategoria.nome());
        }
        return ResponseEntity.ok(categoriaRepository.save(c));
    }
    public ResponseEntity<Categoria> adicionar(DTO_Categoria dtoCategoria) throws URISyntaxException {
        return ResponseEntity.created(new URI("/Categoria")).body(categoriaRepository.save(new Categoria(dtoCategoria)));
    }
}

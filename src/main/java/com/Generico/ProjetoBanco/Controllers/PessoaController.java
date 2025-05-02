package com.Generico.ProjetoBanco.Controllers;

import com.Generico.ProjetoBanco.DTO.DTO_Pessoa;
import com.Generico.ProjetoBanco.Repositorys.PessoaRepository;
import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import com.Generico.ProjetoBanco.Services.SERVICE_Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Pessoa")
public class PessoaController {
    @Autowired
    public SERVICE_Pessoa servicePessoa;
    @Autowired
    private PessoaRepository pessoaRepository;
    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody DTO_Pessoa pessoaDTO){
        return servicePessoa.adicionar(pessoaDTO);
    }
    @GetMapping
    public ResponseEntity<Page<Pessoa>> listar(@RequestParam int page, @RequestParam int size){
        return servicePessoa.listar(page, size);
    }
    @PutMapping
    public ResponseEntity<Pessoa> atualizar(@RequestParam Long id, @RequestBody DTO_Pessoa dtoPessoa){
        return servicePessoa.alterar(id, dtoPessoa);
    }
    @DeleteMapping ResponseEntity<Pessoa> deletar(@RequestParam Long id){
        return servicePessoa.deletar(id);
    }
}

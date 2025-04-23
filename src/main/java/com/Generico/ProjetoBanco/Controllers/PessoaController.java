package com.Generico.ProjetoBanco.Controllers;

import com.Generico.ProjetoBanco.DTO.DTO_Pessoa;
import com.Generico.ProjetoBanco.Repositorys.PessoaRepository;
import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;
    @PostMapping
    public void cadastrarPessoa(@RequestBody DTO_Pessoa pessoaDTO){
        this.pessoaRepository.save(new Pessoa(pessoaDTO));
        System.out.println("POST REALIZADO!");
    }
}

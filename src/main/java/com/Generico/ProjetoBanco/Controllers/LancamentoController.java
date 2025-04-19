package com.Generico.ProjetoBanco.Controllers;

import com.Generico.ProjetoBanco.DTO.DTO_Lancamento;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Categoria;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import com.Generico.ProjetoBanco.Model.Repositorys.CategoriaRepository;
import com.Generico.ProjetoBanco.Model.Repositorys.LancamentoRepository;
import com.Generico.ProjetoBanco.Model.Repositorys.PessoaRepository;
import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Lancamento")
public class LancamentoController {
    @Autowired
    LancamentoRepository lancamentoRepository;
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @PostMapping
    public void cadastrarLancamento(@RequestBody DTO_Lancamento lancamentoDTO){
        if(lancamentoDTO.pessoa().codigo() == null || lancamentoDTO.categoria().codigo() == null){
            System.out.println("Nulo");
        }
        else{
            Pessoa p = pessoaRepository.findById(lancamentoDTO.pessoa().codigo()).get();
            Categoria c = categoriaRepository.findById(lancamentoDTO.categoria().codigo()).get();
            lancamentoRepository.save(new Lancamento(lancamentoDTO, p, c));
        }
    }
}

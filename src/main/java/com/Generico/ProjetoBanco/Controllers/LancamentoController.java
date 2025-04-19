package com.Generico.ProjetoBanco.Controllers;

import com.Generico.ProjetoBanco.DTO.DTO_Lancamento;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Categoria;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import com.Generico.ProjetoBanco.Repositorys.CategoriaRepository;
import com.Generico.ProjetoBanco.Repositorys.LancamentoRepository;
import com.Generico.ProjetoBanco.Repositorys.PessoaRepository;
import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import com.Generico.ProjetoBanco.Services.SERVICE_Lancamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Lancamento")
public class LancamentoController {
    private final SERVICE_Lancamento serviceLancamento;
    public LancamentoController(SERVICE_Lancamento serviceLancamento) {
        this.serviceLancamento = serviceLancamento;
    }
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
            Pessoa p = this.pessoaRepository.findById(lancamentoDTO.pessoa().codigo()).get();
            Categoria c = this.categoriaRepository.findById(lancamentoDTO.categoria().codigo()).get();
            this.lancamentoRepository.save(new Lancamento(lancamentoDTO, p, c));
        }

    }
    @GetMapping
    public ResponseEntity<Page<Lancamento>> lisarLancamento(Pageable pageable){
        return ResponseEntity.ok(this.serviceLancamento.listAll(pageable));
    }

}

package com.Generico.ProjetoBanco.Controllers;

import com.Generico.ProjetoBanco.DTO.DTO_Lancamento;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Categoria;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import com.Generico.ProjetoBanco.Repositorys.CategoriaRepository;
import com.Generico.ProjetoBanco.Repositorys.LancamentoRepository;
import com.Generico.ProjetoBanco.Repositorys.PessoaRepository;
import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import com.Generico.ProjetoBanco.Services.SERVICE_Lancamento;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Transactional
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
    public ResponseEntity<Lancamento> cadastrarLancamento(@RequestBody DTO_Lancamento lancamentoDTO){
            return ResponseEntity.ok(serviceLancamento.adicionar(lancamentoDTO));
    }
    @GetMapping
    public ResponseEntity<Page<Lancamento>> lisarLancamento(Pageable pageable){
        return ResponseEntity.ok(this.serviceLancamento.listAll(pageable));
    }
    @PutMapping
    public ResponseEntity<Lancamento> editarLancamento(@RequestParam Long id, @RequestBody DTO_Lancamento lancamentoDTO){
        return serviceLancamento.alterar(id, lancamentoDTO);
    }
    @DeleteMapping
    public ResponseEntity<Lancamento> deletarLancamento(@RequestParam Long id) throws RuntimeException{
       serviceLancamento.deletar(id);
       return ResponseEntity.noContent().build();
    }
}

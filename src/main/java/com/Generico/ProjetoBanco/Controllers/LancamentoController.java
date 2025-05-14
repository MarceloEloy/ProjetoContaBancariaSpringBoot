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
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Date;

@Transactional
@RestController
@RequestMapping("/Lancamento")
public class LancamentoController {
    @Autowired
    SERVICE_Lancamento serviceLancamento;


    @PostMapping
    public ResponseEntity<Lancamento> cadastrarLancamento(@RequestBody @Valid DTO_Lancamento lancamentoDTO) throws URISyntaxException {
            return ResponseEntity.created(new URI("/Lancamento")).body(serviceLancamento.adicionar(lancamentoDTO));
    }
    @GetMapping
    public ResponseEntity<Page<DTO_Lancamento>> lisarLancamento(@RequestParam int page, @RequestParam int size){

        return ResponseEntity.ok(this.serviceLancamento.listAll(page, size));
    }
    @GetMapping("{id}")
    public ResponseEntity<Lancamento> acharUnico(@PathVariable Long id){
        return  serviceLancamento.acharUnico(id);
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

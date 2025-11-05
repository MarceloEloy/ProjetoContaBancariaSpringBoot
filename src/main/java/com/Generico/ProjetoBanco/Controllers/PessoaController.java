package com.Generico.ProjetoBanco.Controllers;

import com.Generico.ProjetoBanco.DTO.DTO_Pessoa;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import com.Generico.ProjetoBanco.Repositorys.PessoaRepository;
import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import com.Generico.ProjetoBanco.Services.SERVICE_Pessoa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@Tag(name = "Usuários", description = "Cadastro de usuários")
@RestController
@RequestMapping(path = "/Pessoa")
@SecurityRequirement(name = "bearer-key")
public class PessoaController {
    @Autowired
    public SERVICE_Pessoa servicePessoa;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Operation(summary = "Operação para cadastrar pessoas", responses = @ApiResponse(responseCode = "200", description = "Registra uma pessoa"))
    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Valid DTO_Pessoa pessoaDTO) throws URISyntaxException {
        return servicePessoa.adicionar(pessoaDTO);
    }
    @Operation(summary = "Retorna um usuário cadastrado com parametro login")
    @GetMapping("{id}")
    public ResponseEntity<Pessoa> acharUnico(@PathVariable Long id){
        return servicePessoa.acharUnico(id);
    }
    @Operation(summary = "Retorna uma página com quantidade customizavel de usuários")
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

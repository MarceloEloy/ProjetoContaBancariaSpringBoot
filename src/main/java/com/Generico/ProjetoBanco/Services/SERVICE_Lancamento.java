package com.Generico.ProjetoBanco.Services;

import com.Generico.ProjetoBanco.DTO.DTO_Lancamento;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Categoria;
import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import com.Generico.ProjetoBanco.Repositorys.CategoriaRepository;
import com.Generico.ProjetoBanco.Repositorys.LancamentoRepository;
import com.Generico.ProjetoBanco.Repositorys.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SERVICE_Lancamento {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private LancamentoRepository lancamentoRepository;
    public void deletar(Long id){
        lancamentoRepository.deleteById(id);
    }

    public Page<Lancamento> listAll(Pageable pageable){
        return lancamentoRepository.findAll(pageable);
    }
    public ResponseEntity<Lancamento> alterar(Long id, DTO_Lancamento lancamentoDTO){
        Lancamento lancamento = lancamentoRepository.findById(id).get();
        if (lancamentoDTO.pessoa() != null){
            Pessoa p = this.pessoaRepository.findById(lancamentoDTO.pessoa().codigo()).get();
            lancamento.setLancamentoPessoa(p);
        }
        if (lancamentoDTO.categoria() != null){
            Categoria c = this.categoriaRepository.findById(lancamentoDTO.categoria().codigo()).get();
            lancamento.setLancamentoCategoria(c);
        }
        else {
            System.out.println("Categoria nula");
        }
        if (lancamentoDTO.data_pagamento() != null){
            lancamento.setData_pagamento(lancamentoDTO.data_pagamento());
        }
        if (lancamentoDTO.data_vencimento() != null){
            lancamento.setData_vencimento(lancamentoDTO.data_vencimento());
        }
        if (lancamentoDTO.descricao() != null){
            lancamento.setDescricao(lancamentoDTO.descricao());
        }
        if (lancamentoDTO.tipo() != null){
            lancamento.setTipo(lancamentoDTO.tipo());
        }
        if (lancamentoDTO.observacao() != null){
            lancamento.setObservacao(lancamentoDTO.observacao());
        }
        return ResponseEntity.ok(lancamentoRepository.save(lancamento));
    }
}

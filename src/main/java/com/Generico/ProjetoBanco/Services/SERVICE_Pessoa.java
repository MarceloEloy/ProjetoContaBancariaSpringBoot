package com.Generico.ProjetoBanco.Services;

import com.Generico.ProjetoBanco.DTO.DTO_Pessoa;
import com.Generico.ProjetoBanco.Model.Usuarios.Endereco;
import com.Generico.ProjetoBanco.Model.Usuarios.Pessoa;
import com.Generico.ProjetoBanco.Repositorys.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SERVICE_Pessoa {
    @Autowired
    private PessoaRepository pessoaRepository;
    public ResponseEntity<Pessoa> adicionar(DTO_Pessoa dtoPessoa){
        return ResponseEntity.ok(pessoaRepository.save(new Pessoa(dtoPessoa)));
    }
    public ResponseEntity<Page<Pessoa>> listar(int page, int size){
        return ResponseEntity.ok(pessoaRepository.findAll(PageRequest.of(page -1, size)));
    }
    public ResponseEntity<Pessoa> alterar(Long id, DTO_Pessoa dtoPessoa){
        Pessoa atualizada = pessoaRepository.findById(id).get();
        if (atualizada.getNome() != dtoPessoa.nome()){
            atualizada.setNome(dtoPessoa.nome());
        }
        if (atualizada.getAtivo() != dtoPessoa.ativo()){
            atualizada.setAtivo(dtoPessoa.ativo());
        }
        if (atualizada.getEndereco() != new Endereco(dtoPessoa.endereco())){
            atualizada.setEndereco(new Endereco(dtoPessoa.endereco()));
        }
        return ResponseEntity.ok(pessoaRepository.save(atualizada));
    }
    public ResponseEntity<Pessoa> deletar(Long id){
        pessoaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

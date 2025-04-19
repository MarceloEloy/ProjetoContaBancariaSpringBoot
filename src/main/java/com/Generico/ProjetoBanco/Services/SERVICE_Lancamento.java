package com.Generico.ProjetoBanco.Services;

import com.Generico.ProjetoBanco.Model.ContaBancaria.Lancamento;
import com.Generico.ProjetoBanco.Repositorys.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SERVICE_Lancamento {
    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Page<Lancamento> listAll(Pageable pageable){
        return lancamentoRepository.findAll(pageable);
    }
}

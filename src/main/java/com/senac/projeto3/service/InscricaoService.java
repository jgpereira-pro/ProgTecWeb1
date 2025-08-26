package com.senac.projeto3.service;

import com.senac.projeto3.entity.Inscricao;
import com.senac.projeto3.repository.InscricaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository) {
        this.inscricaoRepository = inscricaoRepository;
    }

    public List<Inscricao> listarInscricoes(){
        return this.inscricaoRepository.findAll();
    }

    public Inscricao listarInscricaoPorId(int idInscricao){
        return this.inscricaoRepository.findById(idInscricao).orElse(null);
    }
}
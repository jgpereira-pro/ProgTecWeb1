package com.senac.projeto3.service;

import com.senac.projeto3.dto.request.InscricaoDtoRequest;
import com.senac.projeto3.dto.response.InscricaoDtoResponse;
import com.senac.projeto3.entity.Inscricao;
import com.senac.projeto3.entity.Participante;
import com.senac.projeto3.repository.JogoRepository;
import com.senac.projeto3.repository.InscricaoRepository;
import com.senac.projeto3.repository.ParticipanteRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {

    @Autowired
    private ModelMapper modelMapper;

    private final InscricaoRepository inscricaoRepository;
    private final JogoRepository jogoRepository;
    private final ParticipanteRepository participanteRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository, JogoRepository jogoRepository, ParticipanteRepository participanteRepository) {
        this.inscricaoRepository = inscricaoRepository;
        this.jogoRepository = jogoRepository;
        this.participanteRepository = participanteRepository;
    }

    public List<Inscricao> listarInscricoes(){
        return this.inscricaoRepository.findAll();
    }

    public Inscricao listarInscricaoPorId(int idInscricao){
        return this.inscricaoRepository.findById(idInscricao).orElse(null);
    }

    public InscricaoDtoResponse salvar(InscricaoDtoRequest inscricaoDtoRequest) {
        Inscricao inscricao = new Inscricao();
        inscricao.setData(inscricaoDtoRequest.getData());
        inscricao.setStatus(1);
        inscricao.setJogo(jogoRepository.obterJogoAtivoPorId(inscricaoDtoRequest.getJogoId()));
        inscricao.setParticipante(participanteRepository.obterParticipanteAtivoPorId(inscricaoDtoRequest.getParticipanteId()));
        Inscricao inscricaoSave = this.inscricaoRepository.save(inscricao);
        return modelMapper.map(inscricaoSave, InscricaoDtoResponse.class);
    }

    public InscricaoDtoResponse atualizar(@Valid Integer idInscricao, InscricaoDtoRequest inscricaoDtoRequest) {
        Inscricao inscricao = this.listarInscricaoPorId(idInscricao);
        if(inscricao!= null){
            inscricao.setData(inscricaoDtoRequest.getData());
            inscricao.setStatus(inscricaoDtoRequest.getStatus());
            inscricao.setJogo(jogoRepository.obterJogoAtivoPorId(inscricaoDtoRequest.getJogoId()));
            inscricao.setParticipante(participanteRepository.obterParticipanteAtivoPorId(inscricaoDtoRequest.getParticipanteId()));
            Inscricao inscricaoTemp = this.inscricaoRepository.save(inscricao);
            return modelMapper.map(inscricaoTemp, InscricaoDtoResponse.class);
        }else{
            return null;
        }
    }

    public void apagar(Integer idInscricao) {
        this.inscricaoRepository.apagadorLogico(idInscricao);
    }
}
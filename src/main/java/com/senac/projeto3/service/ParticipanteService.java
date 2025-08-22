package com.senac.projeto3.service;

import com.senac.projeto3.entity.Participante;
import com.senac.projeto3.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    public List<Participante> listarParticipantes() {
        return participanteRepository.findAll();
    }

    public Participante listarParticipantePorId(int idParticipante) {
        return participanteRepository.findById(idParticipante).orElse(null);
    }
}

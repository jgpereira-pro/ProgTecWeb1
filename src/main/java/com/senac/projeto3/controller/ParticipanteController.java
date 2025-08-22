package com.senac.projeto3.controller;

import com.senac.projeto3.entity.Participante;
import com.senac.projeto3.service.ParticipanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/participante")
@Tag(name="Participante", description ="API para gerenciamento dos participantes do sistema")
public class ParticipanteController {

    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar participante do sistema")
    public ResponseEntity<List<Participante>> listar(){
        return ResponseEntity.ok(participanteService.listarParticipantes());
    }

    @GetMapping("/listarPorIdParticipante{idParticipante}")
    @Operation(summary = "Listar participantes do sistema por id dos participantes")
    public ResponseEntity<Participante> listerPorIdParticipante(@PathVariable("idParticipante") Integer idParticipante){
        Participante participante = participanteService.listarParticipantePorId(idParticipante);
        if (participante == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(participante);
        }
    }

    @PostMapping("/atualizar")
    public String criar(){
        return "Participante criado com sucesso";
    }

    @PutMapping("/criar")
    public String atualizar(){
        return "Participante atualizado com sucesso";
    }

    @DeleteMapping("/apagar")
    public String apagar(){
        return "Participante apagado com sucesso";
    }
}

package com.senac.projeto3.controller;

import com.senac.projeto3.entity.Inscricao;
import com.senac.projeto3.service.InscricaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inscricao")
@Tag(name="Inscricao", description ="API para gerenciamento das inscrições do sistema")
public class InscricaoController {

    private final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar inscricao do sistema")
    public ResponseEntity<List<Inscricao>> listar(){
        return ResponseEntity.ok(inscricaoService.listarInscricoes());
    }

    @GetMapping("/listarPorIdInscricao{idInscricao}")
    @Operation(summary = "Listar Inscricoes do sistema por id das inscricoes")
    public ResponseEntity<Inscricao> listerPorIdInscricao(@PathVariable("idInscricao") Integer idInscricao){
        Inscricao inscricao = inscricaoService.listarInscricaoPorId(idInscricao);
        if (inscricao == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(inscricao);
        }
    }
}
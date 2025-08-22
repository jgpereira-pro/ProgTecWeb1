package com.senac.projeto3.controller;

import com.senac.projeto3.entity.Patrocinador;
import com.senac.projeto3.service.PatrocinadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patrocinador")
@Tag(name = "Patrocinador", description = "API para gerenciamento dos patrocinador do sistema")
public class PatrocinadorController {

    private final PatrocinadorService patrocinadorService;

    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar patrocinadores do sistema")
    public ResponseEntity<List<Patrocinador>> listar() {
        return ResponseEntity.ok(patrocinadorService.listarPatrocinadores());
    }

    @GetMapping("/listarPorIdPatrocinador{idPatrocinador}")
    @Operation(summary = "Listar patrocinadores do sistema por id do patrocinador")
    public ResponseEntity<Patrocinador> listerPorIdPatrocinador(@PathVariable("idPatrocinador") Integer idPatrocinador) {
        Patrocinador patrocinador = patrocinadorService.listarPatrocinadorPorId(idPatrocinador);
        if (patrocinador == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(patrocinador);
        }
    }

    @PostMapping("/atualizar")
    public String criar() {
        return "Patrocinador criado com sucesso";
    }

    @PutMapping("/criar")
    public String atualizar() {
        return "Patrocinador atualizado com sucesso";
    }

    @DeleteMapping("/apagar")
    public String apagar() {
        return "Patrocinador apagado com sucesso";
    }
}

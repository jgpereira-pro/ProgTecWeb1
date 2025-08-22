package com.senac.projeto3.controller;

import com.senac.projeto3.entity.Premio;
import com.senac.projeto3.service.PremioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/premio")
@Tag(name = "Premio", description = "API para gerenciamento dos premios do sistema")
public class PremioController {

    private final PremioService premioService;

    public PremioController(PremioService premioService) {
        this.premioService = premioService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar premios do sistema")
    public ResponseEntity<List<Premio>> listar() {
        return ResponseEntity.ok(premioService.listarPremios());
    }

    @GetMapping("/listarPorIdPremio{idPremio}")
    @Operation(summary = "Listar premios do sistema por id do premio")
    public ResponseEntity<Premio> listerPorIdPremio(@PathVariable("idPremio") Integer idPremio) {
        Premio premio = premioService.listarPremioPorId(idPremio);
        if (premio == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(premio);
        }
    }

    @PostMapping("/atualizar")
    public String criar() {
        return "Premio criado com sucesso";
    }

    @PutMapping("/criar")
    public String atualizar() {
        return "Premio atualizado com sucesso";
    }

    @DeleteMapping("/apagar")
    public String apagar() {
        return "Premio apagado com sucesso";
    }
}

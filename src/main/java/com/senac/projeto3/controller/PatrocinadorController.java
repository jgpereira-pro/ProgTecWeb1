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
@Tag(name="Patrocinador", description="API para gerenciamento dos patrocinadores do sistema")
public class PatrocinadorController {
    private final PatrocinadorService patrocinadorService;

    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar patrocinadores do sistema")
    public ResponseEntity<List<Patrocinador>> listar(){
        return ResponseEntity.ok(patrocinadorService.listarPatrocinadores());
    }

    @GetMapping("/listarPorIdUsuario/{idUsuario}")
    @Operation(summary = "Listar usuarios do sistema pelo id do usuário")
    public ResponseEntity<Patrocinador> listarPorIdUsuario(@PathVariable("idPatrocinador") Integer idPatrocinador){
        Patrocinador patrocinador = patrocinadorService.listarPatrocinadorPorId(idPatrocinador);
        if (patrocinador == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(patrocinador);
        }
    }

}
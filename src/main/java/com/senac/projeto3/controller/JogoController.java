package com.senac.projeto3.controller;

import com.senac.projeto3.entity.Jogo;
import com.senac.projeto3.service.JogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jogo")
@Tag(name="Jogo", description ="API para gerenciamento dos jogos do sistema")
public class JogoController {

    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService =jogoService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar jogo do sistema")
    public ResponseEntity<List<Jogo>> listar(){
        return ResponseEntity.ok(jogoService.listarjogos());
    }

    @GetMapping("/listarPorIdJogo{idJogo}")
    @Operation(summary = "Listar jogos do sistema por id das jogos")
    public ResponseEntity<Jogo> listerPorIdJogo(@PathVariable("idJogo") Integer idJogo){
        Jogo jogo = jogoService.listarJogoPorId(idJogo);
        if (jogo == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(jogo);
        }
    }

    @PostMapping("/atualizar")
    public String criar(){
        return "Jogo criado com sucesso";
    }

    @PutMapping("/criar")
    public String atualizar(){
        return "Jogo atualizado com sucesso";
    }

    @DeleteMapping("/apagar")
    public String apagar(){
        return "Jogo apagado com sucesso";
    }
}

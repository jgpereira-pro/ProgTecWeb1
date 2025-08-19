package com.senac.projeto3.controller;

import com.senac.projeto3.entity.Usuario;
import com.senac.projeto3.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@Tag(name="Usuario", description ="API para gerenciamento dos usuarios do sistema")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar usuarios do sistema")
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/listarPorIdUsuario{idUsuario}")
    @Operation(summary = "Listar usuarios do sistema por id do usuario")
    public ResponseEntity<Usuario> listerPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
        return ResponseEntity.ok(usuarioService.listarUsuarioPorId(idUsuario));
    }

    @PostMapping("/atualizar")
    public String criar(){
        return "Usuario criado com sucesso";
    }

    @PutMapping("/criar")
    public String atualizar(){
        return "Usuario atualizado com sucesso";
    }

    @DeleteMapping("/apagar")
    public String apagar(){
        return "Usuaria apagado com sucesso";
    }
}

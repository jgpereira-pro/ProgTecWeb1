package com.senac.projeto3.controller;

import com.senac.projeto3.dto.response.UsuarioDtoResponse;
import com.senac.projeto3.dto.request.UsuarioDtoRequest;
import com.senac.projeto3.entity.Usuario;
import com.senac.projeto3.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@Tag(name="Usuario", description="API para gerenciamento dos usuarios do sistema")
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

    @GetMapping("/listarPorIdUsuario/{idUsuario}")
    @Operation(summary = "Listar usuarios do sistema pelo id do usuário")
    public ResponseEntity<Usuario> listarPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
        Usuario usuario = usuarioService.listarUsuarioPorId(idUsuario);
        if (usuario == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(usuario);
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar um novo usuario")
    public ResponseEntity<UsuarioDtoResponse>criar(@Valid @RequestBody UsuarioDtoRequest usuarioDtoRequest){
        return ResponseEntity.ok(usuarioService.salvar(usuarioDtoRequest));
    }

    @PutMapping("/atualizar/{idUsuario}")
    @Operation(summary = "Atualiza todos os parametros de um usuário.")
    public ResponseEntity<UsuarioDtoResponse> atualizar(
            @Valid @PathVariable("idUsuario") Integer idUsuario,
            @RequestBody UsuarioDtoRequest usuarioDtoRequest){
        return ResponseEntity.ok(usuarioService.atualizar(idUsuario,usuarioDtoRequest));
    }

    @PatchMapping("/atualizarParametro")
    @Operation(summary = "Atualiza um dos parametros de um usuário do sistema.")
    public String atualizarParametro(){
        return "Parametro atualizado com sucesso!";
    }

    @DeleteMapping("/apagar/{idUsuario}")
    @Operation(summary = "Deleta um usuário do sistema pelo id.")
    public ResponseEntity<UsuarioDtoResponse> apagar(@PathVariable("idUsuario") Integer idUsuario){
        usuarioService.apagar(idUsuario);
        return ResponseEntity.noContent().build();
    }
}
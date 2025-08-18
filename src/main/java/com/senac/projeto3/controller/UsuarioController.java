package com.senac.projeto3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@Tag(name="Usuario", description ="API para gerenciamento dos usuarios do sistema")
public class UsuarioController {

    @GetMapping("/listar")
    @Operation(summary = "Listar usuarios do sistema")
    public String lister(){
        return "Listando com sucesso";
    }

    @GetMapping("/listarPorIdUsuario{idUsuario}")
    @Operation(summary = "Listar usuarios do sistema por id do usuario")
    public String listerPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
        return "Listando um usuario com id "+ idUsuario +" com sucesso";
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

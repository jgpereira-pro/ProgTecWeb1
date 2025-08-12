package com.senac.projeto3.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @GetMapping
    public String lister(){
        return "Listando com sucesso";
    }

    @PostMapping
    public String criar(){
        return "Usuario criado com sucesso";
    }

    @PutMapping
    public String atualizar(){
        return "Usuario atualizado com sucesso";
    }

    @DeleteMapping
    public String apagar(){
        return "Usuaria apagado com sucesso";
    }
}

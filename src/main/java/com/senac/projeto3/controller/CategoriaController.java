package com.senac.projeto3.controller;

import com.senac.projeto3.entity.Categoria;
import com.senac.projeto3.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
@Tag(name="Categoria", description ="API para gerenciamento das categorias do sistema")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar categoria do sistema")
    public ResponseEntity<List<Categoria>> listar(){
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/listarPorIdCategoria{idCategoria}")
    @Operation(summary = "Listar categorias do sistema por id das categorias")
    public ResponseEntity<Categoria> listerPorIdUsuario(@PathVariable("idCategoria") Integer idCategoria){
        Categoria categoria = categoriaService.listarCategoriaPorId(idCategoria);
        if (categoria == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(categoria);
        }
    }

    @PostMapping("/atualizar")
    public String criar(){
        return "Categoria criado com sucesso";
    }

    @PutMapping("/criar")
    public String atualizar(){
        return "Categoria atualizado com sucesso";
    }

    @DeleteMapping("/apagar")
    public String apagar(){
        return "Categoria apagado com sucesso";
    }
}

package com.dev.LojaVirtual.controller;

import com.dev.LojaVirtual.dto.CategoriaDtoBody;
import com.dev.LojaVirtual.dto.CategoriaDtoPath;
import com.dev.LojaVirtual.entites.Categoria;
import com.dev.LojaVirtual.services.CategoriaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody CategoriaDtoBody categoriaDtoBody) {

        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(categoriaDtoBody));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@RequestBody CategoriaDtoBody categoriaDto, @PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.update(categoriaDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        categoriaService.delete(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body("CATEGORIA DELETADA COM SUCESSO " + id);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<CategoriaDtoPath> findByNome(@PathVariable String nome) {

        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findByNome(nome));
    }

}

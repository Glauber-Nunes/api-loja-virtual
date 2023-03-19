package com.dev.LojaVirtual.controller;

import com.dev.LojaVirtual.dto.ProdutoDtoBody;
import com.dev.LojaVirtual.entites.Produto;
import com.dev.LojaVirtual.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat,
                                        @RequestParam(value = "marca", defaultValue = "0") Long id_marca,
                                        @RequestBody ProdutoDtoBody produtoDtoBody) {

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(id_cat, id_marca, produtoDtoBody));

        // URL POSTMAN http://localhost:8088/produtos?categorias=2&marca=1
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(id));

        //URL POSTMAN http://localhost:8088/produtos/7
    }

    @DeleteMapping("/{id_produto}")
    public ResponseEntity<String> delete(@PathVariable Long id_produto) {

        Produto prod = new Produto();

        produtoService.delete(id_produto, prod);

        return ResponseEntity.status(HttpStatus.OK).body("O Produto " + " " + prod.getDescricaoCurta()
                + " Foi Excluido Com Sucesso!!");
    }
}

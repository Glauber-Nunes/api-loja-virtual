package com.dev.LojaVirtual.controller;

import com.dev.LojaVirtual.entites.ImagensProduto;
import com.dev.LojaVirtual.services.ImagensProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/imagens")
public class ImagensProdutoController {
    @Autowired
    private ImagensProdutoService imagensProdutoService;

    @PostMapping
    public ResponseEntity<ImagensProduto> inserir(@RequestParam(value = "idProduto")Long id, @RequestParam(value = "file")MultipartFile file){

        return ResponseEntity.status(HttpStatus.CREATED).body(imagensProdutoService.inserir(id,file));
    }

    // URL POSTMAN http://localhost:8088/imagens?idProduto=7&file
}

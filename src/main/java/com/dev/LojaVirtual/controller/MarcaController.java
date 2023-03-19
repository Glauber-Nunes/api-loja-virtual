package com.dev.LojaVirtual.controller;

import com.dev.LojaVirtual.dto.MarcaDtoBody;
import com.dev.LojaVirtual.dto.MarcaDtoGet;
import com.dev.LojaVirtual.entites.Marca;
import com.dev.LojaVirtual.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @PostMapping
    public ResponseEntity<Marca> save(@RequestBody MarcaDtoBody marcaDtoBody) {

        return ResponseEntity.status(HttpStatus.OK).body(marcaService.save(marcaDtoBody));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDtoGet> findById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(marcaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@PathVariable Long id_marca, @RequestBody MarcaDtoBody newObj) {

        return ResponseEntity.status(HttpStatus.OK).body(marcaService.update(id_marca, newObj));
    }
}

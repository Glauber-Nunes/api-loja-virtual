package com.dev.LojaVirtual.controller;

import com.dev.LojaVirtual.dto.EstadoDtoBody;
import com.dev.LojaVirtual.dto.EstadoDtoGet;
import com.dev.LojaVirtual.entites.Estado;
import com.dev.LojaVirtual.repository.EstadoRepository;
import com.dev.LojaVirtual.services.EstadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;
    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<Estado> save(@Valid @RequestBody EstadoDtoBody estadoDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.save(estadoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDtoGet> findByid(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(estadoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> update(@PathVariable Long id, @RequestBody EstadoDtoBody estadoDto) {

        return ResponseEntity.status(HttpStatus.OK).body(estadoService.update(id, estadoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        estadoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("DELETADO COM SUCESSO ID: " + id);

    }

    @GetMapping
    public ResponseEntity<List<EstadoDtoGet>> listAll() {

        return ResponseEntity.status(HttpStatus.OK).body(estadoService.listAll());
    }
}

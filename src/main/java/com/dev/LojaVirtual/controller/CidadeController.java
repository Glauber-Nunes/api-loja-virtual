package com.dev.LojaVirtual.controller;

import com.dev.LojaVirtual.dto.CidadeDtoBody;
import com.dev.LojaVirtual.dto.CidadeDtoGet;
import com.dev.LojaVirtual.entites.Cidade;
import com.dev.LojaVirtual.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> save(@RequestParam(value = "estado",defaultValue = "0")Long id_estado, @RequestBody CidadeDtoBody cidadeDtoBody){

        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.save(id_estado,cidadeDtoBody));

        // URL POSTMAN http:localhost:8088/cidades?estado=id_estado
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDtoGet> findById(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> update(@PathVariable Long id,@RequestBody CidadeDtoBody newobj){

        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.update(id,newobj));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<CidadeDtoGet> findByNome(@PathVariable String nome){

        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.findByNome(nome));
    }
}

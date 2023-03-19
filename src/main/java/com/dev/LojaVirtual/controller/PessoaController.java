package com.dev.LojaVirtual.controller;

import com.dev.LojaVirtual.entites.Pessoa;
import com.dev.LojaVirtual.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestParam(value = "permissao", defaultValue = "0") Long id_permissao, @RequestParam(value = "cidade", defaultValue = "0") Long id_cidade
            , @RequestBody Pessoa newObj) {

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.savePessoa(id_permissao,id_cidade, newObj));

    }

}

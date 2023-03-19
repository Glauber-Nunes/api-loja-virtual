package com.dev.LojaVirtual.controller;

import com.dev.LojaVirtual.dto.PessoaClienteDtoGet;
import com.dev.LojaVirtual.dto.PessoaClienteDtoRequest;
import com.dev.LojaVirtual.entites.Cidade;
import com.dev.LojaVirtual.entites.Pessoa;
import com.dev.LojaVirtual.services.PessoaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class PessoaClienteController {
    @Autowired
    private PessoaClienteService pessoaClienteService;

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestParam(value = "cidade", defaultValue = "0") Long id_cidade
            , @RequestBody PessoaClienteDtoRequest newObj) {

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaClienteService.save(id_cidade, newObj));

    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<PessoaClienteDtoGet>> findByNome(@PathVariable String nome) {

        return ResponseEntity.status(HttpStatus.OK).body(pessoaClienteService.findByNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(pessoaClienteService.findById(id));

    }

    @PutMapping
    public ResponseEntity<Pessoa> update(@RequestParam(value = "id_cidade") Long id_cidade, @RequestParam(value = "id_cliente") Long id_cliente, @RequestBody PessoaClienteDtoRequest clienteDtoRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaClienteService.update(id_cidade, id_cliente, clienteDtoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        pessoaClienteService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente Deletado Com Sucesso");
    }

}

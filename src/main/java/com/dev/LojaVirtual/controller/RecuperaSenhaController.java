package com.dev.LojaVirtual.controller;

import com.dev.LojaVirtual.entites.Pessoa;
import com.dev.LojaVirtual.services.RecuperaSenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente-gerenciamento")
public class RecuperaSenhaController {
    @Autowired
    private RecuperaSenhaService clienteRecuperaSenhaService;

    @PostMapping("/codigo-recuperacao")
    public ResponseEntity<String> solicitarCodigoRecuperacaoSenha(@RequestBody Pessoa pessoa) {

        return ResponseEntity.status(HttpStatus.OK).body(clienteRecuperaSenhaService.solicitarCodigoRecuperacaoSenha(pessoa.getEmail()));
    }

    @PostMapping("/alterar-senha")
    public ResponseEntity<String> recuperarSenha(@RequestBody Pessoa pessoa) {

        return ResponseEntity.status(HttpStatus.OK).body(clienteRecuperaSenhaService.recuperarSenha(pessoa));
    }

}

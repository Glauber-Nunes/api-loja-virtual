package com.dev.LojaVirtual.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Email {
    private String titulo;
    private String mensagem;
    public Email(String titulo, String mensagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

}

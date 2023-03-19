package com.dev.LojaVirtual.dto;

import com.dev.LojaVirtual.entites.Cidade;
import com.dev.LojaVirtual.entites.Estado;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoDtoGet {

    private Long id;
    private String nome;
    private String sigla;

    public EstadoDtoGet(Estado entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sigla = entity.getSigla();
    }

}

package com.dev.LojaVirtual.dto;

import com.dev.LojaVirtual.entites.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDtoPath {

    private Long id;
    private String nome;

    public CategoriaDtoPath(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
}

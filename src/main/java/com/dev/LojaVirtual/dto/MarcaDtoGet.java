package com.dev.LojaVirtual.dto;

import com.dev.LojaVirtual.entites.Marca;
import com.dev.LojaVirtual.entites.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDtoGet {
    private Long id;
    private String nome;
    private List<Produto> produtoList = new ArrayList<>();
    public MarcaDtoGet(Marca marca){
        this.id = marca.getId();
        this.nome = marca.getNome();
        this.produtoList = marca.getProdutoList();
    }
}

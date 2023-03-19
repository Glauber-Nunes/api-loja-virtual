package com.dev.LojaVirtual.dto;

import com.dev.LojaVirtual.entites.Cidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//CLASSE PARA OS METODOS DE RETORNO FINDALL E FINDBYID
public class CidadeDtoGet {
    private Long id;
    private String nome;
    private EstadoDtoGet estadoDtoGet;


    public CidadeDtoGet(Cidade entityCidade) {
        this.id = entityCidade.getId();
        this.nome = entityCidade.getNome();
        this.estadoDtoGet = new EstadoDtoGet(entityCidade.getEstados());
    }
}

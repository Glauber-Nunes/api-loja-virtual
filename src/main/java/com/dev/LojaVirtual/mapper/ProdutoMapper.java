package com.dev.LojaVirtual.mapper;

import com.dev.LojaVirtual.dto.ProdutoDtoBody;
import com.dev.LojaVirtual.entites.Categoria;
import com.dev.LojaVirtual.entites.Marca;
import com.dev.LojaVirtual.entites.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;


@Component
public class ProdutoMapper {

    public Produto convertDtoEmEntidadeSave(Categoria categoria, Marca marca, ProdutoDtoBody newObj) {

        return Produto.builder()
                .id(null)
                .descricaoCurta(newObj.getDescricaoCurta())
                .descricaoDetalhada(newObj.getDescricaoDetalhada())
                .valorCusto(newObj.getValorCusto())
                .valorVenda(newObj.getValorVenda())
                .dataCriacao(Instant.now())
                .marca(marca)
                .categoria(categoria)
                .build();

    }
}

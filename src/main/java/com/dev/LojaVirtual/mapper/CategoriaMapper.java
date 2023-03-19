package com.dev.LojaVirtual.mapper;

import com.dev.LojaVirtual.dto.CategoriaDtoBody;
import com.dev.LojaVirtual.entites.Categoria;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CategoriaMapper {

    public Categoria convertDtoEmEntitySave(CategoriaDtoBody categoriaDtoBody){

        return Categoria.builder()
                .id(null)
                .nome(categoriaDtoBody.getNome())
                .dataCriacao(Instant.now())
                .build();
    }

    public Categoria convertDtoEmEntityUpdate(Categoria objPesquisado, CategoriaDtoBody newObj){

        return Categoria.builder()
                .id(objPesquisado.getId())
                .nome(newObj.getNome())
                .dataCriacao(objPesquisado.getDataCriacao())
                .dataAtualizacao(Instant.now())
                .build();

    }
}

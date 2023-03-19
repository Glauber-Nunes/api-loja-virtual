package com.dev.LojaVirtual.mapper;

import com.dev.LojaVirtual.dto.MarcaDtoBody;
import com.dev.LojaVirtual.entites.Marca;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class MarcaMapper {

    public Marca convertDtoEmEntitySave(MarcaDtoBody marcaDtoBody){

        return Marca.builder()
                .id(null)
                .nome(marcaDtoBody.getNome())
                .dataCriacao(Instant.now())
                .build();
    }

    public Marca convertDtoEmEntityUpdate(Marca objPesquisado,MarcaDtoBody newObj){

        return Marca.builder()
                .id(objPesquisado.getId())
                .nome(newObj.getNome())
                .dataCriacao(objPesquisado.getDataCriacao())
                .dataAtualizacao(Instant.now())
                .build();

    }
}

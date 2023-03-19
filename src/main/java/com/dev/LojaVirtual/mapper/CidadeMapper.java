package com.dev.LojaVirtual.mapper;

import com.dev.LojaVirtual.dto.CidadeDtoBody;
import com.dev.LojaVirtual.entites.Cidade;
import com.dev.LojaVirtual.entites.Estado;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CidadeMapper {

    public Cidade convertDtoEmEntidadeSave(Estado estado, CidadeDtoBody cidadeDtoBody) {

        return Cidade.builder()
                .id(null)
                .nome(cidadeDtoBody.getNome())
                .estados(estado)
                .dataCriacao(Instant.now())
                .build();
    }

    public Cidade convertDtoEmEntidadeUpdate(CidadeDtoBody newobj, Cidade objPesquisado) {

        return Cidade.builder()
                .id(objPesquisado.getId())
                .nome(newobj.getNome() != null ? newobj.getNome():objPesquisado.getNome())
                .estados(newobj.getEstados() != null ? newobj.getEstados():objPesquisado.getEstados())
                .dataCriacao(objPesquisado.getDataCriacao())
                .dataAtualizacao(newobj.getDataAtualizacao())
                .build();
    }
}

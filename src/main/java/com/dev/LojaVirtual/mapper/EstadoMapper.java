package com.dev.LojaVirtual.mapper;

import com.dev.LojaVirtual.dto.EstadoDtoBody;
import com.dev.LojaVirtual.dto.EstadoDtoGet;
import com.dev.LojaVirtual.entites.Estado;
import com.dev.LojaVirtual.repository.EstadoRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoMapper {
    private final EstadoRepository estadoRepository;

    public EstadoMapper(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public Estado converteDtoEmEntidadeSave(EstadoDtoBody estadoDto) {

        return Estado.builder()
                .id(null)
                .nome(estadoDto.getNome())
                .sigla(estadoDto.getSigla())
                .dataCriacao(Instant.now())
                .build();

    }

    public Estado converteDtoEmEntidadeUpdate(Estado objPesquisado, EstadoDtoBody novoObjeto) {

        return Estado.builder()
                .id(objPesquisado.getId())
                .nome(novoObjeto.getNome())
                .sigla(novoObjeto.getSigla())
                .dataAtualizacao(Instant.now())
                .dataCriacao(objPesquisado.getDataCriacao())
                .build();

    }

    public List<EstadoDtoGet> conversorDeListaDto(List<Estado> list) {

        List<EstadoDtoGet> dtoListAll = list.stream().map(estado -> new EstadoDtoGet(estado)).collect(Collectors.toList());

        return dtoListAll;
    }

}

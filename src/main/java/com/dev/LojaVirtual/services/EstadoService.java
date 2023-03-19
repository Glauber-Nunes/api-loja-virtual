package com.dev.LojaVirtual.services;

import com.dev.LojaVirtual.dto.EstadoDtoBody;
import com.dev.LojaVirtual.dto.EstadoDtoGet;
import com.dev.LojaVirtual.entites.Estado;
import com.dev.LojaVirtual.mapper.EstadoMapper;
import com.dev.LojaVirtual.repository.EstadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private EstadoMapper estadoMapper;

    @Transactional
    public Estado save(EstadoDtoBody estadoDto) {
        return estadoRepository.save(estadoMapper.converteDtoEmEntidadeSave(estadoDto));
    }

    public EstadoDtoGet findById(Long id) {
        Optional<Estado> estado = estadoRepository.findById(id);

        return new EstadoDtoGet(estado.get());
    }

    public Estado update(Long id, EstadoDtoBody novoObjeto) {

        Optional<Estado> objPesquisado = estadoRepository.findById(id);

        return estadoRepository.save(estadoMapper.converteDtoEmEntidadeUpdate(objPesquisado.get(), novoObjeto));

    }

    public void delete(Long id) {

       Estado estado = estadoRepository.findById(id).get();

        estadoRepository.delete(estado);
    }

    public List<EstadoDtoGet> listAll() {

        List<Estado> list = estadoRepository.findAll();

        return estadoMapper.conversorDeListaDto(list);
    }
}

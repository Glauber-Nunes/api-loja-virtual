package com.dev.LojaVirtual.services;

import com.dev.LojaVirtual.dto.MarcaDtoBody;
import com.dev.LojaVirtual.dto.MarcaDtoGet;
import com.dev.LojaVirtual.entites.Marca;
import com.dev.LojaVirtual.mapper.MarcaMapper;
import com.dev.LojaVirtual.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private MarcaMapper marcaMapper;

    public Marca save(MarcaDtoBody marcaDtoBody) {

        return marcaRepository.save(marcaMapper.convertDtoEmEntitySave(marcaDtoBody));
    }

    public MarcaDtoGet findById(Long id) {

        Optional<Marca> marca = marcaRepository.findById(id);

        return new MarcaDtoGet(marca.get());
    }

    public void delete(Long id) {

        Optional<Marca> marca = marcaRepository.findById(id);

        marcaRepository.delete(marca.get());

    }

    public Marca update(Long id_marca, MarcaDtoBody newObj) {
        Marca objPesquisado = marcaRepository.findById(id_marca).get();

        return marcaRepository.save(marcaMapper.convertDtoEmEntityUpdate(objPesquisado, newObj));
    }

}

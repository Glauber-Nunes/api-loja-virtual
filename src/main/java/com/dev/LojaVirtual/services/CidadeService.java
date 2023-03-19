package com.dev.LojaVirtual.services;

import com.dev.LojaVirtual.dto.CidadeDtoBody;
import com.dev.LojaVirtual.dto.CidadeDtoGet;
import com.dev.LojaVirtual.entites.Cidade;
import com.dev.LojaVirtual.entites.Estado;
import com.dev.LojaVirtual.exceptions.EntityNotFound;
import com.dev.LojaVirtual.mapper.CidadeMapper;
import com.dev.LojaVirtual.repository.CidadeRepository;
import com.dev.LojaVirtual.repository.EstadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private CidadeMapper cidadeMapper;
    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public Cidade save(Long id_estado, CidadeDtoBody cidadeDtoBody) {

        Optional<Estado> estado = estadoRepository.findById(id_estado);
        cidadeDtoBody.setEstados(estado.get());

        return cidadeRepository.save(cidadeMapper.convertDtoEmEntidadeSave(estado.get(), cidadeDtoBody));

    }

    public CidadeDtoGet findById(Long id) {

        Optional<Cidade> entity = cidadeRepository.findById(id);


        return new CidadeDtoGet(entity.get());
    }

    @Transactional
    public Cidade update(Long id, CidadeDtoBody newObj) {

        Optional<Cidade> objPesquisado = cidadeRepository.findById(id);

        return cidadeRepository.save(cidadeMapper.convertDtoEmEntidadeUpdate(newObj, objPesquisado.get()));

    }

    public CidadeDtoGet findByNome(String nome) {

        Cidade cidade = cidadeRepository.findByNome(nome);

        if (cidade == null) throw new EntityNotFound("Cidade Não Encontrada");

        return new CidadeDtoGet(cidade);

    }
}

package com.dev.LojaVirtual.services;

import com.dev.LojaVirtual.entites.Cidade;
import com.dev.LojaVirtual.entites.Permissao;
import com.dev.LojaVirtual.entites.Pessoa;
import com.dev.LojaVirtual.mapper.PessoaClienteMapper;
import com.dev.LojaVirtual.mapper.PessoaMapper;
import com.dev.LojaVirtual.repository.CidadeRepository;
import com.dev.LojaVirtual.repository.PermissaoRepository;
import com.dev.LojaVirtual.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private PessoaMapper pessoaMapper;
    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private PessoaClienteMapper pessoaClienteMapper;

    public Pessoa savePessoa(Long id_Permissao,Long id_cidade, Pessoa newObj) {

        Permissao permissao = permissaoRepository.findById(id_Permissao).get();

        Cidade cidade = cidadeRepository.findById(id_cidade).get();

        return pessoaRepository.save(pessoaMapper.convertDtoEmEntity(permissao,cidade, newObj));

        // https:localhost/pessoas?cidade=1
    }



}

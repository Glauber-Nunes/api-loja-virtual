package com.dev.LojaVirtual.services;

import com.dev.LojaVirtual.dto.PessoaClienteDtoGet;
import com.dev.LojaVirtual.dto.PessoaClienteDtoRequest;
import com.dev.LojaVirtual.entites.Cidade;
import com.dev.LojaVirtual.entites.Permissao;
import com.dev.LojaVirtual.entites.Pessoa;
import com.dev.LojaVirtual.exceptions.EntityNotFound;
import com.dev.LojaVirtual.mapper.PessoaClienteMapper;
import com.dev.LojaVirtual.repository.CidadeRepository;
import com.dev.LojaVirtual.repository.PermissaoRepository;
import com.dev.LojaVirtual.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PessoaClienteService {

    @Autowired
    private PermissaoRepository permissaoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaClienteMapper pessoaClienteMapper;
    @Autowired
    private EmailService emailService;

    @Transactional
    public Pessoa save(Long id_cidade, PessoaClienteDtoRequest newObj) {

        Permissao permissaoCliente = permissaoRepository.findById(1L).get(); // recebe a permissao de cliente

        Cidade cidade = cidadeRepository.findById(id_cidade).get();

        Pessoa clienteSalvo = pessoaRepository.save(pessoaClienteMapper.convertDtoEmEntity(permissaoCliente, cidade, newObj));
        Map<String, Object> prop = new HashMap<>();
        prop.put("nome", clienteSalvo.getNome());
        prop.put("mensagem", "SEU REGISTRO FOI FEITO COM SUCESSO :)");
        emailService.enviarEmailBoasVindasTemplate(clienteSalvo.getEmail(), "SEJA BEM VINDO", prop);
        return clienteSalvo;
    }

    public Pessoa findById(Long id) {

        Optional<Pessoa> cliente = pessoaRepository.findById(id);

        cliente.orElseThrow(() -> new EntityNotFound("Cliente Não Encontrado"));

        return cliente.get();

    }

    @Transactional
    public Pessoa update(Long id_cidade, Long id, PessoaClienteDtoRequest newObj) {

        Optional<Cidade> cidade = cidadeRepository.findById(id_cidade);

        Pessoa obj = this.findById(id);

        return pessoaRepository.saveAndFlush(pessoaClienteMapper.convertDtoEmEntityUpdate(cidade.get(), newObj, obj));

    }

    public List<PessoaClienteDtoGet> findByNome(String nome) {

        List<Pessoa> Listclientes = pessoaRepository.findByNome(nome);

        if (Listclientes.size() == 0) throw new EntityNotFound("Cliente Não Encontrado");

        return pessoaClienteMapper.conversor(Listclientes);
    }

    public void delete(Long id) {
        Pessoa cliente = this.findById(id);
        pessoaRepository.delete(cliente);
    }

}

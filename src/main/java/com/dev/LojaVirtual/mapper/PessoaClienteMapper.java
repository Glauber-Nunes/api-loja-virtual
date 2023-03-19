package com.dev.LojaVirtual.mapper;


import com.dev.LojaVirtual.dto.PessoaClienteDtoGet;
import com.dev.LojaVirtual.dto.PessoaClienteDtoRequest;
import com.dev.LojaVirtual.entites.Cidade;
import com.dev.LojaVirtual.entites.Permissao;
import com.dev.LojaVirtual.entites.Pessoa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaClienteMapper {

    public Pessoa convertDtoEmEntity(Permissao permissaoCliente, Cidade cidade, PessoaClienteDtoRequest newObj) {

        return Pessoa.builder()
                .id(null)
                .nome(newObj.getNome())
                .cpf(newObj.getCpf())
                .email(newObj.getEmail())
                .endereco(newObj.getEndereco())
                .cep(newObj.getCep())
                .cidade(cidade)
                .permissao(permissaoCliente)
                .build();
    }

    public Pessoa convertDtoEmEntityUpdate(Cidade cidade, PessoaClienteDtoRequest newObj, Pessoa obj) {

        return Pessoa.builder()
                .id(obj.getId())
                .nome(newObj.getNome() != null ? newObj.getNome() : obj.getNome())
                .cpf(newObj.getCpf() != null ? newObj.getCpf() : obj.getCpf())
                .email(newObj.getEmail() != null ? newObj.getEmail() : obj.getEmail())
                .senha(newObj.getSenha() != null ? newObj.getSenha() : obj.getSenha())
                .endereco(newObj.getEndereco() != null ? newObj.getEndereco() : obj.getEndereco())
                .cep(newObj.getCep() != null ? newObj.getCep() : obj.getCep())
                .cidade(cidade != null ? cidade : obj.getCidade())
                .permissao(obj.getPermissao())
                .build();
    }

    //converte minha lista de entidades em uma lista de dto
    public List<PessoaClienteDtoGet> conversor(List<Pessoa> listClientes) {

        List<PessoaClienteDtoGet> clientesDto = listClientes.stream().map(cliente -> new PessoaClienteDtoGet(cliente)).collect(Collectors.toList());

        return clientesDto;
    }
}

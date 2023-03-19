package com.dev.LojaVirtual.mapper;


import com.dev.LojaVirtual.entites.Cidade;
import com.dev.LojaVirtual.entites.Permissao;
import com.dev.LojaVirtual.entites.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public Pessoa convertDtoEmEntity(Permissao permissao,Cidade cidade, Pessoa newObj) {

        return Pessoa.builder()
                .id(null)
                .nome(newObj.getNome())
                .cpf(newObj.getCpf())
                .email(newObj.getEmail())
                .senha(newObj.getSenha())
                .endereco(newObj.getEndereco())
                .cep(newObj.getCep())
                .cidade(cidade)
                .permissao(permissao)
                .build();

    }
}

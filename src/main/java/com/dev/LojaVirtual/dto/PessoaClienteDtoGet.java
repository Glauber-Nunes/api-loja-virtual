package com.dev.LojaVirtual.dto;


import com.dev.LojaVirtual.entites.Cidade;
import com.dev.LojaVirtual.entites.Permissao;
import com.dev.LojaVirtual.entites.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaClienteDtoGet {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private Cidade cidade;
    private Permissao permissao;

    public PessoaClienteDtoGet(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.email = pessoa.getEmail();
        this.endereco = pessoa.getEndereco();
        this.cep = pessoa.getCpf();
        this.cidade = pessoa.getCidade();
        this.permissao = pessoa.getPermissao();
    }
}

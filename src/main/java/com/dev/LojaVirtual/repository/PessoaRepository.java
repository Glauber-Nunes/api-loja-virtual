package com.dev.LojaVirtual.repository;

import com.dev.LojaVirtual.entites.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByEmail(String email);
    Pessoa findByEmailAndCodigoRecuperacaoSenha(String email,String codigoRecuperacaoSenha);
    @Query("select p from Pessoa p where lower(p.nome) like lower(concat('%', ?1,'%'))")
    List<Pessoa> findByNome(String nome);
}
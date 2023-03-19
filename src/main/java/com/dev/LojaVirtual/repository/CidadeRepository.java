package com.dev.LojaVirtual.repository;

import com.dev.LojaVirtual.entites.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {
    @Query("select c from Cidade c where lower(c.nome) like lower(concat('%', ?1,'%'))")
    public Cidade findByNome(String nome);
}

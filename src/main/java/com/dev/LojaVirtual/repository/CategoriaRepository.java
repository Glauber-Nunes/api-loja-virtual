package com.dev.LojaVirtual.repository;

import com.dev.LojaVirtual.dto.CategoriaDtoPath;
import com.dev.LojaVirtual.entites.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

     @Query("select c from Categoria c where lower(c.nome) like lower(concat('%', ?1,'%'))")
     Categoria findByNome(String nome);
}
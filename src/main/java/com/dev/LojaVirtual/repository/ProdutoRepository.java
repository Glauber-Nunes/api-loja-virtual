package com.dev.LojaVirtual.repository;

import com.dev.LojaVirtual.entites.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}

package com.dev.LojaVirtual.repository;

import com.dev.LojaVirtual.entites.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
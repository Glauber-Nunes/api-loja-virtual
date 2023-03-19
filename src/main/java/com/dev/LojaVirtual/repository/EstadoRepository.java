package com.dev.LojaVirtual.repository;

import com.dev.LojaVirtual.entites.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
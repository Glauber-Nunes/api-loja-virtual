package com.dev.LojaVirtual.repository;

import com.dev.LojaVirtual.entites.ImagensProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagensRepository extends JpaRepository<ImagensProduto, Long> {
}
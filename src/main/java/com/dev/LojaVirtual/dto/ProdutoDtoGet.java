package com.dev.LojaVirtual.dto;

import com.dev.LojaVirtual.entites.Categoria;
import com.dev.LojaVirtual.entites.ImagensProduto;
import com.dev.LojaVirtual.entites.Marca;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDtoGet {
    private Long id;
    private String descricaoCurta;
    private String descricaoDetalhada;
    private Double valorCusto;
    private Double valorVenda;
    private Instant dataCriacao;
    private Instant dataAtualizacao;
    private Marca marca;
    private Categoria categoria;
    private ImagensProduto imagensProduto;
}

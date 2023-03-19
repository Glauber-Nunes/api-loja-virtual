package com.dev.LojaVirtual.dto;

import com.dev.LojaVirtual.entites.Categoria;
import com.dev.LojaVirtual.entites.Marca;
import com.dev.LojaVirtual.entites.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDtoBody {

    private Long id;
    private String descricaoCurta;
    private String descricaoDetalhada;
    private Double valorCusto;
    private Double valorVenda;
    private Instant dataCriacao;
    private Instant dataAtualizacao;
    private Marca marca;
    private Categoria categoria;

}

package com.dev.LojaVirtual.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImagensProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeUrl;
    @Temporal(TemporalType.TIMESTAMP)
    private Instant dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Instant dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}

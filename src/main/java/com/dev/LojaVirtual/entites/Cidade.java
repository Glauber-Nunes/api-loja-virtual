package com.dev.LojaVirtual.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Instant dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Instant dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estados;
}

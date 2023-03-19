package com.dev.LojaVirtual.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Instant dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Instant dataAtualizacao;
    @OneToMany(mappedBy = "marca",orphanRemoval = true,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Produto> produtoList = new ArrayList<>();

}

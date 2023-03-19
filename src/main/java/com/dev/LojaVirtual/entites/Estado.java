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
@Table(name = "estado")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @Column(unique = true)
    private String sigla;
    @Temporal(TemporalType.TIMESTAMP)
    private Instant dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Instant dataAtualizacao;
    @OneToMany(mappedBy = "estados")
    @JsonIgnore
    private List<Cidade> cidades = new ArrayList<>();

}

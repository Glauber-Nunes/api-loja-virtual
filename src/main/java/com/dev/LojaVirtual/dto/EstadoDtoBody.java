package com.dev.LojaVirtual.dto;

import com.dev.LojaVirtual.entites.Cidade;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoDtoBody {
    private Long id;

    private String nome;
    private String sigla;
    private Instant dataCriacao;
    private Instant dataAtualizacao;
    private List<Cidade> cidades = new ArrayList<>();
}

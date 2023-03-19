package com.dev.LojaVirtual.dto;

import com.dev.LojaVirtual.entites.Marca;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDtoBody {
    private Long id;
    private String nome;
    private Instant dataCriacao;
    private Instant dataAtualizacao;

}

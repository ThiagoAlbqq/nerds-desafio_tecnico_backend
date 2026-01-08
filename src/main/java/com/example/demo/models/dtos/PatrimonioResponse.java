package com.example.demo.models.dtos;

import java.time.LocalDate;

public record PatrimonioResponse(
        Long id,
        String nome,
        String numeroSerie,
        String descricao,
        String tipo,
        LocalDate dataAquisicao
) {}
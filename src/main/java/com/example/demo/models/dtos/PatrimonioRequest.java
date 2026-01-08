package com.example.demo.models.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PatrimonioRequest(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O numero de serie é obrigatório")
        String numeroSerie,

        String descricao,
        String tipo,
        LocalDate dataAquisicao
) {
}
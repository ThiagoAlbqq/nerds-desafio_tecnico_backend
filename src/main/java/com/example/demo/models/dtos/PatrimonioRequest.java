package com.example.demo.models.dtos;

import jakarta.validation.constraints.NotBlank;

public record PatrimonioRequest(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O tombo é obrigatório")
        String tombo,

        String descricao,
        String categoria
) {
}
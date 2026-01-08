package com.example.demo.models.dtos;

public record PatrimonioResponse(
        Long id,
        String nome,
        String tombo,
        String descricao,
        String categoria
) {}
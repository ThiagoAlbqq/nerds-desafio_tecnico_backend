package com.example.demo.models.mappers;

import com.example.demo.models.dtos.PatrimonioRequest;
import com.example.demo.models.dtos.PatrimonioResponse;
import com.example.demo.models.entity.PatrimonioEntity;
import org.springframework.stereotype.Component;

@Component
public class PatrimonioMapper {

    public PatrimonioResponse toResponse(PatrimonioEntity entity) {
        return new PatrimonioResponse(
                entity.getId(),
                entity.getNome(),
                entity.getNumeroSerie(),
                entity.getDescricao(),
                entity.getTipo(),
                entity.getDataAquisicao()
        );
    }

    public PatrimonioEntity toEntity(PatrimonioRequest request) {
        PatrimonioEntity entity = new PatrimonioEntity();
        entity.setNome(request.nome());
        entity.setNumeroSerie(request.numeroSerie());
        entity.setDescricao(request.descricao());
        entity.setTipo(request.tipo());
        entity.setDataAquisicao(request.dataAquisicao());
        return entity;
    }
}
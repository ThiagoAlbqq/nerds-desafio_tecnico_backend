package com.example.demo.controller;

import com.example.demo.models.dtos.PatrimonioRequest;
import com.example.demo.models.dtos.PatrimonioResponse;
import com.example.demo.models.dtos.PatrimonioUpdateRequest;
import com.example.demo.models.mappers.PatrimonioMapper;
import com.example.demo.services.PatrimonioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/patrimonio")
@RequiredArgsConstructor
public class PatrimonioController {

    private final PatrimonioService service;
    private final PatrimonioMapper mapper;

    @GetMapping
    public ResponseEntity<List<PatrimonioResponse>> listar() {
        var lista = service.listarTodos().stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<PatrimonioResponse> criar(@RequestBody @Valid PatrimonioRequest request,
                                                    UriComponentsBuilder uriBuilder) {
        var entidade = mapper.toEntity(request);
        var salvo = service.criar(entidade);

        URI uri = uriBuilder.path("/api/patrimonio/{id}").buildAndExpand(salvo.getId()).toUri();
        return ResponseEntity.created(uri).body(mapper.toResponse(salvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatrimonioResponse> buscar(@PathVariable Long id) {
        var entidade = service.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponse(entidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatrimonioResponse> atualizar(@PathVariable Long id, @RequestBody PatrimonioUpdateRequest request) {
        var entidadeDados = mapper.toUpdateEntity(request);
        var atualizado = service.atualizar(id, entidadeDados);
        return ResponseEntity.ok(mapper.toResponse(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
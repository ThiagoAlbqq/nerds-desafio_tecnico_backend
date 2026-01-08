package com.example.demo.services;

import com.example.demo.controller.exceptions.BusinessException;
import com.example.demo.models.entity.PatrimonioEntity;
import com.example.demo.repostory.PatrimonioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatrimonioService {

    private final PatrimonioRepository repository;

    public List<PatrimonioEntity> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public PatrimonioEntity criar(PatrimonioEntity entity) {
        if (repository.findByNumeroSerie(entity.getNumeroSerie()).isPresent()) {
            throw new BusinessException("Já existe um equipamento cadastrado com o número de série: " + entity.getNumeroSerie());
        }
        return repository.save(entity);
    }

    public PatrimonioEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patrimônio não encontrado com ID: " + id));
    }

    @Transactional
    public PatrimonioEntity atualizar(Long id, PatrimonioEntity novosDados) {
        PatrimonioEntity existente = buscarPorId(id);

        if (!existente.getNumeroSerie().equals(novosDados.getNumeroSerie()) &&
                repository.findByNumeroSerie(novosDados.getNumeroSerie()).isPresent()) {
            throw new BusinessException("Não é possível atualizar: O novo número de série já está em uso.");
        }

        existente.setNome(novosDados.getNome());
        existente.setDescricao(novosDados.getDescricao());
        existente.setTipo(novosDados.getTipo());
        existente.setNumeroSerie(novosDados.getNumeroSerie());

        return repository.save(existente);
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Não é possível deletar: ID não encontrado.");
        }
        repository.deleteById(id);
    }
}
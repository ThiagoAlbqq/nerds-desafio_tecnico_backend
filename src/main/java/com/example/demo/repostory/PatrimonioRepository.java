package com.example.demo.repostory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entity.PatrimonioEntity;

@Repository
public interface PatrimonioRepository extends JpaRepository<PatrimonioEntity, Long> {
    Optional<PatrimonioEntity> findByTombo(String tombo);
}
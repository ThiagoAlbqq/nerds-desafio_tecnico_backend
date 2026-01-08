package com.example.demo.utils;

import com.example.demo.models.entity.PatrimonioEntity;
import com.example.demo.repostory.PatrimonioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DatabaseSeeder implements CommandLineRunner {

    private final PatrimonioRepository repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Verificando necessidade de seed de dados...");

        if (repository.count() == 0) {
            log.info("Banco vazio. Iniciando a criação dos 10 patrimônios padrão...");

            List<PatrimonioEntity> patrimonios = List.of(
                    criar("Notebook Acer Nitro V15", "UFC-NERDS-2026-001", "i5, RTX 4050", "Eletrônicos"),
                    criar("Monitor Dell 27\"", "UFC-NERDS-2026-002", "4K Profissional", "Eletrônicos"),
                    criar("Cadeira DT3", "UFC-NERDS-2026-003", "Ergonômica Preta", "Mobiliário"),
                    criar("Teclado Keychron K2", "UFC-NERDS-2026-004", "Mecânico Wireless", "Periféricos"),
                    criar("Mouse Logitech MX Master", "UFC-NERDS-2026-005", "Mouse Produtividade", "Periféricos"),
                    criar("Servidor Dell PowerEdge", "UFC-NERDS-2026-006", "Servidor de Dados", "Infraestrutura"),
                    criar("Switch Cisco 24 Portas", "UFC-NERDS-2026-007", "Gerenciável L3", "Infraestrutura"),
                    criar("Tablet iPad Air", "UFC-NERDS-2026-008", "M1 256GB", "Eletrônicos"),
                    criar("Impressora HP Laser", "UFC-NERDS-2026-009", "Multifuncional", "Escritório"),
                    criar("Ar Condicionado Split", "UFC-NERDS-2026-010", "12000 BTUs Lab", "Mobiliário")
            );

            repository.saveAll(patrimonios);
            log.info("Seed concluída com sucesso! 10 itens adicionados.");
        } else {
            log.info("O banco já possui dados. Seed ignorada.");
        }
    }

    private PatrimonioEntity criar(String nome, String tombo, String desc, String cat) {
        PatrimonioEntity p = new PatrimonioEntity();
        p.setNome(nome);
        p.setTombo(tombo);
        p.setDescricao(desc);
        p.setCategoria(cat);
        return p;
    }
}
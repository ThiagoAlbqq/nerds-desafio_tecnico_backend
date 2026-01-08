# DESAFIO TÉCNICO NERDS 2026 - CONTROLE DE PATRIMÔNIO

## 🚀 Tecnologias Utilizadas

* **Java 21**: Versão LTS mais recente para maior desempenho.
* **Spring Boot 3.2.1**: Framework base para a aplicação.
* **Spring Data JPA**: Para persistência e manipulação de dados.
* **H2 Database**: Banco de dados em memória para agilizar os testes e avaliação.
* **Jakarta Validation**: Para garantir a integridade dos dados de entrada.
* **Lombok**: Para redução de código boilerplate.
* **Maven**: Gerenciador de dependências e build.

## 📁 Estrutura do Projeto (Arquitetura)

O projeto segue os princípios de Responsabilidade Única (SRP) e Clean Code, organizado nos seguintes pacotes:

* `controller`: Endpoints da API e manipulação de requisições HTTP.
* `services`: Camada de lógica de negócio e regras do sistema.
* `repository`: Interfaces de acesso ao banco de dados.
* `models.entity`: Entidades JPA que representam as tabelas do banco.
* `models.dtos`: Java Records para transferência de dados segura (Request/Response).
* `models.mappers`: Conversão entre Entidades e DTOs.
* `controller.exceptions`: Tratamento global de erros e padronização de respostas de falha.
* `utils`: Configurações de carga inicial de dados (Seeder).

## 🛠️ Como Rodar o Projeto

1. **Pré-requisitos**: Ter o JDK 21 e o Maven instalados.
2. **Clonar o repositório**:
```bash
git clone https://github.com/ThiagoAlbqq/nerds-desafio_tecnico_backend.git

```


3. **Executar a aplicação**:
   Navegue até a pasta raiz do projeto e execute:
```bash
mvn spring-boot:run

```


4. **Acessar a API**: A aplicação estará rodando em `http://localhost:8080`.
5. **Console do Banco (H2)**: Pode ser acessado em `http://localhost:8080/h2-console`.
* JDBC URL: `jdbc:h2:mem:patrimoniodb`
* User: `sa`
* Password: (vazio)



## 📌 Endpoints da API


| Método | Endpoint | Descrição |
| --- | --- | --- |
| GET | `/api/patrimonio` | Lista todos os equipamentos cadastrados. |
| POST | `/api/patrimonio` | Cadastra um novo equipamento. |
| GET | `/api/patrimonio/{id}` | Busca os detalhes de um equipamento por ID. |
| PUT | `/api/patrimonio/{id}` | Atualiza os dados de um equipamento existente. |
| DELETE | `/api/patrimonio/{id}` | Remove um equipamento do sistema. |

## 📝 Exemplo de JSON para Cadastro (POST)
```json
{
  "nome": "Notebook Acer Nitro",
  "tipo": "Eletrônico",
  "numeroSerie": "SN-NERDS-2026",
  "descricao": "i5, 16GB RAM, RTX 4050",
  "dataAquisicao": "2026-01-08"
}
```

## ⚖️ Regras de Negócio e Diferenciais

1. **Unicidade de Número de Série**: O sistema possui uma validação na camada de serviço que impede o cadastro de dois equipamentos com o mesmo número de série, retornando um erro `409 Conflict`.
2. **Data Seeder**: Ao iniciar, a aplicação popula automaticamente o banco de dados com 10 itens iniciais para facilitar a avaliação, caso o banco esteja vazio.
3. **Tratamento de Exceções**: Implementado um `GlobalExceptionHandler` que captura erros de validação e regras de negócio, retornando mensagens claras e estruturadas em JSON.
4. **Uso de Records**: Implementação moderna utilizando Java Records para DTOs, garantindo imutabilidade e clareza.
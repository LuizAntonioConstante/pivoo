[English](README.md) | [**Português (Brasil)**](README.pt-BR.md)

# Soccer Project

Um sistema de gestão para estabelecimentos que alugam campos de futebol, ainda em desenvolvimento.

A ideia do Soccer Project é simples: facilitar o controle de clientes, reservas de horários e movimentações financeiras de um campo de futebol. Estou construindo o sistema aos poucos, começando por uma API em Java e um banco de dados PostgreSQL. Meu objetivo é que, com o tempo, ele se torne uma ferramenta útil para a rotina de um estabelecimento, e não apenas um projeto de demonstração.

Este também é um projeto pessoal em que estou aprendendo Java, programação orientada a objetos, Spring Boot e desenvolvimento backend na prática.

> **Status:** Em desenvolvimento. A API ainda está evoluindo, e algumas funcionalidades descritas aqui fazem parte dos próximos passos.

## O que estou desenvolvendo

Neste momento, meu foco está no backend e na estrutura necessária para o cadastro de clientes e o controle de horários.

- **Clientes:** cadastrar, listar e consultar um cliente pelo ID.
- **Horários e reservas:** estruturar os horários disponíveis, os agendamentos e seus vínculos com os clientes.
- **Financeiro:** preparar a base para o controle de cobranças e pagamentos.

As rotas de clientes com as quais estou trabalhando são:

| Método | Rota | Função |
| --- | --- | --- |
| `POST` | `/api/client/save` | Cadastrar cliente |
| `GET` | `/api/client/list` | Listar clientes |
| `GET` | `/api/client/get/{id}` | Consultar cliente pelo ID |

Essas rotas ainda podem mudar conforme eu melhorar a API. Atualização e exclusão de clientes, assim como um tratamento de erros mais completo, ainda estão entre os próximos passos.

## Onde quero chegar

A ideia é ir além do agendamento dos campos. Pretendo evoluir o sistema para:

- Controlar disponibilidade, reservas, cancelamentos e valores dos horários.
- Registrar pagamentos e contas a pagar e receber.
- Adicionar uma frente de caixa (PDV) para a conveniência do estabelecimento.
- Futuramente, controlar produtos, estoque e relatórios de vendas.
- Permitir o uso tanto no computador quanto no celular.
- Estudar uma forma de trabalhar offline e sincronizar os dados depois.

**O funcionamento offline ainda é um objetivo, não uma funcionalidade pronta.** Para isso, será necessário planejar o armazenamento local e a sincronização dos dados.

## Tecnologias

- **Java 26** — versão declarada atualmente no `pom.xml`.
- **Spring Boot 4.1.2** — framework da aplicação.
- **Spring Web MVC** — endpoints HTTP.
- **Spring Data JPA / Hibernate** — persistência e mapeamento das entidades.
- **PostgreSQL** — banco de dados relacional.
- **Maven** — gerenciamento de dependências e build.
- **Lombok** — redução de código repetitivo.
- **Docker / Docker Compose** — configuração de contêineres para a aplicação e o banco.

A aplicação segue uma organização em camadas: **Controller → Service → Repository → Banco de dados**, além de utilizar DTOs e mappers para organizar os dados entre elas.

## Como executar

### Opção 1 — Docker Compose

Você precisa ter o Docker com suporte ao Compose instalado.

1. Clone o repositório:

   ```bash
   git clone https://github.com/LuizAntonioConstante/soccer_project.git
   cd soccer_project
   ```

2. Crie um arquivo `.env` na raiz do projeto:

   ```dotenv
   DB_NAME=soccer
   DB_USERNAME=soccer_app
   DB_PASSWORD=substitua_por_uma_senha_forte
   ```

3. Inicie os contêineres:

   ```bash
   docker compose up --build
   ```

No `compose.yml`, a aplicação utiliza a **porta 8080** e o PostgreSQL fica disponível na **porta 5433 do computador** (porta 5432 dentro do contêiner).

> Não envie o arquivo `.env` para o Git. A configuração com Docker já faz parte do projeto, mas pode mudar durante o desenvolvimento.

### Opção 2 — Java e PostgreSQL

Você precisa de um JDK compatível com a versão configurada no projeto (**26**, atualmente) e de uma instância do PostgreSQL em execução.

1. Crie um banco chamado `soccer` no PostgreSQL e um usuário com acesso a ele.
2. Configure as variáveis de ambiente usadas pela aplicação:

   ```dotenv
   DB_URL=jdbc:postgresql://localhost:5432/soccer
   DB_USERNAME=soccer_app
   DB_PASSWORD=sua_senha_do_banco
   ```

3. Inicie a aplicação com o Maven Wrapper:

   **Linux/macOS:**
   ```bash
   ./mvnw spring-boot:run
   ```

   **Windows:**
   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

Por padrão, a API utiliza `http://localhost:8080`. A configuração atual do JPA usa `ddl-auto=update` no desenvolvimento. Assim, o Hibernate pode criar ou atualizar as tabelas **depois que o banco de dados já existir**.

### Teste rápido

Com a aplicação iniciada e conectada ao banco, acesse:

```http
GET http://localhost:8080/api/client/list
```

Se ainda não houver clientes cadastrados, é normal receber uma lista vazia (`[]`).

## Sobre o projeto

Esse projeto surgiu da vontade de aprender Java na prática e, ao mesmo tempo, ajudar um amigo que está começando um negócio de aluguel de campos de futebol.

A ideia é desenvolver um sistema que facilite a rotina do estabelecimento, começando pelo cadastro de clientes e gerenciamento de reservas, com a possibilidade de adicionar novas funcionalidades conforme as necessidades do negócio.

Estou desenvolvendo o Soccer Project aos poucos, aproveitando cada etapa para aprender mais sobre as tecnologias utilizadas e entender melhor as decisões por trás do código. Tanto o sistema quanto sua documentação vão evoluir ao longo do projeto.

---

Desenvolvido por [Luiz Antônio Constante](https://github.com/LuizAntonioConstante).

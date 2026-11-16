<div align="center">

<!-- Coloque o logo em docs/images/logo.png e remova os comentários da linha abaixo.
<img src="docs/images/logo.png" alt="pivoo. logo" width="250">
-->

# pivoo.

<a href="https://github.com/LuizAntonioConstante/pivoo/tags"><img src="https://img.shields.io/github/v/tag/LuizAntonioConstante/pivoo?style=for-the-badge&label=Latest%20Tag" alt="Latest tag"></a>
<img src="https://img.shields.io/badge/Java-26-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 26">
<a href="README.md"><img src="https://img.shields.io/badge/English-README-blue?style=for-the-badge" alt="English README"></a>
<a href="README.pt-BR.md"><img src="https://img.shields.io/badge/Portugu%C3%AAs-BR-green?style=for-the-badge" alt="README em português"></a>

</div>

O **pivoo.** é um sistema de gestão para estabelecimentos esportivos, desenvolvido para facilitar a organização das operações do dia a dia.

Inspirado nas necessidades reais de um negócio de aluguel de campo de futebol, o projeto busca reunir em um só lugar o gerenciamento de clientes, reservas, horários recorrentes e contas a pagar e receber.

Desenvolvido com **Java, Spring Boot e PostgreSQL**, o pivoo. também é um projeto de aprendizado prático em desenvolvimento de software, que evolui conforme as necessidades do negócio.

> **Status:** Em desenvolvimento.

## Tecnologias

- Java e Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Docker e Docker Compose

## Como executar

### Opção 1 — Docker Compose (recomendada)

**Pré-requisitos:** Git e Docker com suporte ao Compose.

1. Clone o repositório:

   ```bash
   git clone https://github.com/LuizAntonioConstante/pivoo.git
   cd pivoo
   ```

2. Crie um arquivo `.env` na raiz do projeto:

   ```dotenv
   DB_NAME=soccer
   DB_USERNAME=soccer_app
   DB_PASSWORD=substitua_por_uma_senha_forte
   ```

3. Construa e inicie os containers:

   ```bash
   docker compose up --build -d
   ```

A API estará disponível em `http://localhost:8080`. O PostgreSQL utiliza a porta `5433` no computador (`5432` dentro do Docker).

Comandos úteis:

```bash
docker compose logs -f app
docker compose ps
docker compose down
```

> Mantenha o `.env` fora do Git. Evite `docker compose down -v`, a menos que queira excluir o volume de dados do banco.

### Opção 2 — Java e PostgreSQL local

**Pré-requisitos:** Git, PostgreSQL e um JDK compatível com a versão indicada no `pom.xml` (atualmente Java 26).

1. Clone o repositório:

   ```bash
   git clone https://github.com/LuizAntonioConstante/pivoo.git
   cd pivoo
   ```

2. Crie um banco PostgreSQL chamado `soccer` e um usuário com permissão de acesso.

3. Configure as variáveis de ambiente no terminal ou na IDE (o Spring Boot **não** carrega automaticamente um `.env` local):

   ```dotenv
   DB_URL=jdbc:postgresql://localhost:5432/soccer
   DB_USERNAME=soccer_app
   DB_PASSWORD=sua_senha_do_banco
   ```

4. Inicie a aplicação usando o Maven Wrapper:

   Linux/macOS:

   ```bash
   ./mvnw spring-boot:run
   ```

   Windows PowerShell:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

A API estará disponível em `http://localhost:8080`.

## Imagens

Capturas de tela e elementos visuais podem ser adicionados à pasta `docs/images/` conforme o projeto evoluir.

<!-- Exemplo: remova os comentários depois de adicionar a imagem.
![Captura de tela da aplicação](docs/images/dashboard.png)
-->

## Sobre o projeto

O pivoo. surgiu como uma maneira de aprender Java e desenvolvimento backend enquanto construo uma solução útil para um negócio real. A proposta é evoluir para uma ferramenta prática e confiável de gestão esportiva.

Desenvolvido por [Luiz Antônio Constante](https://github.com/LuizAntonioConstante).

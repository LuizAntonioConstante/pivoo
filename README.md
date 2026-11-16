<div align="center">


<img src="docs/images/logo.png" alt="pivoo. logo" width="250">

# pivoo.

<a href="https://github.com/LuizAntonioConstante/pivoo/tags"><img src="https://img.shields.io/github/v/tag/LuizAntonioConstante/pivoo?style=for-the-badge&label=Latest%20Tag" alt="Latest tag"></a>
<img src="https://img.shields.io/badge/Java-26-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 26">
<a href="README.md"><img src="https://img.shields.io/badge/English-README-blue?style=for-the-badge" alt="English README"></a>
<a href="README.pt-BR.md"><img src="https://img.shields.io/badge/Portugu%C3%AAs-BR-green?style=for-the-badge" alt="README em português"></a>

</div>

**pivoo.** is a management system for sports facilities, focused on making everyday operations easier to organize.

Inspired by the needs of a real soccer field rental business, the project aims to bring customer management, field bookings, recurring schedules, and accounts payable and receivable into one place.

Built with **Java, Spring Boot, and PostgreSQL**, pivoo. is also a hands-on software development project, evolving alongside the business needs.

> **Status:** Under development.

## Technologies

- Java and Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Docker and Docker Compose

## Getting started

### Option 1 — Docker Compose (recommended)

**Requirements:** Git and Docker with Compose support.

1. Clone the repository:

   ```bash
   git clone https://github.com/LuizAntonioConstante/pivoo.git
   cd pivoo
   ```

2. Create a `.env` file in the project root:

   ```dotenv
   DB_NAME=soccer
   DB_USERNAME=soccer_app
   DB_PASSWORD=replace_with_a_strong_password
   ```

3. Build and start the containers:

   ```bash
   docker compose up --build -d
   ```

The API is available at `http://localhost:8080`. PostgreSQL is mapped to port `5433` on the host (`5432` inside Docker).

Useful commands:

```bash
docker compose logs -f app
docker compose ps
docker compose down
```

> Keep `.env` private; do not commit credentials to Git. Avoid `docker compose down -v` unless you intend to delete the database volume.

### Option 2 — Run with Java and PostgreSQL

**Requirements:** Git, PostgreSQL, and a JDK matching the version declared in `pom.xml` (currently Java 26).

1. Clone the repository:

   ```bash
   git clone https://github.com/LuizAntonioConstante/pivoo.git
   cd pivoo
   ```

2. Create a PostgreSQL database named `soccer` and a user with access to it.

3. Set these environment variables in your terminal or IDE (a local `.env` file is **not** automatically loaded by Spring Boot):

   ```dotenv
   DB_URL=jdbc:postgresql://localhost:5432/soccer
   DB_USERNAME=soccer_app
   DB_PASSWORD=your_database_password
   ```

4. Start the application using the Maven Wrapper:

   Linux/macOS:

   ```bash
   ./mvnw spring-boot:run
   ```

   Windows PowerShell:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

The API is available at `http://localhost:8080`.

## Images

Screenshots and visual assets can be added to `docs/images/` as the project evolves.

<!-- Example: uncomment after adding a screenshot.
![Application screenshot](docs/images/dashboard.png)
-->

## About

pivoo. began as a way to learn Java and backend development while creating something useful for a real business. Its goal is to grow into a practical, reliable tool for sports facility management.

Developed by [Luiz Antônio Constante](https://github.com/LuizAntonioConstante).

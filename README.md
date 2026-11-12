[**English**](README.md) | [Português (Brasil)](README.pt-BR.md)

# Soccer Project

A work-in-progress management system for soccer field rental businesses.

The idea behind Soccer Project is simple: make it easier to keep track of customers, field bookings and the money coming in and out of a soccer facility. I'm building it step by step, starting with a Java backend and a PostgreSQL database. Over time, I want to turn it into a practical tool that can be used in day-to-day operations, not just a demo application.

This is also a personal project where I'm learning Java, object-oriented programming, Spring Boot and backend development by putting them into practice.

> **Status:** Under active development. The API is still evolving, and some features described below are plans rather than finished functionality.

## What I'm working on

The current focus is the backend and the structure needed for customer management and field scheduling.

- **Customer management:** create customer records, list customers and find a customer by ID.
- **Scheduling domain:** model available time slots, bookings and their relationship with customers.
- **Financial domain:** lay the groundwork for tracking charges and payments.

The customer routes I'm currently working with are:

| Method | Route | Purpose |
| --- | --- | --- |
| `POST` | `/api/client/save` | Create a customer |
| `GET` | `/api/client/list` | List customers |
| `GET` | `/api/client/get/{id}` | Find a customer by ID |

These routes are still subject to change as I refine the API. Customer update and delete operations, as well as more complete error handling, are next steps—not features I consider finished yet.

## Where I want to take it

My longer-term goal is a system that can handle more than bookings:

- Manage field availability, reservations, cancellations and pricing.
- Track payments, accounts payable and receivable.
- Add a point-of-sale (POS) module for the facility's convenience store.
- Eventually support products, stock and sales reports.
- Make the system accessible from desktop and mobile devices.
- Explore offline operation and data synchronization.

**Offline support is a goal, not a current feature.** It will require additional work on local data storage and synchronization.

## Tech stack

- **Java 26** — version currently declared in `pom.xml`.
- **Spring Boot 4.1.2** — application framework.
- **Spring Web MVC** — HTTP endpoints.
- **Spring Data JPA / Hibernate** — persistence and entity mapping.
- **PostgreSQL** — relational database.
- **Maven** — build and dependency management.
- **Lombok** — less repetitive Java code.
- **Docker / Docker Compose** — container configuration for the app and database.

The project follows a layered approach: **Controller → Service → Repository → Database**, with DTOs and mappers used to organize data between layers.

## Running locally

### Option 1 — Docker Compose

You'll need Docker with Compose support.

1. Clone the repository:

   ```bash
   git clone https://github.com/LuizAntonioConstante/soccer_project.git
   cd soccer_project
   ```

2. Create a `.env` file in the project root:

   ```dotenv
   DB_NAME=soccer
   DB_USERNAME=soccer_app
   DB_PASSWORD=replace_with_a_strong_password
   ```

3. Build and start the containers:

   ```bash
   docker compose up --build
   ```

The Compose configuration maps the application to **port 8080** and PostgreSQL to **port 5433 on the host** (port 5432 inside the container).

> Keep `.env` out of Git. Docker Compose support is part of the project configuration, but the setup may change while development continues.

### Option 2 — Java and PostgreSQL

You'll need a JDK compatible with the project's configured Java version (**26** at the time of writing) and a running PostgreSQL instance.

1. Create a PostgreSQL database named `soccer` and a database user with access to it.
2. Set the environment variables used by the application:

   ```dotenv
   DB_URL=jdbc:postgresql://localhost:5432/soccer
   DB_USERNAME=soccer_app
   DB_PASSWORD=your_database_password
   ```

3. Start the application using the Maven Wrapper:

   **Linux/macOS:**
   ```bash
   ./mvnw spring-boot:run
   ```

   **Windows:**
   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

By default, the API runs on `http://localhost:8080`. The current JPA configuration uses `ddl-auto=update` for development, so Hibernate can create or update tables **after the database itself already exists**.

### Quick test

Once the app is running and connected to the database, try:

```http
GET http://localhost:8080/api/client/list
```

An empty response (`[]`) is expected if no customers have been registered yet.

## About this project

This project started from my desire to learn Java through hands-on experience while helping a friend who is starting a soccer field rental business.

The idea is to build a system that makes day-to-day operations easier, starting with customer management and field reservations, with the possibility of adding new features as the business needs evolve.

I'm developing Soccer Project step by step, using each stage to learn more about the technologies involved and better understand the decisions behind the code. Both the system and its documentation will continue to evolve as the project progresses.

---

Developed by [Luiz Antônio Constante](https://github.com/LuizAntonioConstante).

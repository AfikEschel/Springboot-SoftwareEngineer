# Software Engineers API (Spring Boot + Postgres)

A simple REST API to manage software engineers. Built to demonstrate Java, Spring Boot, JPA, and PostgreSQL skills.

## Features
- CRUD endpoints for SoftwareEngineer (pagination & sorting ready)
- JPA/Hibernate with PostgreSQL
- Validation & basic error handling
- Swagger UI 
- Actuator health endpoint 
- Dockerfile for containerized runtime

## Tech
- Java 21, Spring Boot
- JPA/Hibernate, PostgreSQL
- Maven
- Docker

## Quickstart (Local)
1. **Postgres**: Run locally or via Docker:
   ```bash
   docker run --name pg -e POSTGRES_USER=ae -e POSTGRES_PASSWORD=ae \
      -e POSTGRES_DB=ae1 -p 5432:5432 -d postgres:16

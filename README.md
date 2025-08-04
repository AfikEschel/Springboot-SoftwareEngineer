# Software Engineers API (Spring Boot + PostgreSQL)

A small REST API to manage software engineers.  
Built to demonstrate Java, Spring Boot, JPA/Hibernate, PostgreSQL, Docker, and testing with JUnit/Mockito.

## Features
- CRUD endpoints for `SoftwareEngineer`
- Spring Data JPA with PostgreSQL
- Basic service-layer unit tests (JUnit 5 + Mockito)
- Swagger / OpenAPI UI
- Actuator health endpoint
- Dockerfile for containerized runtime
- `requests.http` file with ready-to-run API calls

## Tech Stack
- Java 21 · Spring Boot
- Spring Web · Spring Data JPA
- PostgreSQL
- Maven
- Docker

---

## Quickstart

### 1) Start PostgreSQL (Docker)
```
docker run --name pg \
  -e POSTGRES_USER=ae \
  -e POSTGRES_PASSWORD=ae \
  -e POSTGRES_DB=ae1 \
  -p 5432:5432 \
  -d postgres:16
```

### 2) Configure the app
Create or edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5432/ae1}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:ae}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:ae}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false
```

### 3) Run the app
```bash
# Maven
mvn spring-boot:run

# Or build & run the jar
mvn package
java -jar target/*.jar
```

### 4) Try the API
- **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **Health:** [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)

You can use the included `requests.http` file (for IntelliJ/JetBrains HTTP Client)  
or test with `curl`:

```bash
curl http://localhost:8080/api/v1/software-engineer
``` 


## Build & Run with Docker
```bash 
### Build image
docker build -t se-api:latest .

### Run container (connects to Postgres running on the host)
docker run -p 8080:8080 \
-e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/ae1 \
-e SPRING_DATASOURCE_USERNAME=ae \
-e SPRING_DATASOURCE_PASSWORD=ae \
se-api:latest
``` 
## API Endpoints
```bash
GET    /api/v1/software-engineer
GET    /api/v1/software-engineer/{id}
POST   /api/v1/software-engineer
PUT    /api/v1/software-engineer/{id}
DELETE /api/v1/software-engineer/{id}
```

## Testing

Run all test:
```bash
mvn test
```
- Unit tests cover the service layer using Mockito.
- Future improvements: controller slice tests (MockMvc) and integration tests (Testcontainers with PostgreSQL).
# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build and Development Commands

```bash
# Build project
./gradlew build

# Run tests
./gradlew test

# Run a single test
./gradlew test --tests "ClassName.methodName"

# Run application
./gradlew bootRun

# Clean (also removes QueryDSL generated sources in src/main/generated/)
./gradlew clean
```

## Configuration

- **Database**: MariaDB on `localhost:3306`, database `board`, user `root`
- **JPA**: `ddl-auto: create` (schema recreated on each startup); H2 runtime dependency available for testing
- **Spring Data REST**: Base path `/api`, HAL Explorer accessible at `/api` in browser
- **Thymeleaf**: Decoupled logic mode enabled (`thymeleaf3.decoupledLogic: true`)
- **Actuator**: All endpoints exposed

## Architecture

Single-module Spring Boot MVC application with server-side rendering via Thymeleaf.

**Layers:**
- **Domain entities** — JPA entities with Lombok
- **Repositories** — Spring Data JPA interfaces; custom query repositories use QueryDSL Q-classes generated in `src/main/generated/`; only `@RepositoryRestResource`-annotated repos are exposed via Spring Data REST
- **Controllers** — Spring MVC with Thymeleaf templates; Spring Security with Thymeleaf security dialect (`thymeleaf-extras-springsecurity6`)

**QueryDSL:**
- Q-classes auto-generated during compilation into `src/main/generated/`
- Cleaned by `./gradlew clean`
- Annotation processors: `querydsl-apt:jpa`, `jakarta.annotation-api`, `jakarta.persistence-api`

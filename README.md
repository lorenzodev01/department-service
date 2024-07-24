# Department Microservice

This is a Spring Boot microservice for managing departments within an organization. It includes endpoints for creating, retrieving, updating, and deleting department records, and is secured using JWT authentication.

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Features

- CRUD operations for departments
- JWT-based authentication and authorization
- Integration with other microservices via REST API
- Comprehensive unit and integration tests

## Architecture

The application follows a layered architecture:

- **Controller Layer**: Handles HTTP requests and responses.
- **Service Layer**: Contains business logic.
- **Repository Layer**: Interacts with the database.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17 or later
- Maven 3.6 or later
- PostgreSQL or another supported database
- Docker (optional, for containerization)

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/department-microservice.git
    cd department-microservice
    ```

2. Update the database configuration in `application.yml` or `application.properties`:
    ```yaml
    spring:
      datasource:
        url: jdbc:postgresql://localhost:5432/your_database
        username: your_username
        password: your_password
      jpa:
        hibernate:
          ddl-auto: update
        show-sql: true
    ```

3. Build the project using Maven:
    ```bash
    mvn clean install
    ```

## Running the Application

To run the application locally, use the following command:
```bash
mvn spring-boot:run

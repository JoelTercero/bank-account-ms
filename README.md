# Bank Account Microservice

Spring Boot REST API for managing bank accounts.

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok

## Endpoints

POST /accounts

GET /accounts

GET /accounts/{id}

PUT /accounts/{id}/block

## Running

./mvnw spring-boot:run

## H2 Console

http://localhost:8080/h2-console

jdbc:h2:mem:bankdb

username: sa

password:

## Postman

Import the collection located in:

postman/
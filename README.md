# Bank Account Management API

REST API developed with **Spring Boot** for managing bank accounts.

This project demonstrates the implementation of:

- Layered Architecture
- Spring Data JPA
- Bean Validation
- Global Exception Handling
- OpenAPI / Swagger
- Docker

---

## 🚀 Technologies

- Java 17
- Spring Boot 4.1
- Spring Data JPA
- H2 Database
- Spring Validation
- Lombok
- OpenAPI / Swagger
- Docker
- Maven

---

## 📁 Project Structure

```
src
├── controller
├── dto
├── entity
├── enums
├── exception
├── repository
├── service
│   └── impl
└── config
```

---

## 📌 REST Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/accounts` | Create a new bank account |
| GET | `/accounts` | Retrieve all accounts |
| GET | `/accounts/{id}` | Retrieve an account by ID |
| PUT | `/accounts/{id}/block` | Block an account |

---

## ▶️ Running the application

### Using Maven

```bash
./mvnw spring-boot:run
```

---

### Using Docker

Build the image

```bash
docker build -t bank-account-ms .
```

Run the container

```bash
docker run -p 8080:8080 bank-account-ms
```

---

## 📖 Swagger UI

After starting the application, open:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 💾 H2 Database

H2 Console:

```
http://localhost:8080/h2-console
```

Connection:

```
JDBC URL:
jdbc:h2:mem:bankdb

Username:
sa

Password:
(empty)
```

---

## 📮 Postman

Import the collection located in:

```
postman/bank-account-ms.postman_collection.json
```
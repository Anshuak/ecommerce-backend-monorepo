# 🛒 Ecommerce Backend – Monorepo

This repository contains a **scalable e-commerce backend system** built using **Spring Boot microservices**, maintained inside a **single monorepo** for easier development, testing, and local orchestration.

The project demonstrates **real-world backend architecture**, service separation, and core e-commerce workflows.

---

## 🏗️ Architecture

- Microservices-based backend
- RESTful APIs
- Database per service
- Centralized API Gateway
- Event-driven communication (where applicable)

```
Client → API Gateway → Microservices → Databases
```

---

## 🧩 Microservices

```
ecommerce-backend-monorepo/
│
├── api-gateway
├── auth-service
├── user-service
├── product-service
├── order-service
├── inventory-service
├── cart-service
├── payment-service
├── notification-service
└── docker-compose.yml
```

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Cloud Gateway
- Spring Security + JWT
- PostgreSQL
- Redis
- Apache Kafka
- Docker & Docker Compose
- Maven

---

## 🔐 Security

- JWT-based authentication
- Role-based authorization (USER / ADMIN)
- Stateless microservices
- API Gateway–level security

---

## 🔄 Core Order Flow

1. User places an order  
2. Inventory is reserved  
3. Payment is initiated  
4. On payment success:
   - Inventory is deducted
   - Order status is updated
   - Notification is sent

This ensures **eventual consistency** using asynchronous events.

---

## 🐳 Running Locally

```bash
docker-compose up
```

This command starts all microservices along with required infrastructure services.

---

## 🎯 Project Goals

- Understand real-world microservice design
- Implement core e-commerce workflows
- Practice scalable backend architecture
- Build an interview-ready backend portfolio

---

## 🚀 Future Improvements

- Kubernetes deployment
- Circuit breaker patterns (Resilience4j)
- Distributed tracing
- CI/CD pipeline
- Cloud deployment (AWS)

---

## 👤 Author

**Anshu Kailash**  
Backend Software Engineer | Java & Spring Boot

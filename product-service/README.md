# 📦 Product Service

The **Product Service** is responsible for managing the **catalog domain** of the e-commerce system.  
It handles **products and categories** and exposes APIs for browsing, filtering, and managing catalog data.

This service is designed as an **independent microservice** and does not depend on authentication, order, or inventory services at runtime.

---

## 🧩 Responsibilities

- Manage product categories
- Manage product details
- Support pagination, sorting, and filtering
- Expose read-only APIs for consumers
- Expose admin-only APIs for catalog management

---

## 🏗️ Domain Model

### Category
- id
- name
- description
- active
- createdAt
- updatedAt

### Product
- id
- name
- description
- price
- sku
- categoryId
- active
- createdAt
- updatedAt

---

## 🔌 API Endpoints

### Category APIs
| Method | Endpoint | Description |
|------|--------|-------------|
| POST | `/categories` | Create a new category (ADMIN) |
| GET | `/categories` | Get all categories |
| GET | `/categories/{id}` | Get category by ID |
| PUT | `/categories/{id}` | Update category (ADMIN) |

---

### Product APIs
| Method | Endpoint | Description |
|------|--------|-------------|
| POST | `/products` | Create a new product (ADMIN) |
| GET | `/products` | Get all products (paginated) |
| GET | `/products/{id}` | Get product by ID |
| GET | `/products/category/{categoryId}` | Get products by category |
| PUT | `/products/{id}` | Update product (ADMIN) |

---

## 🔐 Security

- Role-based access control
- Admin endpoints are protected
- Temporary role-based access using request headers during development
- JWT-based security will be integrated via API Gateway

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok
- Swagger / OpenAPI

---

## 🗂️ Package Structure

```
product-service
└── src/main/java/com/.../product
    ├── controller
    ├── service
    ├── repository
    ├── entity
    ├── dto
    ├── mapper
    ├── exception
    └── config
```

---

## 🗄️ Database Strategy

- Dedicated database for product-service
- Category and Product stored as separate tables
- No cross-service joins
- Indexed columns:
  - `category_id`
  - `sku`

---

## ▶️ Running Locally

```bash
./mvnw spring-boot:run
```

The service runs on its configured port (default: `8083`).

---

## 🎯 Design Principles

- Clean separation of concerns
- Lightweight controllers
- Service-layer business logic
- DTO-based API contracts
- Loose coupling with other services

---

## 🔮 Future Enhancements

- Redis caching for product listing
- Full-text search
- Inventory service integration
- Event publishing on catalog changes

---

## 👤 Author

**Anshu Kailash**  
Backend Software Engineer | Java & Spring Boot

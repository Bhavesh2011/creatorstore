# CreatorStore

CreatorStore is a Spring Boot REST API project for managing products and customer orders.

## Features

* Product CRUD Operations
* Order Creation
* Get All Orders
* Get Order By ID
* Stock Management
* Total Price Calculation

---

## Tech Stack

* Java 24
* Spring Boot 4
* Spring Data JPA
* Hibernate
* PostgreSQL
* Supabase
* Lombok
* Maven
* Swagger OpenAPI

---

## API Endpoints

### Product APIs

* `POST /api/products` → Create Product
* `GET /api/products` → Get All Products
* `GET /api/products/{id}` → Get Product By ID
* `PUT /api/products/{id}` → Update Product
* `DELETE /api/products/{id}` → Delete Product

### Order APIs

* `POST /api/orders` → Create Order
* `GET /api/orders` → Get All Orders
* `GET /api/orders/{id}` → Get Order By ID

---

## Concepts Used

* REST APIs
* CRUD Operations
* DTOs
* Entity Relationships
* Transaction Management
* Exception Handling
* PostgreSQL Integration

---



## Run Project

1. Configure PostgreSQL in `application.yaml`
2. Run `CreatorstoreApplication.java`


---

## Author

Bhavesh Gaikwad

# Event-Driven Order Management System (Spring Boot + Kafka)

## 📌 Overview
This project demonstrates a **real-world event-driven microservices architecture** built using **Java, Spring Boot, and Apache Kafka**.  
It is designed to showcase **backend engineering skills**  that including:

- Clean multi-module Maven setup
- Event-driven communication using Kafka
- Loose coupling via shared event contracts
- Scalable and production-ready design

---

## 🧱 Architecture

### 🔑 Key Architectural Decisions
- **No direct service-to-service calls**
- **Kafka used as the communication backbone**
- **Shared event schema via `common-events` module**
- **Centralized dependency management using Spring Boot BOM**

---

## 🛠 Tech Stack

- **Java**: 8 (upgrade path planned to 17/21)
- **Spring Boot**: 2.7.x
- **Apache Kafka**
- **Spring Data JPA**
- **H2 Database** (for local development)
- **Maven (Multi-module)**
- **Lombok**

---

## 📦 Modules Explained

### 1️⃣ common-events
- Pure Maven module (no Spring)
- Contains shared Kafka event contracts
- Example:
  - `OrderCreatedEvent`

> This module avoids tight coupling between microservices.

---

### 2️⃣ order-service
- Spring Boot microservice
- Responsibilities:
  - Create orders
  - Publish `OrderCreatedEvent` to Kafka
- Acts as **Kafka Producer**

---

### 3️⃣ inventory-service
- Spring Boot microservice
- Responsibilities:
  - Consume `OrderCreatedEvent`
  - Update inventory
- Acts as **Kafka Consumer**

---

## 🧠 Why Event-Driven?
- Better scalability
- Loose coupling
- Fault isolation
- Real-world microservices pattern used in production systems

---

## 🚀 How to Build & Run

### Prerequisites
- Java 8+
- Maven
- Kafka (local or Docker)

### Build all modules
```bash
mvn clean install

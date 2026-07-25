# Event-Driven Order Processing System with Apache Kafka

A distributed, event-driven microservices architecture built with **Java**, **Spring Boot**, and **Apache Kafka** to demonstrate real-time data streaming and asynchronous message processing.

---

## Architecture Overview

The system processes incoming orders asynchronously by decoupling the request ingestion from downstream business logic (notifications, analytics, inventory, etc.).

```markdown
```mermaid
graph TD
    A[Client / Postman] -->|HTTP POST /api/orders| B(Order Service <br> Spring Boot REST)
    B -->|Publish OrderEvent| C{Apache Kafka <br> Topic: orders-topic}
    C -->|Consume OrderEvent| D(Notification Service <br> Kafka Consumer)

    style C fill:#f9f,stroke:#333,stroke-width:2px
    style B fill:#bbf,stroke:#333,stroke-width:1px
    style D fill:#bbf,stroke:#333,stroke-width:1px

##  Tech Stack

* **Language:** Java 21+
* **Framework:** Spring Boot 3.4.x
* **Event Broker:** Apache Kafka (KRaft mode)
* **DevOps / Infrastructure:** Docker, Docker Compose
* **Serialization:** JSON (`JsonSerializer` / `JsonDeserializer`)
* **Build Tool:** Gradle

---

##  Key Features & Concepts Applied

* **Event-Driven Architecture (EDA):** Asynchronous communication between services using Kafka topics.
* **Producer-Consumer Pattern:** decoupled order creation and order consumption.
* **Schema & Serialization:** Strongly typed event structure (`OrderEvent`) mapped via Spring Kafka JSON serializers.
* **Zero Zookeeper Dependency:** Configured with Kafka in **KRaft** mode via Docker Compose.
* **Scalable Grouping:** Configured Consumer Groups (`order-notification-group`) ready for horizontal scaling.

---

##  Getting Started

### Prerequisites

* Java 21 or higher
* Docker & Docker Compose

### 1. Run Apache Kafka

Start local Kafka broker using Docker Compose:

```bash
docker-compose up -d

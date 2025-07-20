


# 🛍️ Full Stack E-Commerce Microservices Project

This is a full stack e-commerce project built to strengthen hands-on skills in **Java**, **Spring Boot**, **Spring Cloud**, and **Angular**. It follows a modern, cloud-native, microservices-based architecture with centralized configuration, service discovery, API gateway, logging, and tracing.

---

## 🚀 Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Cloud (Config, Eureka, Gateway, OpenFeign, Sleuth, Zipkin)
- Spring Security (Planned)
- JWT Authentication (Planned)
- PostgreSQL
- Actuator

### Frontend (Planned)
- Angular
- Bootstrap / TailwindCSS

### DevOps & Tools
- Git (for version control & config repo)
- Zipkin (for distributed tracing)
- Spring Boot Actuator (for health metrics)
- Postman (for API testing)
- Docker (Planned)
- Prometheus + Grafana (Planned for monitoring)

---

## 🧱 Microservices Developed

| Service Name       | Description                               |
|--------------------|-------------------------------------------|
| `product-service`  | Manages product catalog                   |
| `order-service`    | Handles customer orders                   |
| `payment-service`  | Processes payments                        |
| `config-server`    | Centralized configuration management      |
| `eureka-server`    | Service registry for discovery            |
| `api-gateway`      | Unified entry point for all services      |

---

## ✅ Features Implemented (Till Part 3)

- 🔄 **Service Discovery** using **Eureka**
- 🔧 **Centralized Config** using **Spring Cloud Config Server**
- 🔗 **Inter-service communication** via **OpenFeign**
- 🛡️ **API Gateway** with basic routing
- 📦 Externalized configuration stored in Git
- 📊 **Spring Actuator** for health checks
- 🔍 **Zipkin** + **Sleuth** for distributed tracing and log correlation

---

## 🔐 Next Planned Features (Part 4)

- 🔒 **JWT-based Authentication** using **Spring Security**
- 📈 **Rate Limiting** at the API Gateway level
- 🌐 **Angular Frontend** with Auth integration
- 📊 **Monitoring & Alerting** using **Prometheus + Grafana**
- 🐳 **Docker** for containerization and deployment

---

## 📁 Project Structure

```

FSE\_APP\_DEPLOYMENT/
│
├── config-server/           # Spring Cloud Config Server
├── eureka-server/           # Eureka Service Registry
├── api-gateway/             # API Gateway with route filters
├── product-service/         # Product Management Microservice
├── order-service/           # Order Management Microservice
├── payment-service/         # Payment Processing Microservice
├── config-repo/             # External Git-based config files
└── frontend/ (planned)      # Angular Frontend App (TBD)

````

---

## 🧪 How to Run the Project Locally

1. **Clone the project**
```bash
git clone https://github.com/your-username/FSE_APP_DEPLOYMENT.git
````

2. **Start Config Server**

```bash
cd config-server
./mvnw spring-boot:run
```

3. **Start Eureka Server**

```bash
cd ../eureka-server
./mvnw spring-boot:run
```

4. **Start Other Services**
   Start `api-gateway`, `product-service`, `order-service`, and `payment-service` similarly.

5. **Access the UI**

* Eureka Dashboard: `http://localhost:8761`
* Zipkin Dashboard: `http://localhost:9411`
* Gateway endpoint: `http://localhost:9094/{service-name}/...`

---

## 🔗 Useful Links

* 🔗 GitHub Repo: [Project Repository](https://lnkd.in/gTnpyHQb)
* 📖 Spring Cloud Docs: [Spring Cloud](https://spring.io/projects/spring-cloud)
* 🛠️ Zipkin Tracing: [Zipkin](https://zipkin.io/)
* Cloud-Configuration : [spring-cloud-configuration](https://github.com/Deependra-009/spring-cloud-config)

---

## 🤝 Connect

I'm building this project as part of my learning and portfolio. Feedback and collaboration are welcome!

> 📬 [LinkedIn](https://www.linkedin.com/in/deependra-trivedi-bb530a1a5/)

---

## 🏁 Stay Tuned for Part 4!



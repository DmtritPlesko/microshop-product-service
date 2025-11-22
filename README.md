# Microshop Product Service

Микросервис для управления продуктами в микро-маркетплейсе. Реализован на Spring Boot с использованием Clean Architecture.

## 🚀 Технологии

- **Java 22**
- **Spring Boot 3.4.5**
- **Spring Data JPA**
- **H2 Database** (для разработки)
- **PostgreSQL** (для продакшена)
- **MapStruct** - маппинг DTO
- **SpringDoc OpenAPI** - документация API
- **Flyway** - миграции базы данных
- **Docker** - контейнеризация

## 📁 Архитектура

Проект следует принципам Clean Architecture:
```
src/
├── main/
│ ├── java/
│ │ └── com/
│ │ └── microshop/
│ │ └── product/
│ │ ├── application/ # Use Cases, DTOs
│ │ │ ├── dto/
│ │ │ │ ├── request/
│ │ │ │ └── response/
│ │ │ └── service/ # Application services
│ │ ├── domain/ # Business logic
│ │ │ ├── exception/
│ │ │ ├── model/ # Domain entities
│ │ │ └── repository/ # Repository interfaces
│ │ └── infrastructure/ # External concerns
│ │ ├── adapters/
│ │ │ └── persistence/ # JPA entities, repositories
│ │ ├── config/
│ │ └── web/ # Controllers
│ └── resources/
│ ├── db/
│ │ └── migration/ # Flyway migrations
│ ├── application.yaml # Main config
│ └── application-h2.yaml # H2 config
└── test/
```

## 🏃‍♂️ Запуск приложения

### Локальная разработка (H2 Database)

1. **Клонируй репозиторий:**
```bash
git clone https://github.com/DmtritPlesko/microshop-product-service.git
cd microshop-product-service
```

2. **Запусти с H2 профилем:**
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=h2
```

3. **Доступ к H2 Console:**
* URL: http://localhost:8081/h2-console
* JDBC URL: jdbc:h2:mem:testdb
* User: sa
* Password: password

# С PostgreSQL

1. **Запусти PostgreSQL:**
```bash
docker run --name postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=productdb -p 5432:5432 -d postgres:15
```

2. **Запусти приложение:**
```bash
mvn spring-boot:run
```

# 📚 API Документация

**После запуска приложения доступна Swagger документация:**
```
Swagger UI: http://localhost:8081/swagger-ui.html
OpenAPI spec: http://localhost:8081/v3/api-docs
```

**Основные endpoints:**

```
Метод	       Путь	                Описание
GET	    /api/products	      Получить все продукты
GET	    /api/products/{id}	Получить продукт по ID
POST	  /api/products	      Создать новый продукт
PUT	    /api/products/{id}	Полное обновление продукта
PATCH	  /api/products/{id}	Частичное обновление продукта
DELETE	/api/products/{id}	Удалить продукт
```

# 🐳 Docker

1. **Собери JAR:**
```
mvn clean package
```

2. **Собери Docker образ:**
```
docker build -t microshop-product-service .
```

3. **Запусти с Docker Compose:**
```
docker-compose up -d
```

# Docker Compose сервисы
* product-service: порт 8081
* postgres: порт 5432

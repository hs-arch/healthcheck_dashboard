# Health Check Dashboard

A production-ready monitoring system built with Spring Boot that automatically tracks website/service status.

## 🚀 Features
- **REST API** - Manual health check endpoints
- **Automated Monitoring** - Scheduled checks every minute
- **Data Persistence** - MySQL database for historical data
- **Real-time Status** - Live website monitoring
- **Professional Architecture** - Clean separation of concerns

## 🛠 Tech Stack
- **Backend:** Java 17, Spring Boot 3.x
- **Database:** MySQL, Spring Data JPA, Hibernate
- **HTTP Client:** Spring WebClient
- **Scheduling:** Spring Scheduled Tasks
- **API Documentation:** Spring RESTful Web Services

## 📊 API Endpoints
- `POST /v1/health/status/check` - Manual health check (saves to DB)
- `GET /v1/health/status/history` - View all historical checks
- Automated scheduler runs every 60 seconds using `@Scheduler` and `@EnableScheduler`

## 🎯 What I Built
- Configured MySQL integration with Spring Data JPA
- Implemented WebClient for HTTP status checks
- Designed scheduled tasks for automated monitoring
- Created RESTful APIs with proper error handling
- Built professional service-layer architecture

# 🌍 AQI Search Engine

A full-stack Air Quality Index (AQI) Search Engine built using **Java, Spring Boot, HTML, CSS, and JavaScript**. The application allows users to search for any city and view real-time air quality information using the AQICN API.

---

## 🚀 Features

### Backend Features

- RESTful API using Spring Boot
- Integration with AQICN Air Quality API
- Layered Architecture (Controller → Service → Client)
- Global Exception Handling
- Custom Error Responses
- Caffeine Caching
- Cache Expiry Management
- Cache Size Limitation
- Production-Oriented Code Structure
- Optimized API Response Handling

### Frontend Features

- Modern Responsive UI
- City Search Functionality
- Real-Time AQI Display
- AQI Status Classification
- Temperature Information
- Humidity Information
- Dominant Pollutant Display
- Last Updated Information
- Health Recommendations
- AQI Color Coding
- Error Handling UI

---

## 🏗 Architecture

```text
Frontend (HTML/CSS/JavaScript)
            │
            ▼
Spring Boot Controller
            │
            ▼
Service Layer
            │
            ▼
AQICN Client
            │
            ▼
AQICN API
```
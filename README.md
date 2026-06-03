# 🌍 AQI Search Engine

A full-stack Air Quality Index (AQI) Search Engine built using **Java, Spring Boot, HTML, CSS, and JavaScript**. The application allows users to search for any city and view real-time air quality information using the AQICN API.

---

## 🚀 Features

### Backend Features

* RESTful API using Spring Boot
* Integration with AQICN Air Quality API
* Layered Architecture (Controller → Service → Client)
* Global Exception Handling
* Custom Error Responses
* Caffeine Caching
* Cache Expiry Management
* Cache Size Limitation
* Swagger/OpenAPI Support
* Production-Oriented Code Structure

### Frontend Features

* Modern Responsive UI
* City Search Functionality
* Real-Time AQI Display
* AQI Status Classification
* Temperature Information
* Humidity Information
* Dominant Pollutant Display
* Last Updated Information
* Health Recommendations
* AQI Color Coding

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

---

## 🛠 Tech Stack

### Backend

* Java 17
* Spring Boot 4
* Maven
* Caffeine Cache
* Lombok
* Spring Validation
* OpenAPI / Swagger

### Frontend

* HTML5
* CSS3
* JavaScript (ES6)

### External API

* AQICN API
* https://aqicn.org/api/

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.shivakumar.aqi_search_engine
│   │       ├── client
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── exceptions
│   │       └── service
│   │
│   └── resources
│       ├── static
│       │   ├── css
│       │   ├── js
│       │   └── index.html
│       │
│       └── application.properties
```

---

## ⚡ Cache Configuration

The application uses Caffeine Cache to improve performance and reduce external API calls.

### Cache Settings

```text
Cache Name      : aqi
Maximum Entries : 100
Expiry Time     : 10 Minutes
Key             : City Name
```

### Benefits

* Faster repeated searches
* Reduced vendor API usage
* Better response times
* Improved scalability

---

## 🔗 API Endpoints

### Get AQI By City

```http
GET /api/air-quality/city?city=hyderabad
```

### Successful Response

```json
{
  "city": "Somajiguda, Hyderabad, India",
  "aqi": 68,
  "dominantPollutant": "pm25",
  "temperature": 30.3,
  "humidity": 65.47,
  "status": "Moderate",
  "lastUpdated": "2026-06-03 20:00:00"
}
```

### Error Response

```json
{
  "message": "No AQI data found for city: randominvalidcity",
  "timestamp": "2026-06-03T22:18:52"
}
```

---

## 📖 Swagger Documentation

After starting the application:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## ▶ Running The Project

### Clone Repository

```bash
git clone https://github.com/SHIVAKUMAR32275/aqi-search-engine.git
```

### Navigate To Project

```bash
cd aqi-search-engine
```

### Configure API Token

Open:

```properties
src/main/resources/application.properties
```

Replace:

```properties
aqi.api.token=YOUR_AQICN_TOKEN
```

with your AQICN API token.

### Run Application

```bash
mvn spring-boot:run
```

Application starts at:

```text
http://localhost:8080
```

---

## 📸 Screenshots

### Home Page

(Add Screenshot Here)

### AQI Search Result

(Add Screenshot Here)

### Invalid City Error

(Add Screenshot Here)

---

## 🎯 Future Enhancements

* City Autocomplete Search
* AQI Trend Charts
* Forecast Visualization
* Dark / Light Theme
* User Search History
* Multi-City Comparison
* Export AQI Reports

---

## 👨‍💻 Author

**Vilasagarapu Shiva Kumar**

GitHub:
https://github.com/SHIVAKUMAR32275

---

## 📄 License

This project was developed as part of a Software Engineer (Java) coding challenge submission.

# weather-search-engine
Weather Search Engine built with Java, Spring Boot and Caffeine Cache

# Weather Search Engine 🌦️

A Spring Boot REST API that fetches real-time weather data 
using OpenWeather API with Caffeine caching for performance.

## Features
- Real-time weather search by city name
- Caffeine Cache with TTL 10 minutes and max 100 entries
- Clean frontend built with HTML, CSS, JavaScript
- Error handling for invalid city inputs

## Tech Stack
- Java 17
- Spring Boot 3.2
- Spring Cache + Caffeine
- OpenWeather API
- HTML, CSS, JavaScript

## How to Run
1. Clone the repository
2. Add your OpenWeather API key in `application.properties`
3. Run as Spring Boot App
4. Open `http://localhost:8080`

## API Endpoint
GET /weather?city=Mumbai

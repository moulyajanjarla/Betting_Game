🎯 Online Betting Game with JWT Authentication
This project is an Online Betting Game built using Spring Boot for the backend and React for the frontend. It includes user registration, login, and protected endpoints using JWT-based authentication.

🚀 Project Structure
betting-app/
├── backend/
│   ├── src/main/java/com/example/betting/
│   │   ├── BettingApplication.java
│   │   ├── controller/
│   │   │   ├── AuthController.java
│   │   │   ├── BetController.java
│   │   ├── model/
│   │   │   ├── User.java
│   │   ├── repository/
│   │   │   ├── UserRepository.java
│   │   ├── security/
│   │   │   ├── JwtFilter.java
│   │   │   ├── JwtUtil.java
│   │   │   ├── SecurityConfig.java
│   ├── src/main/resources/
│   │   ├── application.properties
│   ├── pom.xml
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── LoginForm.jsx
│   │   │   ├── RegisterForm.jsx
│   │   ├── pages/
│   │   │   ├── Home.jsx
│   │   │   ├── Protected.jsx
│   │   ├── services/
│   │   │   ├── authService.js
│   │   ├── App.jsx
│   │   ├── main.jsx
│   ├── package.json
│   ├── vite.config.js
├── docker-compose.yml
├── README.md
🛠️ Tech Stack
Backend:
✅ Java 17
✅ Spring Boot
✅ Spring Security
✅ JWT
✅ PostgreSQL

Frontend:
✅ React
✅ Axios
✅ React Router

🔥 Features
✅ User Registration
✅ User Login
✅ JWT Token Generation
✅ Token-based Authentication
✅ Protected Routes for Bets

🚀 Backend Setup
1. Clone the Repository:
git clone https://github.com/moulyajanjarla/Betting_Game.git
cd betting-app/backend
2. Set Up Database:
Create a PostgreSQL database named betting.

3. Configure application.properties:
Set up the database configuration in src/main/resources/application.properties:

properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/betting
spring.datasource.username=postgres
spring.datasource.password=yourpassword

# JPA Configuration
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

# JWT Configuration
jwt.secret=mysecretkey
jwt.expiration=3600000
4. Build and Run:
mvn clean install
mvn spring-boot:run
🌐 Frontend Setup
1. Install Dependencies:
cd frontend
npm install
2. Start Development Server:

npm run dev
🎯 API Endpoints
➡️ Register User
POST /auth/register
Request:

json
Copy
Edit
{
  "username": "moulya",
  "password": "prass",
  "role": "USER"
}
Response:

{
  "token": "eyJhbGciOiJIUz..."
}
➡️ Login User
POST /auth/login
Request:

json
Copy
Edit
{
  "username": "moulya",
  "password": "prass"
}
Response:

{
  "token": "eyJhbGciOiJIUz..."
}
➡️ Access Protected Resource
GET /api/bets
Headers:

{
  "Authorization": "Bearer <TOKEN>"
}
Response:

[
  {
    "id": 1,
    "bet": "Team A wins"
  }
]
🐳 Docker Setup
1. Create docker-compose.yml:
version: '3.8'

services:
  backend:
    build: ./backend
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/betting
      - SPRING_DATASOURCE_USERNAME=postgres
      - SPRING_DATASOURCE_PASSWORD=password
    depends_on:
      - db

  db:
    image: postgres:latest
    container_name: postgres_betting
    ports:
      - "5432:5432"
    environment:
      - POSTGRES_DB=betting
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=password

  frontend:
    build: ./frontend
    ports:
      - "5173:5173"
    depends_on:
      - backend
2. Build and Start:

docker-compose up --build
✅ Testing with cURL
Register User:

curl -X POST http://localhost:8080/auth/register -H "Content-Type: application/json" -d "{\"username\":\"moulya\", \"password\":\"prass\", \"role\":\"USER\"}"
Login User:

curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d "{\"username\":\"moulya\", \"password\":\"prass\"}"
Access Protected Endpoint:

curl -X GET http://localhost:8080/api/bets -H "Authorization: Bearer <TOKEN>"
🚨 Common Issues
❌ 403 Forbidden:
➡️ Check if the JWT token is passed correctly in the Authorization header.
➡️ Ensure that Spring Security is configured properly in SecurityConfig.java.

❌ 401 Unauthorized:
➡️ Check if the token has expired or is malformed.
➡️ Ensure the signing key matches the one in JwtUtil.java.

❌ 500 Internal Server Error:
➡️ Check the backend logs for any missing database connection or Spring configuration issues.

🌟 Future Improvements
✅ Add Role-Based Access Control (RBAC)
✅ Add Betting History Feature
✅ Add Real-Time Betting Updates using WebSockets

🏆 Author
Janjarla Sai Venkata Moulya

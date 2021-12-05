# User with Docker

### TECH STACK:
     - JDK 1.11
     - Spring Boot
     - Maven

### HOW TO START IT:

**Create Local .jar inside Target folder:** `Maven clean package -DskipTests=true`                                                   

**Local + Docker:** `Launch UserApplication in your IDE` `Launch  Docker Desktop with PostgreSQL `

* PostgreSQL container:
     * Ports : "5432:5432"
     * Username: postgres
     * Password: mysecretpassword

**Only Docker:** 
`In your cmd inside the project path launch ...    docker-compose up`

**Postman:**
`http://localhost:8080/users`

# User with Docker

### Create Local .jar:

`Maven clean package -DskipTests=true`

**Start in local or in docker:**

**Local + Docker:**`Launch UserApplication in your IDE` `Launch  Docker Desktop with PostgreSQL `

* PostgreSQL container:
     * Ports : "5432:5432"
     * Username: postgres
     * Password: mysecretpassword

**Only Docker:** 
`In you cmd inside the project path launch ...    docker-compose up`

**Postman:**
`http://localhost:8080/users`

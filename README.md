# userDocker

### Build all modules:

`Maven clean package -DskipTests=true`

**Start each microservice either in local or in docker:**

**Local:** `spring-boot-microservices-series/catalog-service> ./mvnw spring-boot:run`

**Docker:** `spring-boot-microservices-series> ./run.sh start <service>`

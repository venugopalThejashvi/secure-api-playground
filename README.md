# secure-api-playground
## cURL's
- [AUTH-API-cURL's](auth/README.md)
- [NO-AUTH-API-cURL's](noauth/README.md)

## Run Locally

### Prerequisites
- **Java 17** (JDK)
- **Maven 3.8+**
- **Git**
- **Redis Server(Must be running locally)**
- **Kafka(Must be running locally)**
- **Consumer Service:** [Kafka Email Service](https://github.com/venugopalThejashvi/email)


### Steps
* clone the repo
* cd predict
* mvn spring-boot:run

### CONCEPTS
* Kafka Integration
* Rate Limiting with redis
* Springboot basic crud
* jwt authentication
* env
* exception handler
* health check with/without JWT


# BookIt

Welcome to a new way of bookings your movie tickets. BookIt is a simple and easy to use application that allows you to book your movie tickets in a few simple steps.

## Endpoints

The endpoints can be viewed using the swagger UI. The swagger UI can be accessed at 
``http://localhost:8080/swagger-ui/index.html``

# Running the service

Before running the service, you need do the following configurations:
- Add your postgres database configurations in the `application.properties` file.

**Or**
- Install Docker and run the following command to start a postgres database container:
```
docker compose up
```

Then you can run the service.

To run the service, you can use the following command:

```
mvn spring-boot:run
```
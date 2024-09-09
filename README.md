
# LiveEasyTask

LiveEasyTask is a Spring Boot application designed for load management. It allows you to create, read, update, and delete load records. The application integrates with Swagger for API documentation and uses various Spring Boot features for robust service implementation.

- [Swagger Documentation](http://localhost:8080/swagger-ui/index.html#/)
- [Postman Documentation](https://documenter.getpostman.com/view/29367403/2sAXjRXq9x)

# Configuration guide for application setup
- clone the project
- and then you just need to change the database configuration in ***Application.properties*** file
```http
    spring.datasource.url = jdbc:postgresql://localhost:5432/{YOUR_DATABASE}
    spring.datasource.username = {YOUR_USERNAME}
    spring.datasource.password = {YOUR_PASSWORD}
```
# Refrence API endpoints 
- create a load
```http
   POST : http://localhost:8080/load
```

- get load by shipper id
```http
   GET : http://localhost:8080/load?shipperId={SHIPPER_ID}
```

- get load by load id
```http
   GET : http://localhost:8080/load/{LOAD_ID}
```

- update load by load id
```http
   PUT - http://localhost:8080/load/{LOAD_ID}
```

- delete load by load id
```http
   DELETE - http://localhost:8080/load/{LOAD_ID}
```
# Features

- java 17
- springBoot 3.3.3
- postgres
- swagger OpenApi
- lombok
- Exception handling
- Validation checks

# ScreenShots








# LiveEasyTask

LiveEasyTask is a Spring Boot application designed for load management. It allows you to create, read, update, and delete load records. The application integrates with Swagger for API documentation and uses various Spring Boot features for robust service implementation.

- [Swagger Documentation - only when local is up and running](http://localhost:8080/swagger-ui/index.html#/)
- [Postman Documentation](https://documenter.getpostman.com/view/29367403/2sAXjRXq9x)

# **NOTE - i have added some additional custom responses based on validation checks by rigorous exception handling** 
# Configuration guide for application setup
- clone the project
- and then you just need to change the database configuration in ***Application.properties*** file
```http
    spring.datasource.url = jdbc:postgresql://localhost:5432/{YOUR_DATABASE}
    spring.datasource.username = {YOUR_USERNAME}
    spring.datasource.password = {YOUR_PASSWORD}
```
# Refrence API endpoints 
- create a load - also give request body as load 
```http
   POST : http://localhost:8080/load

{
    "loadingPoint": "hyderabad",
    "unloadingPoint": "vijayawada",
    "productType": "pharmaceuticals",
    "truckType": "specialized",
    "noOfTrucks": 2,
    "weight": 250,
    "comment": "Pharmaceuticals delivery",
    "shipperId": "6e849a4e-4b87-46f2-bfb7-621a723f8a9e",
    "date": "02-10-2024"
}
```
- get load by shipper id - u need to give path parameter here as well
```http
   GET : http://localhost:8080/load?shipperId={SHIPPER_ID}
```

- get load by load id - u need load Id a s path variable here
```http
   GET : http://localhost:8080/load/{LOAD_ID}
```

- update load by load id - u need load Id a s path variable here
```http
   PUT - http://localhost:8080/load/{LOAD_ID}

{
    "loadingPoint": "patna",
    "unloadingPoint": "gaya",
    "productType": "",
    "truckType": "tanker",
    "noOfTrucks": 5,
    "weight": 105,
    "comment": "For farm distribution",
    "date": "18-09-2024"
}

```

- delete load by load id - u need load Id a s path variable here
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
![Screenshot 2024-09-09 124443](https://github.com/user-attachments/assets/90b7c2e6-f1cb-4213-9a39-9faf3c70f3c4)
![image](https://github.com/user-attachments/assets/a372606f-1cac-4bb7-a40b-5d7b0bc9169d)
![image](https://github.com/user-attachments/assets/13635781-3d37-4d6c-875b-cc6befff524f)
![image](https://github.com/user-attachments/assets/aae721f7-71ef-49e7-8478-0c3d5a913c59)
![image](https://github.com/user-attachments/assets/03f276d4-16b0-44eb-b2cc-8eab3cc34b7c)
![image](https://github.com/user-attachments/assets/0a685973-47b3-43a9-8590-f890adfeae3a)














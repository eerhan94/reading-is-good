# Reading Is Good Application

Project Definition
ReadingIsGood is an online books retail firm which operates only on the Internet. Main target of ReadingIsGood is to deliver books from its one centralized warehouse to their customers within the same day.

# Running with docker
1. Clone this repository
2. Go to project directory
3. mvn clean install
4. docker-compose up --build
 
# Used Technologies
-Java 11

-Spring-Boot

-MongoDb

-Maven

-Docker

# Swagger reading-is-good-api
http://localhost:9091/swagger-ui.html#/
![image](https://user-images.githubusercontent.com/10101398/169712877-635e23ca-c1fc-4e09-a6d3-cb4ea7d2cdf1.png)

# Unit test coverage
![Screenshot_2](https://user-images.githubusercontent.com/10101398/169766932-48aa2e8e-1ac4-4e11-aad6-8e38b086d354.png)

# Authentication Token Url
curl --location --request POST 'http://localhost:9091/authenticate'
--header 'Content-Type: application/json'
--data-raw '{ "username":"getir", "password":"password" }'

# Postman Collections
![image](https://user-images.githubusercontent.com/10101398/169767090-2ee7b8dc-6809-4b6f-9ad0-06f474bd1ddd.png)




# Reading Is Good Application

Project Definition
ReadingIsGood is an online books retail firm which operates only on the Internet. Main 
 target of ReadingIsGood is to deliver books from its one centralized warehouse to their 
 customers within the same day.
 
Used Technologies
-Java 11

-Spring-Boot

-MongoDb

-Maven

-Docker

Swagger
reading-is-good-api

http://localhost:9091/swagger-ui.html#/

Authentication Token Url
curl --location --request POST 'http://localhost:9091/authenticate'
--header 'Content-Type: application/json'
--data-raw '{ "username":"getir", "password":"password" }'



# cs590-mini-project



In this project, we are asked to implement a Restful service tha allows an admin a batch job. Given a CSV file which has three columns: First , last , GPA , AGE. We convert the AGE into a date format (yyyy-01-01). 

### database runs locally on port 3305 / MYSQL
### application runs on port 8086
### use "docker-compose up" command to run it.

We created two containers named: mysql-standalone and app and in oder to view the content of the database, we set the following

spring.datasource.url=jdbc:mysql://mysql-standalone/cs590-sa


Postman is used to test the endpoints. Following is a list of the use cases of the program with examples:

We have a signup page, to save a user with Admin role:

POST: http://localhost:8086/users

{
    "username":"foo",
    "password":"usfaa444",
    "roles": [{
        "role":"ADMIN"
    }]
}

We have authenticate/signin page that authenticate the user, only the user with Admin role is granted access to the application. Once an Admin successfully signin, a JWT token is generated 

POST : http://localhost:8086/authenticate

{
    "username":"foo",
    "password":"usfaa444"
}

The generated token is then used authorize admin to perform the Batch job using the following uri : 

GET: http://localhost:8086/task

and the database is then populated. 



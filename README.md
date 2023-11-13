# Joke service
This is the documentation for the joke application, which includes a backend, a databaseThe application is implemented 
using Spring Boot.
# Technology
Java 17<br>
Spring Boot 3<br>
JWT authentication
Hibernate<br>
Maven<br>
Lombok<br>
Postgres<br>
Flyway<br>
Docker<br>
Docker Compose<br>
# System Requirements
Before running the application on Docker, make sure your system meets the following requirements:
Docker: https://www.docker.com/
# Running the Application on Docker
1. Clone the Repository<br>
2. Run the following command to start the project: docker compose up 
   
# Logging into the Application

Customers:<br><br>
email: userAdam@gmail.com <br>
Password: test <br><br>
email: userPiotr@gmail.com <br>
Password: test <br><br>
Service admin:<br><br>
Username: adminKacper@gmail.com <br>
Password: test <br><br>

# Stopping the Project
To stop the project, you can use the following command: docker compose down
This will stop and remove all the containers, networks, and volumes defined in the docker-compose.yaml file.

# About app
Joke service is a platform where users can add and browse jokes submitted by other users. The admin has the authority to remove users and unwanted jokes.




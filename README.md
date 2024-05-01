# Web Server Computing AD Project

This project is part of the Web Server Computing course at Kookmin University. 

It is a web application developed using Kotlin, Spring Boot. 

The application is designed to provide a platform for users to ask questions and receive answers.

## Features

The application provides the following features:

1. **Question List**: Displays a list of all the questions asked by users.
2. **Question Registration**: Allows users to register a new question.
3. **Question Details**: Displays the details of a selected question, including all the answers to the question.
4. **Answer Registration**: Allows users to register an answer to a selected question.
5. **Login**: Allows users to log in to the application.
6. **Logout**: Allows users to log out of the application.
7. **User Registration**: Allows new users to register an account.
8. **Paging**: Supports paging for the question list to enhance usability.

## Setup

To run this project, you need to have Docker installed on your machine. Follow the steps below:

1. Clone the repository.
2. Navigate to the project directory.
3. Run `docker-compose up` to start the MySQL database.
4. Open the project in IDE that supports Kotlin and Spring Boot.
5. Run the `WebServerAdProjectApplication.kt` file to start the application.

## Configuration

The application's configuration is located in the `application.properties` file. 

## Dependencies

The project uses the following dependencies:


- Spring Boot Starter Web
- Spring Boot Starter Thymeleaf
- Spring Boot Starter Validation

- Spring Boot Starter JDBC, Data JPA
- MySQL Connector

## License

[Apache License 2.0](LICENSE)
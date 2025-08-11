# Library Management System 📚

<img src="https://github.com/Innocentsax/LibrarySystem/blob/main/LibSystem.png" height="400" width="1000">

![Test Status](https://github.com/thilina01/library-management-system/actions/workflows/test.yml/badge.svg)
![Build Status](https://github.com/thilina01/library-management-system/actions/workflows/docker-build-push.yml/badge.svg)
![Docker Pulls](https://img.shields.io/docker/pulls/thilina01/library-management-system)
![Docker Image Size](https://img.shields.io/docker/image-size/thilina01/library-management-system)

## 📖 Overview

The **Library Management System** is a comprehensive RESTful API for managing books and borrowers in a library. Key features include:

- **Borrower and Book Registration**: Register new borrowers and books effortlessly.
- **Book Management**: Borrow and return books with ease.
- **Comprehensive Logging**: Detailed logging with SLF4J and Logback.
- **Containerization**: Docker support for easy deployment.
- **Kubernetes Integration**: Deployment with MySQL and Kubernetes.
- **CI/CD**: Automated builds and deployments with GitHub Actions.

## 🚀 Features

- **Java 17**: Utilizes the latest Java version with Maven for dependencies.
- **Spring Boot**: Simplifies configuration and setup.
- **Dockerized**: Multi-stage Docker builds for optimized images.
- **CI/CD**: GitHub Actions automates Docker builds and pushes to Docker Hub.
- **API Documentation**: Interactive API documentation with Swagger.

## 🛠️ Getting Started

### Prerequisites

Ensure you have the following setup:
- Java 17
- Docker
- Maven
- GitHub account
- Docker Hub account
- Kubernetes (minikube or similar)

### Build and Run Locally

1. **Clone the repository**:
    ```sh
    git clone https://github.com/Innocentsax/LibrarySystem.git
    cd library-management-system
    ```

2. **Build the project using Maven**:
    ```sh
    mvn clean install
    ```

3. **Run the application**:
    ```sh
    java -jar librarysystem-0.0.1-SNAPSHOT.jar
    ```

### Logging Levels

The logging levels used in the project are:
- `INFO`: General application information.
- `DEBUG`: Detailed information used for debugging purposes.
- `ERROR`: Error messages indicating that something went wrong.

You can adjust the logging levels in the Logback configuration file to control the verbosity of the logs.

## 🚀 Testing

### Running Unit Tests

Unit tests are implemented to ensure the functionality and reliability of the Library Management System. The tests can be run using Maven, and the results will be generated in a report format.

**Running Tests:**

To run the unit tests, execute the following command in the root directory of your project:

```bash
mvn test
```

**Endpoints Included:**
1. **Register a New Borrower**
    - **Method**: POST
    - **URL**: `{{base_url}}/api/borrowers`
    - **Headers**:
        - `Content-Type: application/json`
    - **Body**:
      ```json
      {
        "email": "john.doe@example.com",
        "name": "John Doe"
      }
      ```

2. **Register a New Book**
    - **Method**: POST
    - **URL**: `{{base_url}}/api/books`
    - **Headers**:
        - `Content-Type: application/json`
    - **Body**:
      ```json
      {
        "isbn": "1234567890",
        "title": "Sample Book",
        "author": "Sample Author"
      }
      ```

3. **List All Books**
    - **Method**: GET
    - **URL**: `{{base_url}}/api/books`

4. **Borrow a Book**
    - **Method**: POST
    - **URL**: `{{base_url}}/api/borrowers/{{borrower_id}}/borrow/{{book_id}}`
    - **Headers**:
        - `Content-Type: application/json`
    - **Body**:
      ```json
      {
        "borrowerId": {{borrower_id}},
        "bookId": {{book_id}}
      }
      ```

5. **Return a Book**
    - **Method**: POST
    - **URL**: `{{base_url}}/api/borrowers/{{borrower_id}}/return/{{book_id}}`
    - **Headers**:
        - `Content-Type: application/json`

6. **Verify Borrower Details**
    - **Method**: GET
    - **URL**: `{{base_url}}/api/borrowers/{{borrower_id}}`

7. **Verify Book Details**
    - **Method**: GET
    - **URL**: `{{base_url}}/api/books/{{book_id}}`

**Variables Included:**
- **base_url**: `http://localhost:8080`
- **borrower_id**: `1`
- **book_id**: `1`


### API Endpoints

- **Register a new borrower**:
    ```http
    POST /api/borrowers
    {
      "name": "John Doe",
      "email": "john.doe@example.com"
    }
    ```

- **Register a new book**:
    ```http
    POST /api/books
    {
      "isbn": "1234567890",
      "title": "Test Book",
      "author": "Test Author"
    }
    ```

- **Get a list of all books**:
    ```http
    GET /api/books
    ```

- **Borrow a book**:
    ```http
    POST /api/borrowers/{borrowerId}/borrow/{bookId}
    ```

- **Return a borrowed book**:
    ```http
    POST /api/borrowers/{borrowerId}/return/{bookId}
    ```

- **Get borrower details**:
    ```http
    GET /api/borrowers/{borrowerId}
    ```

- **Get book details**:
    ```http
    GET /api/books/{bookId}
    ```

## Author
 ### ___[UDO INNOCENT CHARLES](https://github.com/Innocentsax)___


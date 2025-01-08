# Backend for Event Manager

This repository contains the backend code for the Event Manager application. It is built using **Spring Boot** to provide an API for managing events such as creating, updating, deleting, and retrieving events.

## Features

- Fetch all events
- Fetch event details by ID
- Create new events
- Update existing events
- Delete events

## Prerequisites

- Java 8 or higher
- Maven (or Gradle) for dependency management
- An IDE (like IntelliJ IDEA or Eclipse) to run the application

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Samod-Kularathne/softedgelabsbackend.git
   ```
   
### Note:
- If you are opening the project using intelliJ IDEA no need to go through the steps from step 2 to step 4.
- Wait for the intelliJ IDEA to load the project and click on the run button.

2. Navigate to the project directory:
   ```bash
    cd softedgelabsbackend
   ```
3. Build the project (use Maven)
   ```bash
    mvn clean install
   ```
4. Start the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```
5. The backend will be running on http://localhost:8080 by default. 

## API Endpoints

- **GET /api/get-events**: Fetch all events.
- **GET /api/get-event/{id}**: Fetch details of a single event by ID.
- **POST /api/create-event**: Create a new event.
- **PUT /api/events/{id}**: Update an event by ID.
- **DELETE /api/events/{id}**: Delete an event by ID.

## Database

The application uses an in-memory database (H2) by default for testing purposes. You can switch to another database by configuring `application.properties`.

## Notes

- Ensure that the backend is running before testing the frontend.
- Update the API base URL in the frontend if the backend is hosted on a different address.

## Technologies Used

- **Spring Boot** for building the backend API.
- **H2 Database** (in-memory database) for storing event data.
- **Spring Data JPA** for database operations.

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   └── samod/
│   │   │       └── eventmanager/
│   │   │           ├── config/           # Configuration files (e.g., CorsConfig)
│   │   │           ├── controller/       # API controllers (AttendeeController, EventController)
│   │   │           ├── dto/              # Data Transfer Objects (AttendeeDTO, EventDTO)
│   │   │           ├── exception/        # Custom exceptions (ResourceNotFoundException, ValidationException)
│   │   │           ├── model/            # Models (Attendee, Event)
│   │   │           ├── repository/       # Database repositories (AttendeeRepository, EventRepository)
│   │   │           ├── service/          # Business logic (AttendeeService, EventService)
│   │   │           └── EventManagerApplication/ # Main application class
│   └── resources/
│       ├── application.properties        # Configuration for the app
│       ├── static/                       # Static resources
│       └── templates/                    # HTML templates (if any)
```

# Design Decisions

### REST API
A RESTful API is designed to interact with the frontend, ensuring scalability and maintainability.

### JPA and H2
- **Spring Data JPA**: Used for Object-Relational Mapping (ORM).
- **H2 Database**: Chosen for simplicity during development and testing.

### Error Handling
Proper error handling is implemented to return appropriate status codes and error messages.

---

Enjoy using the **Event Manager** backend!

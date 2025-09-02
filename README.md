# Bookify Service 📅

A complete REST API for an appointment scheduling system, built with Java 21 and the Spring Boot framework. This project allows providers to manage their availability and clients to book appointments seamlessly.

## Technologies Used
- Java 21
- Spring Boot 3
- Spring Data JPA / Hibernate
- Oracle Database (for persistence)
- H2 Database (for development & testing)
- Maven
- Lombok

## Features
- **Provider Schedule Management:** Endpoints for providers to create and manage their available time slots.
- **Client Booking System:** Endpoints for clients to browse available slots and secure an appointment.
- **Data Integrity:** The service layer uses Spring's transactional management to ensure booking operations are atomic, guaranteeing that a time slot can only be booked once.

## Getting Started

### Prerequisites
- JDK 21 or newer
- Apache Maven
- An Oracle Database instance

### Configuration
1. Clone the repository:
   ```bash
   git clone [https://github.com/dinesh21f61a0920/bookify-service.git](https://github.com/dinesh21f61a0920/bookify-service.git)

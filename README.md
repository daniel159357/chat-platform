# chat-platform

# Chat Platform

Welcome to the **Chat Platform**, a real-time online chat application built using Spring Boot. This project demonstrates the use of WebSocket for real-time messaging, REST APIs for user management and chat history, and an in-memory H2 database for persistence. It’s designed as a simple, scalable chat system that can be extended with additional features like user authentication or a modern frontend framework (e.g., React or Vue).

This project was developed as part of a learning exercise and serves as a showcase for Spring Boot development skills, making it an excellent addition to a CV or portfolio.

## Features
- **Real-Time Messaging**: Uses WebSocket for instant message broadcasting to all connected users.
- **User Registration**: REST API endpoint to register users with a username and password.
- **Chat History**: REST API to retrieve stored chat messages from the database.
- **Simple Frontend**: Basic HTML/JavaScript interface for testing the chat functionality.
- **In-Memory Database**: H2 database for storing users and messages (persists during runtime).

## Prerequisites
- **Java 17**: Required to build and run the application.
- **Maven**: For dependency management and building the project.
- **GitHub Codespaces**: Recommended environment for easy setup (or any IDE with Java/Maven support, e.g., IntelliJ IDEA, VS Code).
- **Internet Connection**: To access external dependencies and run the app in Codespaces.

## Setup Instructions

### Using GitHub Codespaces
1. **Fork or Clone the Repository**:
   - Fork this repository to your GitHub account or clone it:
     ```bash
     git clone https://github.com/Username/chat-platform.git

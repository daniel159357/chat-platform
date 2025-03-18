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
     git clone https://github.com/daniel159357/chat-platform.git
     ```
     Replace Username with your GitHub username.
2. **Launch Codespaces**:
   - On the GitHub repository page, click the green "Code" button > "Codespaces" tab > "Create Codespace on main".
   - Wait for the environment to set up (it will install Java 17 and Maven automatically).
3. **Build the Project**:
   - Open a terminal in Codespaces and run:
     ```bash
     mvn clean install
     ```
4. **Run the Application**:
   - Start the Spring Boot app:
     ```bash
     mvn spring-boot:run
     ```
   - The app will run on port 8080 (or 8081 if configured differently).
5. **Access the Chat Interface**:
   - In the Codespaces "Ports" tab, make port 8080 public (click the lock icon if needed).
   - Copy the public URL (e.g., `https://<username>-chat-platform-<random-id>-8080.app.github.dev`).
   - Open `<your-codespace-url>/chat.html` in your browser to access the chat interface.

### Local Setup (Optional)
- **Install Java 17 and Maven**:
  - Install OpenJDK 17 and Maven on your local machine (instructions vary by OS).
  - Verify with:
    ```bash
    java -version
    mvn -version
    ```
- **Clone the Repository**:
  - Clone the repo as above.
- **Build and Run**:
  - Follow the same `mvn clean install` and `mvn spring-boot:run` commands.
- Access `http://localhost:8080/chat.html` in your browser.

## Usage
- **Open the Chat Interface**:
  - Load `<your-codespace-url>/chat.html` in multiple browser tabs.
- **Join the Chat**:
  - Enter a username in the input field (e.g., "User1", "User2") and start typing.
- **Send Messages**:
  - Type a message and click "Send". The message will broadcast to all connected tabs.
- **View Chat History**:
  - Click "Load Chat History" to see all messages stored in the H2 database.
- **Test REST APIs (Optional)**:
  - Use an online HTTP client (e.g., [ReqBin](https://reqbin.com/)):
    - `POST <your-codespace-url>/api/users/register` with `{"username": "test", "password": "pass"}`
    - `GET <your-codespace-url>/api/users`
    - `GET <your-codespace-url>/api/messages`

## Project Structure
- **src/main/java/com/example/chatplatform/**:
  - `ChatPlatformApplication.java`: Main Spring Boot application class.
  - `config/WebSocketConfig.java`: WebSocket configuration.
  - `controller/`: REST controllers (`UserController.java`, `MessageController.java`).
  - `model/`: Entity classes (`User.java`, `Message.java`).
  - `repository/`: JPA repositories (`UserRepository.java`, `MessageRepository.java`).
  - `websocket/ChatWebSocketHandler.java`: WebSocket handler for real-time messaging.
- **src/main/resources/**:
  - `application.properties`: Configuration for H2 database and server port.
  - `static/chat.html`: Frontend HTML/JavaScript interface.

## Troubleshooting
- **Port 8080 in Use**:
  - If you see "Port 8080 was already in use," kill the existing process:
    ```bash
    lsof -i :8080
    kill -9 <PID>
    ```
  - Then rerun `mvn spring-boot:run`.
- **WebSocket Connection Fails**:
  - Ensure the URL in `chat.html` uses `wss://${window.location.host}/chat` and check the browser console for errors.
- **Build Errors**:
  - Verify Java 17 is set as the default (`java -version`) and Maven uses it (`mvn -version`).

## Future Improvements
- Add user authentication with Spring Security.
- Integrate a modern frontend framework (e.g., React, Vue.js).
- Use a persistent database (e.g., PostgreSQL) instead of H2.
- Implement private chat rooms or group messaging.

## Credits
- Built using Spring Boot 3.3.4, Java 17, and Maven.
- Inspired by online tutorials and Spring documentation.

## License
This project is open-source and available under the MIT License.

Copyright (c) 2025 Daniel TAM

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
---

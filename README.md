# Chat Application

## Overview

The Chat Application is a simple Java-based client-server chat system that allows users to communicate with each other in real-time. This application consists of two main components: the server, which handles client connections and message broadcasting, and the client, which allows users to send and receive messages from the server and other connected clients.

## Features

- Real-time chat: Instantly send and receive messages between clients.
- Multiple clients: The server supports connections from multiple clients simultaneously.
- Simple and intuitive: Easy-to-use interface for seamless communication.

## Requirements

- Java Development Kit (JDK) 8 or above installed on the system.
- A text editor or Integrated Development Environment (IDE) to run the Java code.

## How to Use

1. **Clone or download the Chat Application repository to your local machine.**

2. **Open the server-side code:**
   - Navigate to the `server` directory in the repository.
   - Modify the server configuration (e.g., port number) in the `SimpleChatServer.java` file if needed.

3. **Start the server:**
   - Compile and run the `SimpleChatServer.java` file.
   - The server will start listening on the specified port, waiting for client connections.

4. **Open the client-side code:**
   - Navigate to the `client` directory in the repository.
   - Modify the client configuration (e.g., server IP address, port number) in the `SimpleChatClient.java` file if needed.

5. **Start the client(s):**
   - Compile and run the `SimpleChatClient.java` file.
   - The client will connect to the specified server and display the chat interface.

6. **Chatting:**
   - Once the clients are connected, they can send and receive messages.
   - Type a message in the client's console and press Enter to send it to the server.
   - The server will broadcast the message to all connected clients, including the sender.

7. **Exiting the client:**
   - To exit the client, simply close the console or press `Ctrl+C`.

8. **Stopping the server:**
   - To stop the server, close its console or press `Ctrl+C`.

## Additional Notes

- The Chat Application is a simple example and may not be suitable for production use.
- The application does not implement advanced features like message history, user authentication, or encryption, and it may not be suitable for sensitive communications.
- This project can be used as a starting point for building more complex chat applications by extending its functionalities.

## License

[MIT License](LICENSE)

Please review the license file (LICENSE) for usage details and limitations.

## Contributors

This project is an Open-Source initiative. We welcome contributions and improvements from the community. Feel free to open issues, submit pull requests, or provide feedback.

Thank you for using the Chat Application! Happy chatting! 😊

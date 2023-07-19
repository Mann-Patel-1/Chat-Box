import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            // Accept incoming connections from clients
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                // Handle client connection in a separate thread (not shown in this example)
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

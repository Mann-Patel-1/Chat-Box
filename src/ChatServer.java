import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) {
        new ChatServer().startServer();
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Chat Server started. Listening for connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientSocket.getInetAddress();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // Create a new thread to handle client communication
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler.getWriter());
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcast message to all connected clients
    public void broadcastMessage(String message) {
        for (PrintWriter client : clients) {
            client.println(message);
            client.flush();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader reader;
        private PrintWriter writer;

        public ClientHandler(Socket socket) throws IOException {
            this.clientSocket = socket;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        }

        public PrintWriter getWriter() {
            return writer;
        }

        @Override
        public void run() {
            String username = null;
            try {
                // Get the username from the client
                username = reader.readLine();
                broadcastMessage(username + " joined the chat.");

                String message;
                while ((message = reader.readLine()) != null) {
                    broadcastMessage(username + ": " + message);
                }
            } catch (IOException e) {
                System.out.println(username + " left the chat.");
            } finally {
                try {
                    clientSocket.close();
                    clients.remove(writer);
                    broadcastMessage(username + " left the chat.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

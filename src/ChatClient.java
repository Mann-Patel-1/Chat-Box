import java.io.*;
import java.net.Socket;

public class ChatClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        new ChatClient().startClient();
    }

    public void startClient() {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.print("Enter your username: ");
            String username = reader.readLine();
            writer.println(username);

            // Create a separate thread to read messages from the server
            Thread serverReaderThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = serverReader.readLine()) != null) {
                        System.out.println("\n-- "+message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverReaderThread.start();

            // Read and send messages from the user
            String message;
            while ((message = reader.readLine()) != null) {
                writer.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

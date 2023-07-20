package WebChat;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_IP = "2001:56a:7950:fa00:d89a:67e7:c467:1e9e";
    private static final int SERVER_PORT = 8080;
    private String username;

    public ChatClient(String username) {
        this.username = username;
    }

    public void start() {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            Thread messageReceiverThread = new Thread(() -> {
                try {
                    Scanner reader = new Scanner(socket.getInputStream());
                    while (reader.hasNextLine()) {
                        String message = reader.nextLine();
                        // Print the received message to the console
                        System.out.println(message);
                        // Send the message back to the website via WebSocket
                        sendToWebsite(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            messageReceiverThread.start();

            Scanner userInput = new Scanner(System.in);
            while (true) {
                String message = userInput.nextLine();
                writer.println(username + ": " + message);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToWebsite(String message) {
        // Code to send the received message back to the website via WebSocket
        // This step requires a library or framework to handle WebSocket communication on the server-side.
        // Libraries like Jetty, Tomcat, or Spring WebSocket can be used.
    }

    public static void main(String[] args) {
        System.out.println("Enter your username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        ChatClient client = new ChatClient(username);
        client.start();
    }
}

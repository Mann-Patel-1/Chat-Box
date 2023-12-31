package RouterTerminalChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient1 {
    private static final String SERVER_IP = "2001:56a:7950:fa00:d89a:67e7:c467:1e9e";
      private static final int SERVER_PORT = 8080;
    private String username;

    public ChatClient1(String username) {
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
                        System.out.println(message);
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

    public static void main(String[] args) {
        System.out.println("Enter your username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        ChatClient1 client = new ChatClient1(username);
        client.start();
    }
}

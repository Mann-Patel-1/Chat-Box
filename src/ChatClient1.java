import java.io.IOException;
import java.net.Socket;

public class ChatClient1 {
    public static void main(String[] args) {
        try {
            // Connect to the server using its public IP address and port
            Socket socket = new Socket("Public_IP_of_Machine_A", 8080);
            System.out.println("Connected to server");

            // Perform chat communication with the server (not shown in this example)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * Exercise 35: TCP Client-Server Chat
 * CLIENT implementation.
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class E35_ChatClient {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;
    
    public static void main(String[] args) {
        try {
            // Connect to server
            Socket socket = new Socket(HOST, PORT);
            System.out.println("Connected to server!");
            
            // Create input and output streams
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            
            // Scanner for user input
            Scanner scanner = new Scanner(System.in);
            
            // Communication loop
            String messageToServer;
            String messageFromServer;
            
            while (true) {
                System.out.print("Enter message (or 'exit'): ");
                messageToServer = scanner.nextLine();
                writer.println(messageToServer);
                
                if (messageToServer.equalsIgnoreCase("exit")) {
                    break;
                }
                
                messageFromServer = reader.readLine();
                System.out.println(messageFromServer);
            }
            
            // Close resources
            scanner.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

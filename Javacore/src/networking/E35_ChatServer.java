/**
 * Exercise 35: TCP Client-Server Chat
 * Objective: Use Java sockets for TCP communication.
 * 
 * This is the SERVER implementation.
 * Run this first, then run E35_ChatClient in another terminal.
 */
import java.io.*;
import java.net.*;

public class E35_ChatServer {
    private static final int PORT = 5000;
    
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);
            System.out.println("Waiting for a client...");
            
            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");
            
            // Create input and output streams
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            
            // Communication loop
            String receivedMessage;
            while ((receivedMessage = reader.readLine()) != null) {
                System.out.println("Client: " + receivedMessage);
                
                if (receivedMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                
                // Send response
                String response = "Server received: " + receivedMessage;
                writer.println(response);
            }
            
            // Close resources
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * To test, run this in another terminal:
 * javac E35_ChatClient.java
 * java E35_ChatClient
 */

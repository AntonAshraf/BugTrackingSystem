package system;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 12345);
            System.out.println("Connected to server.");

            // Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read messages from the console and send them to the server
            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while ((message = consoleIn.readLine()) != null) {
                out.println(message);
                
                // Receive response from the server
                String serverResponse = in.readLine();
                System.out.println("Server: " + serverResponse);
            }

            // Close connections
            in.close();
            out.close();
            clientSocket.close();
            consoleIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ChatSockets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


public class ClientHandler implements Runnable {

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedReader.readLine();
            broadcastMessage("SERVER: Developer has joined the chat.");
            clientHandlers.add(this);
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);

        }
    }


    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
                    try {
                        messageFromClient = bufferedReader.readLine();
                        broadcastMessage(messageFromClient);
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }


    }


    public void broadcastMessage(final String messageToSend) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (ClientHandler clientHandler : clientHandlers) {
                    try {
                        if (!clientHandler.clientUsername.equals(clientUsername)) {
                            clientHandler.bufferedWriter.write(messageToSend);
                            clientHandler.bufferedWriter.newLine();
                            clientHandler.bufferedWriter.flush();
                        }
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
          });
        thread.start();
    }

    public void removeClientHandler() {
        clientHandlers.remove( this);
        broadcastMessage("SERVER: " + clientUsername + " has left the chat");
    }


    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClientHandler();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            if (socket != null) {
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

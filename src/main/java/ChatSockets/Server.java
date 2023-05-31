package ChatSockets;

import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;

public class Server implements Runnable{

  private ServerSocket serverSocket;

  public Server(ServerSocket serverSocket) {
    this.serverSocket = serverSocket;
  }

  public void startServer() {

      Thread thread = new Thread(new Runnable() {
          @Override
          public void run() {
              try {
                    while (!serverSocket.isClosed()) {
                        Socket socket = serverSocket.accept();
                        System.out.println("A new client has connected");
                        ClientHandler clientHandler = new ClientHandler(socket);

                        Thread thread = new Thread(clientHandler);
                        thread.start();
                    }
                } catch (IOException e) {

                }
          }
        });
      thread.start();
  }

  public void closeServerSocket() {
    try {
      if (serverSocket != null) {
        serverSocket.close();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(1234);
    Server server = new Server(serverSocket);
    server.startServer();
  }

@Override
public void run() {
    try {

          while (true) {

            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected");
            ClientHandler clientHandler = new ClientHandler(socket);

            Thread thread = new Thread(clientHandler);
            thread.start();
          }
        } catch (IOException e) {

        }

}
}

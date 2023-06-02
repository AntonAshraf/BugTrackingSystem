package ChatSockets;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

  private Socket socket;
  private BufferedReader bufferedReader;
  private BufferedWriter bufferedWriter;
  private String username;

  public Client(Socket socket, String username) {
    try {
      this.setSocket(socket);
      this.setBufferedWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
      this.setBufferedReader(new BufferedReader(new InputStreamReader(socket.getInputStream())));
      this.username = username;
    } catch (IOException e) {
      closeEverything(socket, getBufferedReader(), getBufferedWriter());
    }
  }

  public void sendMessage() {

      Thread thread = new Thread(new Runnable() {
          @Override
          public void run() {
              try {
                  getBufferedWriter().write(username);
                  getBufferedWriter().newLine();
                  getBufferedWriter().flush();

                  try (Scanner scanner = new Scanner(System.in)) {
                    while (getSocket().isConnected()) {
                      String messageToSend = scanner.nextLine();
                      getBufferedWriter().write(username + ": " + messageToSend);
                      getBufferedWriter().newLine();
                      getBufferedWriter().flush();
                    }
                  }
                } catch (IOException e) {
                  closeEverything(getSocket(), getBufferedReader(), getBufferedWriter());
                }
          }
        });
      thread.start();
  }

  public void listenForMessage() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        String msgFromGroupChat;

        while (getSocket().isConnected()) {
          try {
            msgFromGroupChat = getBufferedReader().readLine();
            System.out.println(msgFromGroupChat);
          } catch (IOException e) {
            closeEverything(getSocket(), getBufferedReader(), getBufferedWriter());
          }
        }
      }
    }).start();
  }

  public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
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


public BufferedReader getBufferedReader() {
    return bufferedReader;
}

public void setBufferedReader(BufferedReader bufferedReader) {
    this.bufferedReader = bufferedReader;
}

public Socket getSocket() {
    return socket;
}

public void setSocket(Socket socket) {
    this.socket = socket;
}

public BufferedWriter getBufferedWriter() {
    return bufferedWriter;
}

public void setBufferedWriter(BufferedWriter bufferedWriter) {
    this.bufferedWriter = bufferedWriter;
}
}

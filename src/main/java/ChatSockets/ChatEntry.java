package ChatSockets;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Authentication.Auth;
import DB.DataBase;
import EmailSender.SendMail;

public class ChatEntry {
  public static void startChat(final String email) {
    final JFrame ChatFrame = new JFrame("Chat Entry");
    ChatFrame.setSize(300, 100);
    ChatFrame.setVisible(true);
    ChatFrame.setLocationRelativeTo(null);
    ChatFrame.setResizable(false);
    ChatFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ChatFrame.getContentPane().setLayout(null);

    JButton btnJoin = new JButton("Join Room");
    btnJoin.setBounds(90, 15, 100, 25);
    ChatFrame.getContentPane().add(btnJoin);

    btnJoin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ChatFrame.dispose();

        final JFrame JoinFrame = new JFrame("Join Window");
        JoinFrame.setSize(400, 300);
        JoinFrame.setVisible(true);
        JoinFrame.setLocationRelativeTo(null);
        JoinFrame.setResizable(false);
        JoinFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JoinFrame.getContentPane().setLayout(null);

        JLabel JointxtEnterPort = new JLabel();
        JointxtEnterPort.setText("Enter Port:");
        JointxtEnterPort.setBounds(50, 70, 133, 20);
        JoinFrame.getContentPane().add(JointxtEnterPort);

        final JTextField JointxtPortEntry = new JTextField();
        JointxtPortEntry.setBounds(50, 95, 200, 20);
        JoinFrame.getContentPane().add(JointxtPortEntry);
        JointxtPortEntry.setColumns(10);

        JLabel JointxtEnterIP = new JLabel();
        JointxtEnterIP.setText("Enter IP:");
        JointxtEnterIP.setBounds(50, 20, 133, 20);
        JoinFrame.getContentPane().add(JointxtEnterIP);

        final JTextField JointxtIPEntry = new JTextField();
        JointxtIPEntry.setBounds(50, 45, 200, 20);
        JoinFrame.getContentPane().add(JointxtIPEntry);
        JointxtIPEntry.setColumns(10);

        JButton btnJoinRoom = new JButton("Join Room");
        btnJoinRoom.setBounds(210, 200, 125, 25);
        JoinFrame.getContentPane().add(btnJoinRoom);

        btnJoinRoom.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            JoinFrame.dispose();

            final JFrame SearchFrame = new JFrame("Chat Window");
            SearchFrame.setSize(400, 400);
            SearchFrame.setLocationRelativeTo(null);
            SearchFrame.setVisible(true);
            SearchFrame.setResizable(false);
            SearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            SearchFrame.getContentPane().setLayout(null);

            Socket socket = null;
            final String username = DataBase.getIDByName(email, "name", "Developers", "email");
            String IP = JointxtIPEntry.getText();

            int Port = Integer.parseInt(JointxtPortEntry.getText());

            try {
              socket = new Socket(IP, Port);
            } catch (UnknownHostException exception) {
              exception.printStackTrace();
            } catch (IOException exception) {
              exception.printStackTrace();
            }

            final JTextArea outputArea = new JTextArea();
            outputArea.setEditable(false);

            // Create a JTextField for user input
            final JTextField inputField = new JTextField();

            final Client client = new Client(socket, username);
            // client.listenForMessage();
            new Thread(new Runnable() {
              @Override
              public void run() {
                String msgFromGroupChat;

                while (client.getSocket().isConnected()) {
                  try {
                    msgFromGroupChat = client.getBufferedReader().readLine();
                    System.out.println(msgFromGroupChat);
                  } catch (IOException e) {
                    // closeEverything(socket, bufferedReader, bufferedWriter);
                  }
                }
              }
            }).start();

            // Create a JButton for sending the input
            JButton sendButton = new JButton("Send");
            sendButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                final String input = inputField.getText();
                outputArea.append(username + ": " + input + "\n");
                // client.sendMessage();
                Thread thread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                    try {
                      client.getBufferedWriter().flush();
                    } catch (IOException e) {
                      e.printStackTrace();
                    }

                    // while (client.getSocket().isConnected()) {
                    try {
                      client.getBufferedWriter().write(username + ": " + input);
                    } catch (IOException e) {
                      e.printStackTrace();
                    }
                    try {
                      client.getBufferedWriter().newLine();
                    } catch (IOException e) {
                      e.printStackTrace();
                    }
                    try {
                      client.getBufferedWriter().flush();
                    } catch (IOException e) {
                      e.printStackTrace();
                    }
                  }
                }
                );
                thread.start();
                inputField.setText("");
              }
            });

            System.setOut(new PrintStream(new OutputStream() {
              @Override
              public void write(int b) {
                outputArea.append(String.valueOf((char) b));
              }
            }));

            // Create a JPanel to hold the input components
            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new BorderLayout());
            inputPanel.add(inputField, BorderLayout.CENTER);
            inputPanel.add(sendButton, BorderLayout.EAST);

            // Add the JTextArea and input panel to the JFrame
            SearchFrame.getContentPane().setLayout(new BorderLayout());
            SearchFrame.getContentPane().add(new JScrollPane(outputArea), BorderLayout.CENTER);
            SearchFrame.getContentPane().add(inputPanel, BorderLayout.SOUTH);
          }
        });
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(50, 200, 125, 25);
        JoinFrame.getContentPane().add(btnBack);

        btnBack.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            JoinFrame.dispose();
          }
        });
      }
    });
  }

  public static void hostChat(final String email) {
    final JFrame ChatFrame = new JFrame("Chat Entry");
    ChatFrame.setSize(300, 100);
    ChatFrame.setVisible(true);
    ChatFrame.setLocationRelativeTo(null);
    ChatFrame.setResizable(false);
    ChatFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ChatFrame.getContentPane().setLayout(null);

    JButton btnHost = new JButton("Host Room");
    btnHost.setBounds(90, 15, 100, 25);
    ChatFrame.getContentPane().add(btnHost);

    btnHost.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ChatFrame.dispose();

        final JFrame HostFrame = new JFrame("Host Window");
        HostFrame.setSize(400, 300);
        HostFrame.setVisible(true);
        HostFrame.setLocationRelativeTo(null);
        HostFrame.setResizable(false);
        HostFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        HostFrame.getContentPane().setLayout(null);

        JLabel HosttxtEnterIP = new JLabel();
        HosttxtEnterIP.setText("Enter IP:");
        HosttxtEnterIP.setBounds(50, 10, 133, 20);
        HostFrame.getContentPane().add(HosttxtEnterIP);

        final JTextField HosttxtIPEntry = new JTextField();
        HosttxtIPEntry.setBounds(50, 35, 200, 20);
        HostFrame.getContentPane().add(HosttxtIPEntry);
        HosttxtIPEntry.setColumns(10);

        JLabel HosttxtEnterPort = new JLabel();
        HosttxtEnterPort.setText("Enter Port:");
        HosttxtEnterPort.setBounds(50, 70, 133, 20);
        HostFrame.getContentPane().add(HosttxtEnterPort);

        final JTextField HosttxtPortEntry = new JTextField();
        HosttxtPortEntry.setBounds(50, 95, 200, 20);
        HostFrame.getContentPane().add(HosttxtPortEntry);
        HosttxtPortEntry.setColumns(10);

        JLabel HosttxtEnterDev = new JLabel();
        HosttxtEnterDev.setText("Choose Developer:");
        HosttxtEnterDev.setBounds(50, 130, 180, 20);
        HostFrame.getContentPane().add(HosttxtEnterDev);

        List<String> Devs = DataBase.getColumnValues("name", "Developers");
        String Devarray[] = new String[Devs.size()];
        for (int j = 0; j < Devs.size(); j++) {
          Devarray[j] = Devs.get(j);
        }

        final JComboBox DevsCombo = new JComboBox(Devarray);
        DevsCombo.setSelectedIndex(0);
        DevsCombo.setBounds(50, 155, 200, 20);
        HostFrame.getContentPane().add(DevsCombo);

        JButton btnHostRoom = new JButton("Host Room");
        btnHostRoom.setBounds(210, 200, 125, 25);
        HostFrame.getContentPane().add(btnHostRoom);

        btnHostRoom.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            HostFrame.dispose();
            if (HosttxtIPEntry.getText().equals("") || HosttxtPortEntry.getText().equals("")) {
              JOptionPane.showMessageDialog(null, "Please enter all fields");
              return;
            }
            String IP = HosttxtIPEntry.getText();
            int Port = Integer.parseInt(HosttxtPortEntry.getText());
            String DevName = (String) DevsCombo.getSelectedItem();

            Thread thread = new Thread(new Runnable() {
              @Override
              public void run() {
                try {
                  SendMail.sendEmail(DevName, email, IP, Port);
                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            });

            thread.start();

            try {
              ServerSocket serverSocket = new ServerSocket(Port);
              Server server = new Server(serverSocket);
              server.startServer();
            } catch (IOException exception) {
              exception.printStackTrace();
            }

            final JFrame SearchFrame = new JFrame("Chat window");
            SearchFrame.setSize(400, 400);
            SearchFrame.setLocationRelativeTo(null);
            SearchFrame.setVisible(true);
            SearchFrame.setResizable(false);
            SearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            SearchFrame.getContentPane().setLayout(null);

            final JTextArea outputArea = new JTextArea();
            outputArea.setEditable(false);

            // Create a JTextField for user input
            final JTextField inputField = new JTextField();

            Socket socket = null;
            final String username = DataBase.getIDByName(email, "name", "Testers", "email");
            try {
              socket = new Socket("localhost", Port);
            } catch (UnknownHostException exception) {
              exception.printStackTrace();
            } catch (IOException exception) {
              exception.printStackTrace();
            }
            final Client client = new Client(socket, username);
            client.listenForMessage();

            JButton sendButton = new JButton("Send");
            sendButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                final String input = inputField.getText();
                outputArea.append(username + ": " + input + "\n");
                Thread thread = new Thread(new Runnable() {
                  @Override
                  public void run() {

                    try {
                      client.getBufferedWriter().flush();
                    } catch (IOException e) {
                      e.printStackTrace();
                    }

                    try {
                      client.getBufferedWriter().write(username + ": " + input);
                    } catch (IOException e) {
                      e.printStackTrace();
                    }
                    try {
                      client.getBufferedWriter().newLine();
                    } catch (IOException e) {
                      e.printStackTrace();
                    }
                    try {
                      client.getBufferedWriter().flush();
                    } catch (IOException e) {
                      e.printStackTrace();
                    }

                  }
                }

                );
                thread.start();
                inputField.setText("");
              }
            });

            System.setOut(new PrintStream(new OutputStream() {
              @Override
              public void write(int b) {
                outputArea.append(String.valueOf((char) b));
              }
            }));

            // Create a JPanel to hold the input components
            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new BorderLayout());
            inputPanel.add(inputField, BorderLayout.CENTER);
            inputPanel.add(sendButton, BorderLayout.EAST);

            // Add the JTextArea and input panel to the JFrame
            SearchFrame.getContentPane().setLayout(new BorderLayout());
            SearchFrame.getContentPane().add(new JScrollPane(outputArea), BorderLayout.CENTER);
            SearchFrame.getContentPane().add(inputPanel, BorderLayout.SOUTH);

          }
        });
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(50, 200, 125, 25);
        HostFrame.getContentPane().add(btnBack);

        btnBack.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            HostFrame.dispose();
          }
        });
      }
    });
  }
}

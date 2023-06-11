package GUI;

import Authentication.Auth;
import DB.DataBase;
import java.util.Random;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;

public class AuthGUI extends JFrame {

  HomePage home = new HomePage();

  private JTextField SignUptxtName;
  private JTextField SignUptxtPassword;
  private JTextField SignUptxtEmail;
  private JLabel SignUptxtEnterYourName;
  private JLabel SignUptxtEnterYourPassword;
  private JLabel SignUptxtEnterYourEmail;
  private JLabel SignUptxtEnterYourRole;
  private JTextField LogIntxtEmail;
  private JTextField LogIntxtPassword;
  private JLabel LogIntxtEnterYourEmail;
  private JLabel LogIntxtEnterYourPassword;
  private JLabel LogIntxtEnterYourRole;
  private int timeout_fail = 0;
  public void signup() {
    final JFrame SignUpFrame = new JFrame("Sign Up");

    SignUpFrame.setLocation(710, 340);
    SignUpFrame.setSize(500, 400);
    SignUpFrame.setLocationRelativeTo(null);
    SignUpFrame.setVisible(true);
    SignUpFrame.setResizable(false);
    SignUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SignUpFrame.getContentPane().setLayout(null);

    SignUptxtName = new JTextField();
    SignUptxtName.setBounds(25, 35, 200, 20);
    SignUpFrame.getContentPane().add(SignUptxtName);
    SignUptxtName.setColumns(10);

    SignUptxtEmail = new JTextField();
    SignUptxtEmail.setBounds(25, 85, 200, 20);
    SignUpFrame.getContentPane().add(SignUptxtEmail);
    SignUptxtEmail.setColumns(10);

    SignUptxtPassword = new JPasswordField();
    SignUptxtPassword.setBounds(25, 135, 200, 20);
    SignUpFrame.getContentPane().add(SignUptxtPassword);
    SignUptxtPassword.setColumns(10);

    JButton btnSubmit = new JButton("Sign Up");
    btnSubmit.setBounds(350, 300, 90, 25);
    SignUpFrame.getContentPane().add(btnSubmit);

    SignUptxtEnterYourName = new JLabel();
    SignUptxtEnterYourName.setText("Enter your Name:");
    SignUptxtEnterYourName.setBounds(25, 10, 133, 20);
    SignUpFrame.getContentPane().add(SignUptxtEnterYourName);

    SignUptxtEnterYourEmail = new JLabel();
    SignUptxtEnterYourEmail.setText("Enter your E-mail:");
    SignUptxtEnterYourEmail.setBounds(25, 60, 133, 20);

    SignUpFrame.getContentPane().add(SignUptxtEnterYourEmail);

    SignUptxtEnterYourPassword = new JLabel();
    SignUptxtEnterYourPassword.setText("Enter your Password :");
    SignUptxtEnterYourPassword.setBounds(25, 110, 133, 20);
    SignUpFrame.getContentPane().add(SignUptxtEnterYourPassword);

    SignUptxtEnterYourRole = new JLabel();
    SignUptxtEnterYourRole.setText("Choose your Role:");
    SignUptxtEnterYourRole.setBounds(25, 160, 133, 20);
    SignUpFrame.getContentPane().add(SignUptxtEnterYourRole);

    String[] UserOptions = { "Tester", "Developer", "Project Manager", "Admin" };

    final JComboBox UserList = new JComboBox(UserOptions);
    UserList.setSelectedIndex(0);
    UserList.setBounds(25, 185, 200, 30);
    SignUpFrame.getContentPane().add(UserList);

    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = SignUptxtName.getText();
        String id = "";
        String password = SignUptxtPassword.getText();
        String email = SignUptxtEmail.getText();
        String role = (String) UserList.getSelectedItem();
        String Table = "";
        String userType = "";

        if (role == "Tester") {
          Table = "Testers";
          userType = "Tester";
        } else if (role == "Developer") {
          Table = "Developers";
          userType = "Developer";
        } else if (role == "Project Manager") {
          Table = "ProjectManagers";
          userType = "Project Manager";
        } else if (role == "Admin") {
          Table = "Admins";
          userType = "Admin";
        }
        if (name.equals("") || password.equals("") || email.equals("")) {
          JOptionPane.showMessageDialog(SignUpFrame, "Please fill all the fields.", "Error!",
              JOptionPane.WARNING_MESSAGE);
          return;
        } else if (Auth.isValidEmail(email) == false) {
          JOptionPane.showMessageDialog(SignUpFrame, "Invalid Email.", "Error!", JOptionPane.WARNING_MESSAGE);
          return;
        } else if (Auth.isExist("email", email, Table)) {
          JOptionPane.showMessageDialog(SignUpFrame, "This Email is already exist.", "Error!",
              JOptionPane.WARNING_MESSAGE);
          return;
        }
        Boolean loggedin = false;
        int timeout_fail = 0;
        do {
          // Create a Random object
          Random random = new Random();
          // Generate a random ID number between 0 and 999 (inclusive)
          id = String.valueOf(random.nextInt(1000));
          loggedin = DataBase.insertData(name, id, password, email, Table);
          timeout_fail++;
          if (timeout_fail == 5) {
            break;
          }
        } while (loggedin == false);

        if (loggedin) {
          SignUpFrame.dispose();
          UserGUI.UserPage(userType, name, id, email);
          javax.swing.JOptionPane.showMessageDialog(null, "Welcome " + name + " to our system!", "Welcome!",
              javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(SignUpFrame, "Please make sure that you are connected to the internet",
              "Error!", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    JButton btnBack = new JButton("Back");
    btnBack.setBounds(50, 300, 90, 25);
    SignUpFrame.getContentPane().add(btnBack);

    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        SignUpFrame.dispose();
        home.homePage();
      }
    });
  }

  public void login() {
    final JFrame LogInFrame = new JFrame("Login");
    
    LogInFrame.setLocation(710, 340);
    LogInFrame.setSize(500, 400);
    LogInFrame.setLocationRelativeTo(null);
    LogInFrame.setVisible(true);
    LogInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    LogInFrame.setResizable(false);
    LogInFrame.getContentPane().setLayout(null);

    LogIntxtEmail = new JTextField();
    LogIntxtEmail.setBounds(25, 35, 200, 20);
    LogInFrame.getContentPane().add(LogIntxtEmail);
    LogIntxtEmail.setColumns(10);

    LogIntxtPassword = new JPasswordField();
    LogIntxtPassword.setBounds(25, 85, 200, 20);
    LogInFrame.getContentPane().add(LogIntxtPassword);
    LogIntxtPassword.setColumns(10);

    JButton btnSubmitdvl = new JButton("Log In");
    btnSubmitdvl.setBounds(350, 300, 90, 25);
    LogInFrame.getContentPane().add(btnSubmitdvl);

    LogIntxtEnterYourEmail = new JLabel();
    LogIntxtEnterYourEmail.setText("Enter your E-mail:");
    LogIntxtEnterYourEmail.setBounds(25, 10, 133, 20);
    LogInFrame.getContentPane().add(LogIntxtEnterYourEmail);

    LogIntxtEnterYourPassword = new JLabel();
    LogIntxtEnterYourPassword.setText("Enter your Password :");
    LogIntxtEnterYourPassword.setBounds(25, 60, 133, 20);
    LogInFrame.getContentPane().add(LogIntxtEnterYourPassword);

    LogIntxtEnterYourRole = new JLabel();
    LogIntxtEnterYourRole.setText("Choose your Role:");
    LogIntxtEnterYourRole.setBounds(25, 110, 133, 20);
    LogInFrame.getContentPane().add(LogIntxtEnterYourRole);

    String[] UserOptions = { "Tester", "Developer", "Project Manager", "Admin" };

    final JComboBox UserList = new JComboBox(UserOptions);
    UserList.setSelectedIndex(0);
    UserList.setBounds(25, 135, 200, 30);
    LogInFrame.getContentPane().add(UserList);

    btnSubmitdvl.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String email = LogIntxtEmail.getText();
        String password = LogIntxtPassword.getText();
        String role = (String) UserList.getSelectedItem();
        String Table = "";
        String userType = "";

        if (role == "Tester") {
          Table = "Testers";
          userType = "Tester";
        } else if (role == "Developer") {
          Table = "Developers";
          userType = "Developer";
        } else if (role == "Project Manager") {
          Table = "ProjectManagers";
          userType = "Project Manager";
        } else if (role == "Admin") {
          Table = "Admins";
          userType = "Admin";
        }
        if (email.equals("") || password.equals("")) {
          JOptionPane.showMessageDialog(LogInFrame, "Please fill all the fields.", "Error!",
              JOptionPane.WARNING_MESSAGE);
          return;
        }
        Boolean loggedIn = false;

        loggedIn = Auth.authenticateUser(email, password, Table);


        if (loggedIn) {
          LogInFrame.dispose();
          System.out.println("Found");
          timeout_fail = 0;
          UserGUI.UserPage(userType, "null", "-1", email);
        } else if (timeout_fail > 2) {
          JOptionPane.showMessageDialog(LogInFrame, "Please make sure that you are connected to the internet", "Error!",
              JOptionPane.WARNING_MESSAGE);
        } else {
          System.out.println("Not found");
          JOptionPane.showMessageDialog(LogInFrame, "Invalid E-Mail or Password.", "Error!",
              JOptionPane.WARNING_MESSAGE);
          timeout_fail++;
        }
      }
    });
    JButton btnBack = new JButton("Back");
    btnBack.setBounds(50, 300, 90, 25);
    LogInFrame.getContentPane().add(btnBack);

    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        LogInFrame.dispose();
        home.homePage();
      }
    });
  }

  public void info() {
    final JFrame InfoFrame = new JFrame("Info");

    InfoFrame.setLocation(710, 340);
    InfoFrame.setSize(500, 400);
    InfoFrame.setLocationRelativeTo(null);
    InfoFrame.setVisible(true);
    InfoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    InfoFrame.setResizable(false);
    InfoFrame.getContentPane().setLayout(null);
    InfoFrame.getContentPane().setBackground(Color.WHITE);

    // make the description in the center and well formed
    JTextArea textArea = new JTextArea();
    textArea.setBounds(25, 35, 450, 100);
    String Description = "The Bug Tracking System project is a comprehensive software application developed in Java that enables efficient tracking and management of bugs in software development. It leverages object-oriented programming principles to create a robust and scalable bug tracking solution. By utilizing the features and technologies mentioned earlier, it offers a wide range of capabilities for bug monitoring, assignment, and reporting.";
    // write the description in the text area as a string
    textArea.setText(Description);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setOpaque(false);
    textArea.setEditable(false);
    InfoFrame.getContentPane().add(textArea);

    JEditorPane editorPane = new JEditorPane();
    editorPane.setContentType("text/html"); // Set content type to HTML
    editorPane.setEditable(false);

    // Set the HTML content with the clickable link
    String link = "<html><body><a href=\"https://github.com/AntonAshraf/BugTrackingSystem\">GitHub Repository</a></body></html>";
    editorPane.setText(link);

    // Add a HyperlinkListener to handle link clicks
    editorPane.addHyperlinkListener(new HyperlinkListener() {
      @Override
      public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
          // Handle the link click event
          try {
            Desktop.getDesktop().browse(new URI(e.getURL().toString()));
          } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
          }
        }
      }
    });

    JScrollPane scrollPane = new JScrollPane(editorPane);
    scrollPane.setBounds(25, 200, 200, 50);
    scrollPane.setBorder(BorderFactory.createEmptyBorder());
    InfoFrame.getContentPane().add(scrollPane);

    JButton btnBack = new JButton("Back");
    btnBack.setBounds(50, 300, 90, 25);
    InfoFrame.getContentPane().add(btnBack);

    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        InfoFrame.dispose();
        home.homePage();
      }
    });
  }

}

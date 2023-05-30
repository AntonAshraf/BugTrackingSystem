package GUI;

import Authentication.Auth;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;



public class AuthGUI extends JFrame{
	
  HomePage home = new HomePage();

  private JTextField SignUptxtName;
  private JTextField SignUptxtId;
  private JTextField SignUptxtPassword;
  private JTextField SignUptxtEmail;
  private JLabel SignUptxtEnterYourName;
  private JLabel SignUptxtEnterYourId;
  private JLabel SignUptxtEnterYourPassword;
  private JLabel SignUptxtEnterYourEmail;
  private JLabel SignUptxtEnterYourRole;
  private JTextField LogIntxtEmail;
  private JTextField LogIntxtPassword;
  private JLabel LogIntxtEnterYourEmail;
  private JLabel LogIntxtEnterYourPassword;
  private JLabel LogIntxtEnterYourRole;

  public void signup() {
    final JFrame SignUpFrame = new JFrame("Sign Up");

    SignUpFrame.setLocation(710, 340);
    SignUpFrame.setSize(500, 400);
    SignUpFrame.setVisible(true);
    SignUpFrame.setResizable(false);
    SignUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SignUpFrame.getContentPane().setLayout(null);
    
    	
    SignUptxtName = new JTextField();
    SignUptxtName.setBounds(25, 35, 200, 20);
    SignUpFrame.getContentPane().add(SignUptxtName);
    SignUptxtName.setColumns(10);

    SignUptxtId = new JTextField();
    SignUptxtId.setBounds(25, 85, 200, 20);
    SignUpFrame.getContentPane().add(SignUptxtId);
    SignUptxtId.setColumns(10);

    SignUptxtPassword = new JPasswordField();
    SignUptxtPassword.setBounds(25, 135, 200, 20);
    SignUpFrame.getContentPane().add(SignUptxtPassword);
    SignUptxtPassword.setColumns(10);

    SignUptxtEmail = new JTextField();
    SignUptxtEmail.setBounds(25, 185, 200, 20);
    SignUpFrame.getContentPane().add(SignUptxtEmail);
    SignUptxtEmail.setColumns(10);

    JButton btnSubmit = new JButton("Sign Up");
    btnSubmit.setBounds(350, 300, 90, 25);
    SignUpFrame.getContentPane().add(btnSubmit);

    SignUptxtEnterYourName = new JLabel();
    SignUptxtEnterYourName.setText("Enter your Name:");
    SignUptxtEnterYourName.setBounds(25, 10, 133, 20);
    SignUpFrame.getContentPane().add(SignUptxtEnterYourName);

    SignUptxtEnterYourId = new JLabel();
    SignUptxtEnterYourId.setText("Enter your ID:");
    SignUptxtEnterYourId.setBounds(25, 60, 133, 20);
    SignUpFrame.getContentPane().add(SignUptxtEnterYourId);

    SignUptxtEnterYourPassword = new JLabel();
    SignUptxtEnterYourPassword.setText("Enter your Password :");
    SignUptxtEnterYourPassword.setBounds(25, 110, 133, 20);
    SignUpFrame.getContentPane().add(SignUptxtEnterYourPassword);

    SignUptxtEnterYourEmail = new JLabel();
    SignUptxtEnterYourEmail.setText("Enter your E-mail:");
    SignUptxtEnterYourEmail.setBounds(25, 160, 133, 20);
    SignUpFrame.getContentPane().add(SignUptxtEnterYourEmail);
    
    SignUptxtEnterYourRole = new JLabel();
    SignUptxtEnterYourRole.setText("Choose your Role:");
    SignUptxtEnterYourRole.setBounds(25, 210, 133, 20);
    SignUpFrame.getContentPane().add(SignUptxtEnterYourRole);
    
    String[] UserOptions = {"Tester", "Developer", "Project Manager", "Admin"};

    final JComboBox UserList = new JComboBox(UserOptions);
    UserList.setSelectedIndex(0);
    UserList.setBounds(25, 235, 200, 30);
    SignUpFrame.getContentPane().add(UserList);
    
    

    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	String name = SignUptxtName.getText();
        String id = SignUptxtId.getText();
        String password = SignUptxtPassword.getText();
        String email = SignUptxtEmail.getText();
        String role = (String) UserList.getSelectedItem();
        String Table = "";
        String userType = "";
        
        if(role == "Tester") {
        	Table = "Testers";
        	userType = "Tester";
        }else if(role == "Developer") {
        	Table = "Developers";
        	userType = "Developer";
        }else if(role == "Project Manager") {
        	Table = "ProjectManagers";
        	userType = "Project Manager";
        }else if(role == "Admin") {
        	Table = "Admins";
        	userType = "Admin";
        }

        Boolean x = Auth.insertData(name, id, password, email, Table);
        if (x) {
          SignUpFrame.dispose();
          System.out.println("Data inserted successfully!");
          UserGUI.UserPage(userType, name, id, email);

        } else {
        	JOptionPane.showMessageDialog(SignUpFrame, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);

        }
        SignUptxtName.setText("");
        SignUptxtId.setText("");
        SignUptxtPassword.setText("");
        SignUptxtEmail.setText("");
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
    
    String[] UserOptions = {"Tester", "Developer", "Project Manager", "Admin"};

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
          
          if(role == "Tester") {
          	Table = "Testers";
          	userType = "Tester";
          }else if(role == "Developer") {
          	Table = "Developers";
          	userType = "Developer";
          }else if(role == "Project Manager") {
          	Table = "ProjectManagers";
          	userType = "Project Manager";
          }else if(role == "Admin") {
          	Table = "Admins";
          	userType = "Admin";
          }

          boolean found = Auth.authenticateUser(email, password, Table);

          if (found) {
        	LogInFrame.dispose();
        	System.out.println("Found");
            UserGUI.UserPage(userType,"null", "-1", email);
          } else {
            System.out.println("Not found");
            JOptionPane.showMessageDialog(LogInFrame, "Invalid E-Mail or Password.","Error!",JOptionPane.WARNING_MESSAGE);
          }
          LogIntxtEmail.setText("");
          LogIntxtPassword.setText("");
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
}

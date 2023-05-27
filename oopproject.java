package oopproject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.kerberos.KerberosKey;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import system.Developer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class J extends JFrame {

  // sign up setup

  private JPanel contentPane;
  private DefaultTableModel tableModel;
  private JFrame devFrame;
  private JTextField devtxtName;
  private JTextField devtxtId;
  private JTextField devtxtPhone;
  private JTextField devtxtEmail;
  private JTextField devtxtEnterYourName;
  private JTextField devtxtEnterYourAge;
  private JTextField devtxtEnterYourId;
  private JTextField devtxtEnterYourEmail;
  private JButton devBtnSubmit;
  private JButton devBtnViewData;
  private JTable devtable;
  private DefaultTableModel devTableModel;

  private JTextField protxtName;
  private JTextField protxtId;
  private JTextField protxtEnterYourName;
  private JTextField protxtEnterYourAge;
  private JTextField protxtEnterYourId;
  private JTextField protxtEnterYourEmail;

  private JTextField adtxtName;
  private JTextField adtxtId;
  private JTextField adtxtPhone;
  private JTextField adtxtEmail;
  private JTextField adtxtEnterYourName;
  private JTextField adtxtEnterYourAge;
  private JTextField adtxtEnterYourId;
  private JTextField adtxtEnterYourEmail;

  private JTextField tsttxtName;
  private JTextField tsttxtId;
  private JTextField tsttxtPhone;
  private JTextField tsttxtEmail;
  private JTextField tsttxtEnterYourName;
  private JTextField tsttxtEnterYourAge;
  private JTextField tsttxtEnterYourId;
  private JTextField tsttxtEnterYourEmail;
  private JButton tstBtnSubmit;

  // login setup
  private JTextField adltxtName;
  private JTextField adltxtId;
  private JTextField adltxtEnterYourName;
  private JTextField adltxtEnterYourAge;
  private JTextField adltxtEnterYourId;
  private JTextField adltxtEnterYourEmail;

  private JTextField dvltxtName;
  private JTextField dvltxtId;
  private JTextField dvltxtEnterYourName;
  private JTextField dvltxtEnterYourAge;
  private JTextField dvltxtEnterYourId;
  private JTextField dvltxtEnterYourEmail;

  private JTextField teltxtName;
  private JTextField teltxtId;
  private JTextField teltxtEnterYourName;
  private JTextField teltxtEnterYourAge;
  private JTextField teltxtEnterYourId;
  private JTextField teltxtEnterYourEmail;

  private JTextField prostxtName;
  private JTextField prostxtId;
  private JTextField prostxtPhone;
  private JTextField prostxtEmail;
  private JTextField prostxtEnterYourName;
  private JTextField prostxtEnterYourAge;
  private JTextField prostxtEnterYourId;
  private JTextField prostxtEnterYourEmail;

  // MySQL database connection parameters
  private static final String DB_URL = "jdbc:mysql://localhost/oopdata"; // Replace "mydatabase" with your actual
                                                                         // database name
  private static final String DB_USERNAME = "root";
  private static final String DB_PASSWORD = "tony";


  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          J frame = new J();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public J() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 514, 356);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JButton btnsignup = new JButton("sign up");
    btnsignup.setBounds(176, 94, 130, 23);
    contentPane.add(btnsignup);

    JButton btnlogin = new JButton("login");
    btnlogin.setBounds(176, 194, 130, 23);
    contentPane.add(btnlogin);

    btnlogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        login();
      }
    });

    btnsignup.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        signup();
      }
    });

  }
  
  private boolean searchInDB(String email, String password, String table) {
    // Establish database connection and execute query
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
         Statement statement = connection.createStatement()) {
        // Construct the query to search for email and password in the table "projectma"
        String query = "SELECT * FROM "+ table +" WHERE email = '" + email + "' AND password = '" + password + "'";
        
        // Execute the query
        ResultSet resultSet = statement.executeQuery(query);
        
        // Check if any rows were returned
        if (resultSet.next()) {
            return true; // Email and password were found in the database
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return false; // Email and password were not found in the database
}

  private boolean insertData(String name, String id, String password, String email, String table) {
    try {
      Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

      String query = "INSERT INTO " + table + " (id, name, email, password) VALUES (?, ?, ?, ?)";

      PreparedStatement statement = conn.prepareStatement(query);
      statement.setString(1, id);
      statement.setString(2, name);
      statement.setString(3, email);
      statement.setString(4, password);

      int rowsInserted = statement.executeUpdate();

      statement.close();
      conn.close();

      if (rowsInserted > 0) {
        System.out.println("Data inserted successfully!");
        return true;
      } else {
        System.out.println("Data insertion failed!");
        return false;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      return false;
    }
  }

  private void projectmanager() {
    JFrame prowFrame = new JFrame("project manager window");
    // Customize the "A" frame here if needed

    prowFrame.setSize(400, 300);
    prowFrame.setVisible(true);

    prowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    prowFrame.getContentPane().setLayout(null);
  }

  private void developer() {
    JFrame devwFrame = new JFrame("Developer window");
    // Customize the "A" frame here if needed

    devwFrame.setSize(400, 300);
    devwFrame.setVisible(true);

    devwFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    devwFrame.getContentPane().setLayout(null);
  }

  private void admin() {
    JFrame adwFrame = new JFrame("Admin window");
    // Customize the "A" frame here if needed

    adwFrame.setSize(400, 300);
    adwFrame.setVisible(true);

    adwFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    adwFrame.getContentPane().setLayout(null);
  }

  private void tester() {
    JFrame testerFrame = new JFrame("Tester window");
    // Customize the "A" frame here if needed

    testerFrame.setSize(400, 300);
    testerFrame.setVisible(true);

    testerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    testerFrame.getContentPane().setLayout(null);

    JButton btnbug = new JButton("add bug");
    btnbug.setBounds(45, 218, 104, 23);
    testerFrame.getContentPane().add(btnbug);
  }

  public void UserPage(String UserType, String name, String id, String email) {
    if (UserType.equals("Project Manager")) {
      projectmanager();
    } else if (UserType.equals("Developer")) {
      developer();
    } else if (UserType.equals("Admin")) {
      admin();
    } else if (UserType.equals("Tester")) {
      tester();
    }
  }

  private void signup() {
    JFrame upFrame = new JFrame("sign up");
    // Customize the "A" frame here if needed

    upFrame.setSize(500, 500);
    upFrame.setVisible(true);

    upFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    upFrame.getContentPane().setLayout(null);

    JButton btndev = new JButton("Developer");
    btndev.setBounds(10, 94, 130, 23);
    upFrame.getContentPane().add(btndev);

    JButton btntst = new JButton("Tester");
    btntst.setBounds(300, 94, 130, 23);
    upFrame.getContentPane().add(btntst);

    JButton btnpro = new JButton("project manager");
    btnpro.setBounds(10, 194, 130, 23);
    upFrame.getContentPane().add(btnpro);

    JButton btnad = new JButton("admin");
    btnad.setBounds(300, 194, 130, 23);
    upFrame.getContentPane().add(btnad);

    btndev.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        signupPage("Developer", "user");
      }
    });

    btnad.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        signupPage("Admin", "admindata");
      }
    });

    btnpro.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        signupPage("Project Manager", "projectma");
      }
    });

    btntst.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        signupPage("Tester", "tester");
      }
    });
  }

  public void signupPage(String userType, String Table) {

    JFrame adFrame = new JFrame(userType + " Sign Up");

    adFrame.setSize(400, 300);
    adFrame.setVisible(true);

    adFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    adFrame.getContentPane().setLayout(null);

    adtxtName = new JTextField();
    adtxtName.setToolTipText("");
    adtxtName.setBounds(225, 11, 86, 20);
    adFrame.getContentPane().add(adtxtName);
    adtxtName.setColumns(10);

    adtxtId = new JTextField();
    adtxtId.setHorizontalAlignment(JTextField.LEFT);
    adtxtId.setBounds(225, 54, 86, 20);
    adFrame.getContentPane().add(adtxtId);
    adtxtId.setColumns(10);

    adtxtPhone = new JTextField();
    adtxtPhone.setBounds(225, 95, 86, 20);
    adFrame.getContentPane().add(adtxtPhone);
    adtxtPhone.setColumns(10);

    adtxtEmail = new JTextField();
    adtxtEmail.setBounds(225, 143, 86, 20);
    adFrame.getContentPane().add(adtxtEmail);
    adtxtEmail.setColumns(10);

    JButton btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(145, 218, 104, 23);
    adFrame.getContentPane().add(btnSubmit);

    adtxtEnterYourName = new JTextField();
    adtxtEnterYourName.setText("Enter your name:");
    adtxtEnterYourName.setEditable(false);
    adtxtEnterYourName.setBounds(25, 11, 133, 20);
    adFrame.getContentPane().add(adtxtEnterYourName);
    adtxtEnterYourName.setColumns(10);

    adtxtEnterYourAge = new JTextField();
    adtxtEnterYourAge.setText("Enter your id:");
    adtxtEnterYourAge.setEditable(false);
    adtxtEnterYourAge.setColumns(10);
    adtxtEnterYourAge.setBounds(25, 54, 133, 20);
    adFrame.getContentPane().add(adtxtEnterYourAge);

    adtxtEnterYourId = new JTextField();
    adtxtEnterYourId.setText("Enter your password :");
    adtxtEnterYourId.setEditable(false);
    adtxtEnterYourId.setColumns(10);
    adtxtEnterYourId.setBounds(25, 95, 133, 20);
    adFrame.getContentPane().add(adtxtEnterYourId);

    adtxtEnterYourEmail = new JTextField();
    adtxtEnterYourEmail.setText("Enter your email:");
    adtxtEnterYourEmail.setEditable(false);
    adtxtEnterYourEmail.setColumns(10);
    adtxtEnterYourEmail.setBounds(25, 143, 133, 20);
    adFrame.getContentPane().add(adtxtEnterYourEmail);

    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = adtxtName.getText();
        String id = adtxtId.getText();
        String password = adtxtPhone.getText();
        String email = adtxtEmail.getText();

        Boolean x = insertData(name, id, password, email, Table);
        if (x) {

          System.out.println("Data inserted successfully!");
          UserPage(userType, name, id, email);

        } else {
          JButton btnSubmittt = new JButton("Invalid data, try again");
          btnSubmittt.setBounds(125, 180, 174, 23);
          adFrame.getContentPane().add(btnSubmittt);
        }
        // Clear the text fields after submitting
        adtxtName.setText("");
        adtxtId.setText("");
        adtxtPhone.setText("");
        adtxtEmail.setText("");
      }
    });
  }

  public void loginPage (String userType, String Table) {
    JFrame dvlFrame = new JFrame(userType + " Login");
        // Customize the "A" frame here if needed

        dvlFrame.setSize(400, 300);
        dvlFrame.setVisible(true);

        dvlFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        dvlFrame.getContentPane().setLayout(null);

        dvltxtName = new JTextField();
        dvltxtName.setToolTipText("");
        dvltxtName.setBounds(225, 11, 86, 20);
        dvlFrame.getContentPane().add(dvltxtName);
        dvltxtName.setColumns(10);

        dvltxtId = new JTextField();
        dvltxtId.setHorizontalAlignment(JTextField.LEFT);
        dvltxtId.setBounds(225, 54, 86, 20);
        dvlFrame.getContentPane().add(dvltxtId);
        dvltxtId.setColumns(10);

        dvltxtEnterYourName = new JTextField();
        dvltxtEnterYourName.setText("Enter your email:");
        dvltxtEnterYourName.setEditable(false);
        dvltxtEnterYourName.setBounds(25, 11, 133, 20);
        dvlFrame.getContentPane().add(dvltxtEnterYourName);
        dvltxtEnterYourName.setColumns(10);

        dvltxtEnterYourAge = new JTextField();
        dvltxtEnterYourAge.setText("Enter your password:");
        dvltxtEnterYourAge.setEditable(false);
        dvltxtEnterYourAge.setColumns(10);
        dvltxtEnterYourAge.setBounds(25, 54, 133, 20);
        dvlFrame.getContentPane().add(dvltxtEnterYourAge);

        JButton btnSubmitdvl = new JButton("Submit");
        btnSubmitdvl.setBounds(145, 218, 104, 23);
        dvlFrame.getContentPane().add(btnSubmitdvl);

        btnSubmitdvl.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String email = dvltxtName.getText();
            String password = dvltxtId.getText();

            // Execute database query to check if email and password exist
            boolean found = searchInDB(email, password, Table);

            // Display result based on whether email and password were found
            if (found) {
              System.out.println("Found");
              developer();
            } else {
              System.out.println("Not found");
              JButton btnSubmitdvll = new JButton("Wrong please sign up");
              btnSubmitdvll.setBounds(100, 118, 204, 23);
              dvlFrame.getContentPane().add(btnSubmitdvll);
            }
          }
        });

  }
  
  private void login() {
    JFrame logFrame = new JFrame("login");
    // Customize the "A" frame here if needed

    logFrame.setSize(500, 500);
    logFrame.setVisible(true);

    logFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    logFrame.getContentPane().setLayout(null);

    JButton btnProjectManager = new JButton("project manager");
    btnProjectManager.setBounds(10, 94, 130, 23);
    logFrame.getContentPane().add(btnProjectManager);

    JButton btnadmin = new JButton("admin");
    btnadmin.setBounds(339, 94, 130, 23);
    logFrame.getContentPane().add(btnadmin);

    JButton btndevl = new JButton("developer");
    btndevl.setBounds(10, 194, 130, 23);
    logFrame.getContentPane().add(btndevl);

    JButton btntstl = new JButton("tester");
    btntstl.setBounds(339, 194, 130, 23);
    logFrame.getContentPane().add(btntstl);

    btntstl.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       loginPage("Tester", "tester");
      }
    });

    btndevl.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       loginPage("Developer", "user");
      }
    });

    btnProjectManager.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       loginPage("Project Manager", "projectma");
      }
    });

    btnadmin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        loginPage("Admin", "admindata");
      }  
    });
  }

}

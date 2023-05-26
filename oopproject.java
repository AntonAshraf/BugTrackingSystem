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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class J extends JFrame {

	
	//sign up setup
	
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
    private static final String DB_URL = "jdbc:mysql://localhost/oopdata"; // Replace "mydatabase" with your actual database name
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "tmsa7";

    /**
     * Launch the application.
     */
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
    
    
    private boolean searchInDatabasepro(String email, String password) {
        // Establish database connection and execute query
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            // Construct the query to search for email and password in the table "projectma"
            String query = "SELECT * FROM projectma WHERE email = '" + email + "' AND password = '" + password + "'";
            
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
    
    private boolean searchInDatabasetst(String email, String password) {
        // Establish database connection and execute query
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            // Construct the query to search for email and password in the table "projectma"
            String query = "SELECT * FROM tester WHERE email = '" + email + "' AND password = '" + password + "'";
            
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
    
    private boolean searchInDatabasead(String email, String password) {
        // Establish database connection and execute query
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            // Construct the query to search for email and password in the table "projectma"
            String query = "SELECT * FROM admindata WHERE email = '" + email + "' AND password = '" + password + "'";
            
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
    
    private boolean searchInDatabasedev(String email, String password) {
        // Establish database connection and execute query
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            // Construct the query to search for email and password in the table "projectma"
            String query = "SELECT * FROM user WHERE email = '" + email + "' AND password = '" + password + "'";
            
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
    
    private void insertData(String name, String id, String password, String email) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "INSERT INTO user (id, name, email, password) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, password);

            statement.executeUpdate();

            statement.close();
            conn.close();

            System.out.println("Data inserted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void insertDatapro(String name, String id, String password, String email) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "INSERT INTO projectma (id, name, email, password) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, password);

            statement.executeUpdate();

            statement.close();
            conn.close();

            System.out.println("Data inserted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
  
    private void insertDatatester(String name, String id, String password, String email) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "INSERT INTO tester (id, name, email, password) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, password);

            statement.executeUpdate();

            statement.close();
            conn.close();

            System.out.println("Data inserted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void insertDataad(String name, String id, String password, String email) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "INSERT INTO admindata (id, name, email, password) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, password);

            statement.executeUpdate();

            statement.close();
            conn.close();

            System.out.println("Data inserted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
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
			            JFrame devFrame = new JFrame("developer");
			            // Customize the "A" frame here if needed
			            
			            devFrame.setSize(400, 300);
			            devFrame.setVisible(true);
			            
			            devFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			            
			            devFrame.getContentPane().setLayout(null);
			            
			            devtxtName = new JTextField();
			            devtxtName.setToolTipText("");
			            devtxtName.setBounds(225, 11, 86, 20);
			            devFrame.getContentPane().add(devtxtName);
			            devtxtName.setColumns(10);
			
			            devtxtId = new JTextField();
			            devtxtId.setHorizontalAlignment(JTextField.LEFT);
			            devtxtId.setBounds(225, 54, 86, 20);
			            devFrame.getContentPane().add(devtxtId);
			            devtxtId.setColumns(10);
			
			            devtxtPhone = new JTextField();
			            devtxtPhone.setBounds(225, 95, 86, 20);
			            devFrame.getContentPane().add(devtxtPhone);
			            devtxtPhone.setColumns(10);
			
			            devtxtEmail = new JTextField();
			            devtxtEmail.setBounds(225, 143, 86, 20);
			            devFrame.getContentPane().add(devtxtEmail);
			            devtxtEmail.setColumns(10);
			
			            JButton btnSubmit = new JButton("Submit");
			            btnSubmit.setBounds(145, 218, 104, 23);
			            devFrame.getContentPane().add(btnSubmit);
			
			            
			            devtxtEnterYourName = new JTextField();
			            devtxtEnterYourName.setText("Enter your name:");
			            devtxtEnterYourName.setEditable(false);
			            devtxtEnterYourName.setBounds(25, 11, 133, 20);
			            devFrame.getContentPane().add(devtxtEnterYourName);
			            devtxtEnterYourName.setColumns(10);
			            
			            devtxtEnterYourAge = new JTextField();
			            devtxtEnterYourAge.setText("Enter your id:");
			            devtxtEnterYourAge.setEditable(false);
			            devtxtEnterYourAge.setColumns(10);
			            devtxtEnterYourAge.setBounds(25, 54, 133, 20);
			            devFrame.getContentPane().add(devtxtEnterYourAge);
			            
			            devtxtEnterYourId = new JTextField();
			            devtxtEnterYourId.setText("Enter your password :");
			            devtxtEnterYourId.setEditable(false);
			            devtxtEnterYourId.setColumns(10);
			            devtxtEnterYourId.setBounds(25, 95, 133, 20);
			            devFrame.getContentPane().add(devtxtEnterYourId);
			            
			            devtxtEnterYourEmail = new JTextField();
			            devtxtEnterYourEmail.setText("Enter your email:");
			            devtxtEnterYourEmail.setEditable(false);
			            devtxtEnterYourEmail.setColumns(10);
			            devtxtEnterYourEmail.setBounds(25, 143, 133, 20);
			            devFrame.getContentPane().add(devtxtEnterYourEmail);
			
			           
			            
			            btnSubmit.addActionListener(new ActionListener() {
			                public void actionPerformed(ActionEvent e) {
			                    String name = devtxtName.getText();
			                    String id = devtxtId.getText();
			                    String password = devtxtPhone.getText();
			                    String email = devtxtEmail.getText();
			
			                    insertData(name, id, password, email);
			                    
			                    // Clear the text fields after submitting
			                    devtxtName.setText("");
			                    devtxtId.setText("");
			                    devtxtPhone.setText("");
			                    devtxtEmail.setText("");
			                    
			                    developer();
			                    
			                }
			            });
			
			
			           }
			          });
			    
			    btnad.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			            JFrame adFrame = new JFrame("Admin");
			            // Customize the "A" frame here if needed
			            
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
			
			                    insertDataad(name, id, password, email);
			                    
			                    // Clear the text fields after submitting
			                    adtxtName.setText("");
			                    adtxtId.setText("");
			                    adtxtPhone.setText("");
			                    adtxtEmail.setText("");
			                    
			                    
			                    admin();
			                }
			            });
			
			
			           }
			          });
			    
			    
			    btnpro.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			            JFrame prosFrame = new JFrame("project manager");
			            // Customize the "A" frame here if needed
			            
			            prosFrame.setSize(400, 300);
			            prosFrame.setVisible(true);
			            
			            prosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			            
			            prosFrame.getContentPane().setLayout(null);
			            
			            prostxtName = new JTextField();
			            prostxtName.setToolTipText("");
			            prostxtName.setBounds(225, 11, 86, 20);
			            prosFrame.getContentPane().add(prostxtName);
			            prostxtName.setColumns(10);
			
			            prostxtId = new JTextField();
			            prostxtId.setHorizontalAlignment(JTextField.LEFT);
			            prostxtId.setBounds(225, 54, 86, 20);
			            prosFrame.getContentPane().add(prostxtId);
			            prostxtId.setColumns(10);
			
			            prostxtPhone = new JTextField();
			            prostxtPhone.setBounds(225, 95, 86, 20);
			            prosFrame.getContentPane().add(prostxtPhone);
			            prostxtPhone.setColumns(10);
			
			            prostxtEmail = new JTextField();
			            prostxtEmail.setBounds(225, 143, 86, 20);
			            prosFrame.getContentPane().add(prostxtEmail);
			            prostxtEmail.setColumns(10);
			
			            JButton btnSubmit = new JButton("Submit");
			            btnSubmit.setBounds(145, 218, 104, 23);
			            prosFrame.getContentPane().add(btnSubmit);
			
			            
			            prostxtEnterYourName = new JTextField();
			            prostxtEnterYourName.setText("Enter your name:");
			            prostxtEnterYourName.setEditable(false);
			            prostxtEnterYourName.setBounds(25, 11, 133, 20);
			            prosFrame.getContentPane().add(prostxtEnterYourName);
			            prostxtEnterYourName.setColumns(10);
			            
			            prostxtEnterYourAge = new JTextField();
			            prostxtEnterYourAge.setText("Enter your id:");
			            prostxtEnterYourAge.setEditable(false);
			            prostxtEnterYourAge.setColumns(10);
			            prostxtEnterYourAge.setBounds(25, 54, 133, 20);
			            prosFrame.getContentPane().add(prostxtEnterYourAge);
			            
			            prostxtEnterYourId = new JTextField();
			            prostxtEnterYourId.setText("Enter your password :");
			            prostxtEnterYourId.setEditable(false);
			            prostxtEnterYourId.setColumns(10);
			            prostxtEnterYourId.setBounds(25, 95, 133, 20);
			            prosFrame.getContentPane().add(prostxtEnterYourId);
			            
			            prostxtEnterYourEmail = new JTextField();
			            prostxtEnterYourEmail.setText("Enter your email:");
			            prostxtEnterYourEmail.setEditable(false);
			            prostxtEnterYourEmail.setColumns(10);
			            prostxtEnterYourEmail.setBounds(25, 143, 133, 20);
			            prosFrame.getContentPane().add(prostxtEnterYourEmail);
			
			           
			            
			            btnSubmit.addActionListener(new ActionListener() {
			                public void actionPerformed(ActionEvent e) {
			                    String name = prostxtName.getText();
			                    String id = prostxtId.getText();
			                    String password = prostxtPhone.getText();
			                    String email = prostxtEmail.getText();
			
			                    insertDatapro(name, id, password, email);
			                    
			                    // Clear the text fields after submitting
			                    prostxtName.setText("");
			                    prostxtId.setText("");
			                    prostxtPhone.setText("");
			                    prostxtEmail.setText("");
			                    
			                    
			                    projectmanager();
			                }
			            });
			
			
			           }
			          });
			    
			    
			    
			    btntst.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			            JFrame tstFrame = new JFrame("Tester");
			            // Customize the "A" frame here if needed
			            
			            tstFrame.setSize(400, 300);
			            tstFrame.setVisible(true);
			            
			            tstFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			            
			            tstFrame.getContentPane().setLayout(null);
			            
			            tsttxtName = new JTextField();
			            tsttxtName.setToolTipText("");
			            tsttxtName.setBounds(225, 11, 86, 20);
			            tstFrame.getContentPane().add(tsttxtName);
			            tsttxtName.setColumns(10);
			
			            tsttxtId = new JTextField();
			            tsttxtId.setHorizontalAlignment(JTextField.LEFT);
			            tsttxtId.setBounds(225, 54, 86, 20);
			            tstFrame.getContentPane().add(tsttxtId);
			            tsttxtId.setColumns(10);
			
			            tsttxtPhone = new JTextField();
			            tsttxtPhone.setBounds(225, 95, 86, 20);
			            tstFrame.getContentPane().add(tsttxtPhone);
			            tsttxtPhone.setColumns(10);
			
			            tsttxtEmail = new JTextField();
			            tsttxtEmail.setBounds(225, 143, 86, 20);
			            tstFrame.getContentPane().add(tsttxtEmail);
			            tsttxtEmail.setColumns(10);
			
			            JButton btnSubmitt = new JButton("Submit");
			            btnSubmitt.setBounds(145, 218, 104, 23);
			            tstFrame.getContentPane().add(btnSubmitt);
			            
			     
			            tsttxtEnterYourName = new JTextField();
			            tsttxtEnterYourName.setText("Enter your name:");
			            tsttxtEnterYourName.setEditable(false);
			            tsttxtEnterYourName.setBounds(25, 11, 133, 20);
			            tstFrame.getContentPane().add(tsttxtEnterYourName);
			            tsttxtEnterYourName.setColumns(10);
			            
			            tsttxtEnterYourAge = new JTextField();
			            tsttxtEnterYourAge.setText("Enter your id:");
			            tsttxtEnterYourAge.setEditable(false);
			            tsttxtEnterYourAge.setColumns(10);
			            tsttxtEnterYourAge.setBounds(25, 54, 133, 20);
			            tstFrame.getContentPane().add(tsttxtEnterYourAge);
			            
			            tsttxtEnterYourId = new JTextField();
			            tsttxtEnterYourId.setText("Enter your password :");
			            tsttxtEnterYourId.setEditable(false);
			            tsttxtEnterYourId.setColumns(10);
			            tsttxtEnterYourId.setBounds(25, 95, 133, 20);
			            tstFrame.getContentPane().add(tsttxtEnterYourId);
			            
			            tsttxtEnterYourEmail = new JTextField();
			            tsttxtEnterYourEmail.setText("Enter your email:");
			            tsttxtEnterYourEmail.setEditable(false);
			            tsttxtEnterYourEmail.setColumns(10);
			            tsttxtEnterYourEmail.setBounds(25, 143, 133, 20);
			            tstFrame.getContentPane().add(tsttxtEnterYourEmail);
			
			           
			            
			            btnSubmitt.addActionListener(new ActionListener() {
			                public void actionPerformed(ActionEvent e) {
			                    String name = tsttxtName.getText();
			                    String id = tsttxtId.getText();
			                    String password = tsttxtPhone.getText();
			                    String email = tsttxtEmail.getText();
			
			                    insertDatatester(name, id, password, email);
			                    
			                    // Clear the text fields after submitting
			                    tsttxtName.setText("");
			                    tsttxtId.setText("");
			                    tsttxtPhone.setText("");
			                    tsttxtEmail.setText("");
			                    
			                    tester();
			                    
			                    
			                    
			                    
			                }
			                
			                
			            });
			            
			            
			
			
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
			            JFrame telFrame = new JFrame("tester login");
			            // Customize the "A" frame here if needed
			            
			            telFrame.setSize(400, 300);
			            telFrame.setVisible(true);
			            
			            telFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			            
			            telFrame.getContentPane().setLayout(null);
			            
			            teltxtName = new JTextField();
			            teltxtName.setToolTipText("");
			            teltxtName.setBounds(225, 11, 86, 20);
			            telFrame.getContentPane().add(teltxtName);
			            teltxtName.setColumns(10);
			
			            teltxtId = new JTextField();
			            teltxtId.setHorizontalAlignment(JTextField.LEFT);
			            teltxtId.setBounds(225, 54, 86, 20);
			            telFrame.getContentPane().add(teltxtId);
			            teltxtId.setColumns(10);
			            
			            teltxtEnterYourName = new JTextField();
			            teltxtEnterYourName.setText("Enter your email:");
			            teltxtEnterYourName.setEditable(false);
			            teltxtEnterYourName.setBounds(25, 11, 133, 20);
			            telFrame.getContentPane().add(teltxtEnterYourName);
			            teltxtEnterYourName.setColumns(10);
			            
			            teltxtEnterYourAge = new JTextField();
			            teltxtEnterYourAge.setText("Enter your password:");
			            teltxtEnterYourAge.setEditable(false);
			            teltxtEnterYourAge.setColumns(10);
			            teltxtEnterYourAge.setBounds(25, 54, 133, 20);
			            telFrame.getContentPane().add(teltxtEnterYourAge);
			            
			            JButton btnSubmittel = new JButton("Submit");
			            btnSubmittel.setBounds(145, 218, 104, 23);
			            telFrame.getContentPane().add(btnSubmittel);
			            
			            
			            btnSubmittel.addActionListener(new ActionListener() {
			                @Override
			                public void actionPerformed(ActionEvent e) {
			                    String email = teltxtName.getText();
			                    String password = teltxtId.getText();
			                    
			                    // Execute database query to check if email and password exist
			                    boolean found = searchInDatabasetst(email, password);
			                    
			                    // Display result based on whether email and password were found
			                    if (found) {
			                        System.out.println("Found");
			                           tester();
			                    } else {
			                        System.out.println("Not found");
			                        JButton btnSubmitdvll = new JButton("Wrong please sign up");
			                        btnSubmitdvll.setBounds(100, 118, 204, 23);
			                        telFrame.getContentPane().add(btnSubmitdvll);
			                    }
			                }
			              });
			        
			            
			                }
			            });
			    
			    btndevl.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			            JFrame dvlFrame = new JFrame("developer login");
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
			                    boolean found = searchInDatabasedev(email, password);
			                    
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
			            });
			    
			    btnProjectManager.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			            JFrame proFrame = new JFrame("ProjectManager login");
			            // Customize the "A" frame here if needed
			            
			            proFrame.setSize(400, 300);
			            proFrame.setVisible(true);
			            
			            proFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			            
			            proFrame.getContentPane().setLayout(null);
			            
			            protxtName = new JTextField();
			            protxtName.setToolTipText("");
			            protxtName.setBounds(225, 11, 86, 20);
			            proFrame.getContentPane().add(protxtName);
			            protxtName.setColumns(10);
			
			            protxtId = new JTextField();
			            protxtId.setHorizontalAlignment(JTextField.LEFT);
			            protxtId.setBounds(225, 54, 86, 20);
			            proFrame.getContentPane().add(protxtId);
			            protxtId.setColumns(10);
			            
			            protxtEnterYourName = new JTextField();
			            protxtEnterYourName.setText("Enter your email:");
			            protxtEnterYourName.setEditable(false);
			            protxtEnterYourName.setBounds(25, 11, 133, 20);
			            proFrame.getContentPane().add(protxtEnterYourName);
			            protxtEnterYourName.setColumns(10);
			            
			            protxtEnterYourAge = new JTextField();
			            protxtEnterYourAge.setText("Enter your password:");
			            protxtEnterYourAge.setEditable(false);
			            protxtEnterYourAge.setColumns(10);
			            protxtEnterYourAge.setBounds(25, 54, 133, 20);
			            proFrame.getContentPane().add(protxtEnterYourAge);
			            
			            JButton btnSubmitpro = new JButton("Submit");
			            btnSubmitpro.setBounds(145, 218, 104, 23);
			            proFrame.getContentPane().add(btnSubmitpro);
			            
			            
			            btnSubmitpro.addActionListener(new ActionListener() {
			                @Override
			                public void actionPerformed(ActionEvent e) {
			                    String email = protxtName.getText();
			                    String password = protxtId.getText();
			                    
			                    // Execute database query to check if email and password exist
			                    boolean found = searchInDatabasepro(email, password);
			                    
			                    // Display result based on whether email and password were found
			                    if (found) {
			                        System.out.println("Found");
			                           projectmanager();
			                    } else {
			                        System.out.println("Not found");
			                        JButton btnSubmitproo = new JButton("Wrong please sign up");
			                        btnSubmitproo.setBounds(100, 118, 204, 23);
			                        proFrame.getContentPane().add(btnSubmitproo);
			                    }
			                }
			              });
			        
			            
			                }
			            });
			    
			    
			    
			    btnadmin.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			            JFrame adlFrame = new JFrame("admin login");
			            // Customize the "A" frame here if needed
			            
			            adlFrame.setSize(400, 300);
			            adlFrame.setVisible(true);
			            
			            adlFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			            
			            adlFrame.getContentPane().setLayout(null);
			            
			            adltxtName = new JTextField();
			            adltxtName.setToolTipText("");
			            adltxtName.setBounds(225, 11, 86, 20);
			            adlFrame.getContentPane().add(adltxtName);
			            adltxtName.setColumns(10);
			
			            adltxtId = new JTextField();
			            adltxtId.setHorizontalAlignment(JTextField.LEFT);
			            adltxtId.setBounds(225, 54, 86, 20);
			            adlFrame.getContentPane().add(adltxtId);
			            adltxtId.setColumns(10);
			            
			            adltxtEnterYourName = new JTextField();
			            adltxtEnterYourName.setText("Enter your email:");
			            adltxtEnterYourName.setEditable(false);
			            adltxtEnterYourName.setBounds(25, 11, 133, 20);
			            adlFrame.getContentPane().add(adltxtEnterYourName);
			            adltxtEnterYourName.setColumns(10);
			            
			            adltxtEnterYourAge = new JTextField();
			            adltxtEnterYourAge.setText("Enter your password:");
			            adltxtEnterYourAge.setEditable(false);
			            adltxtEnterYourAge.setColumns(10);
			            adltxtEnterYourAge.setBounds(25, 54, 133, 20);
			            adlFrame.getContentPane().add(adltxtEnterYourAge);
			            
			            JButton btnSubmitadl = new JButton("Submit");
			            btnSubmitadl.setBounds(145, 218, 104, 23);
			            adlFrame.getContentPane().add(btnSubmitadl);
			            
			            
			            btnSubmitadl.addActionListener(new ActionListener() {
			                @Override
			                public void actionPerformed(ActionEvent e) {
			                    String email = adltxtName.getText();
			                    String password = adltxtId.getText();
			                    
			                    // Execute database query to check if email and password exist
			                    boolean found = searchInDatabasead(email, password);
			                    
			                    // Display result based on whether email and password were found
			                    if (found) {
			                        System.out.println("Found");
			                           admin();
			                    } else {
			                        System.out.println("Not found");
			                        JButton btnSubmitadll = new JButton("Wrong please sign up");
			                        btnSubmitadll.setBounds(100, 118, 204, 23);
			                        adlFrame.getContentPane().add(btnSubmitadll);
			                    }
			                }
			              });
			        
			            
			                }
			            });
    }
    
}

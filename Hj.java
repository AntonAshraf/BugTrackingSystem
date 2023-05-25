package oopproject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    private JFrame proFrame;
    private JTextField protxtName;
    private JTextField protxtId;
    private JTextField protxtEnterYourName;
    private JTextField protxtEnterYourAge;
    private JTextField protxtEnterYourId;
    private JTextField protxtEnterYourEmail;
    
    private JFrame tstFrame;
    private JTextField tsttxtName;
    private JTextField tsttxtId;
    private JTextField tsttxtPhone;
    private JTextField tsttxtEmail;
    private JTextField tsttxtEnterYourName;
    private JTextField tsttxtEnterYourAge;
    private JTextField tsttxtEnterYourId;
    private JTextField tsttxtEnterYourEmail;
    private JButton tstBtnSubmit;

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
        
       
       
        
        
        
       
        
        
        
        
        
        
        
        
        //pro manger
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        btnlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                
                
                btnProjectManager.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame proFrame = new JFrame("ProjectManager");
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
                        
                            }
                        });
                        
                        
                        
                        
                        
                        
                        
                        

                    }
                });
                
                
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        btnsignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                btntst.setBounds(339, 94, 130, 23);
                upFrame.getContentPane().add(btntst);
                
                
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
                                
                                
                                JFrame devwFrame = new JFrame("Developer window");
                                // Customize the "A" frame here if needed
                                
                                devwFrame.setSize(400, 300);
                                devwFrame.setVisible(true);
                                
                                devwFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                
                                devwFrame.getContentPane().setLayout(null);
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
                            
                            
                        });
                        
                        


                    }
              
                    
                });
                
                
            }
            });
        
        

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
}

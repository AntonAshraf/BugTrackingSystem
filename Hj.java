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
        
        JButton btnNewButton = new JButton("Developer");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(10, 94, 130, 23);
        contentPane.add(btnNewButton);
        
        JButton btnAdmin = new JButton("Admin");
        btnAdmin.setBounds(176, 94, 130, 23);
        contentPane.add(btnAdmin);
        
        JButton btnTester = new JButton("Tester");
        btnTester.setBounds(339, 94, 130, 23);
        contentPane.add(btnTester);
        
        JButton btnProjectManager = new JButton("Project Manager");
        btnProjectManager.setBounds(177, 176, 129, 23);
        contentPane.add(btnProjectManager);
        
        JLabel lblNewLabel = new JLabel("Select Your Role");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(169, 37, 149, 14);
        contentPane.add(lblNewLabel);
        tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("E-Mail");
        tableModel.addColumn("Password");
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame devFrame = new JFrame("A");
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
                    }
                });


            }
        });
        
        btnProjectManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame proFrame = new JFrame("ProjectManager");
                // Customize the "A" frame here if needed
                
                proFrame.setSize(400, 300);
                proFrame.setVisible(true);
                
                proFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                proFrame.getContentPane().setLayout(null);
                
                JButton btnSubmitp = new JButton("View Developers");
                btnSubmitp.setBounds(145, 218, 104, 23);
                proFrame.getContentPane().add(btnSubmitp);
                
             // Add the following code inside the action listener of the "Submit" button in the project manager GUI window
                btnSubmitp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                            String query = "SELECT name, id, password, email FROM user";
                            PreparedStatement statement = conn.prepareStatement(query);
                            ResultSet resultSet = statement.executeQuery();

                            // Create a new frame to display the table
                            JFrame tableFrame = new JFrame("Developers Data");
                            tableFrame.setSize(500, 400);
                            
                            // Create the table and table model
                            JTable table = new JTable();
                            DefaultTableModel tableModel = new DefaultTableModel();
                            table.setModel(tableModel);
                            
                            // Add columns to the table model
                            tableModel.addColumn("Name");
                            tableModel.addColumn("ID");
                            tableModel.addColumn("Password");
                            tableModel.addColumn("Email");
                            
                            // Add rows to the table model from the ResultSet
                            while (resultSet.next()) {
                                String name = resultSet.getString("name");
                                String id = resultSet.getString("id");
                                String password = resultSet.getString("password");
                                String email = resultSet.getString("email");
                                
                                tableModel.addRow(new Object[]{name, id, password, email});
                            }

                            // Create a scroll pane and add the table to it
                            JScrollPane scrollPane = new JScrollPane(table);
                            tableFrame.getContentPane().add(scrollPane);

                            // Set the frame visibility
                            tableFrame.setVisible(true);

                            // Close the database connections and resources
                            resultSet.close();
                            statement.close();
                            conn.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

            }
        });
        
        btnAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame devFrame = new JFrame("Admin");
                // Customize the "A" frame here if needed
                
                devFrame.setSize(400, 300);
                devFrame.setVisible(true);
            }
        });
        
        btnTester.addActionListener(new ActionListener() {
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

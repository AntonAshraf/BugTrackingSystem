package h;

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

public class Hj extends JFrame {

    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtId;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private JTable table;
    private DefaultTableModel tableModel;

    // MySQL database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost/mydatabase"; // Replace "mydatabase" with your actual database name
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "tmsa7";
    private JTextField txtEnterYourName;
    private JTextField txtEnterYourAge;
    private JTextField txtEnterYourId;
    private JTextField txtEnterYourEmail;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Hj frame = new Hj();
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
    public Hj() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 405, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtName = new JTextField();
        txtName.setToolTipText("");
        txtName.setBounds(225, 11, 86, 20);
        contentPane.add(txtName);
        txtName.setColumns(10);

        txtId = new JTextField();
        txtId.setHorizontalAlignment(JTextField.LEFT);
        txtId.setBounds(225, 54, 86, 20);
        contentPane.add(txtId);
        txtId.setColumns(10);

        txtPhone = new JTextField();
        txtPhone.setBounds(225, 95, 86, 20);
        contentPane.add(txtPhone);
        txtPhone.setColumns(10);

        txtEmail = new JTextField();
        txtEmail.setBounds(225, 143, 86, 20);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(145, 218, 104, 23);
        contentPane.add(btnSubmit);

        JButton btnViewData = new JButton("View Data");
        btnViewData.setBounds(25, 218, 109, 23);
        contentPane.add(btnViewData);
        
        JButton btnClearData = new JButton("Clear Data");
        btnClearData.setBounds(259, 218, 102, 23);
        contentPane.add(btnClearData);

        // Table to display data
        table = new JTable();
        tableModel = new DefaultTableModel();
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 299, 369, 151);
        contentPane.add(scrollPane);
        
        txtEnterYourName = new JTextField();
        txtEnterYourName.setText("Enter your name:");
        txtEnterYourName.setEditable(false);
        txtEnterYourName.setBounds(25, 11, 133, 20);
        contentPane.add(txtEnterYourName);
        txtEnterYourName.setColumns(10);
        
        txtEnterYourAge = new JTextField();
        txtEnterYourAge.setText("Enter your age:");
        txtEnterYourAge.setEditable(false);
        txtEnterYourAge.setColumns(10);
        txtEnterYourAge.setBounds(25, 54, 133, 20);
        contentPane.add(txtEnterYourAge);
        
        txtEnterYourId = new JTextField();
        txtEnterYourId.setText("Enter your id :");
        txtEnterYourId.setEditable(false);
        txtEnterYourId.setColumns(10);
        txtEnterYourId.setBounds(25, 95, 133, 20);
        contentPane.add(txtEnterYourId);
        
        txtEnterYourEmail = new JTextField();
        txtEnterYourEmail.setText("Enter your email:");
        txtEnterYourEmail.setEditable(false);
        txtEnterYourEmail.setColumns(10);
        txtEnterYourEmail.setBounds(25, 143, 133, 20);
        contentPane.add(txtEnterYourEmail);

        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Email");

        // ActionListener for Submit button
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String id = txtId.getText();
                String phone = txtPhone.getText();
                String email = txtEmail.getText();

                // Insert data into the database
                insertData(name, id, phone, email);

                // Clear input fields after insertion
                txtName.setText("");
                txtId.setText("");
                txtPhone.setText("");
                txtEmail.setText("");
            }
        });

        // ActionListener for View Data button
        btnViewData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // View data from the database
                viewData();
            }
        });
       
        btnClearData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear data from the database
                clearData();
            }
        });
    }
    
        

    private void insertData(String name, String id, String phone, String email) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "INSERT INTO users (name, id, age, email) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, id);
            statement.setString(3, phone);
            statement.setString(4, email);

            statement.executeUpdate();

            statement.close();
            conn.close();

            System.out.println("Data inserted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void viewData() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "SELECT * FROM users";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Clear existing table data
            tableModel.setRowCount(0);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");

                // Add a row to the table model
                tableModel.addRow(new Object[]{id, name, age, email});
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void clearData() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "DELETE FROM users";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.executeUpdate();

            statement.close();
            conn.close();

            System.out.println("Data cleared successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

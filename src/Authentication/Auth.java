package Authentication;

import GUI.HomePage;
import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

public class Auth extends JFrame {

  // MySQL database connection parameters
  private static final String DB_URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7621761"; // Replace "mydatabase" with your actual
  private static final String DB_USERNAME = "sql7621761";
  private static final String DB_PASSWORD = "aGdHdzy8Is";

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          HomePage frame = new HomePage();
          frame.homePage();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  
  public static boolean authenticateUser(String email, String password, String table) {
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

  public static boolean insertData(String name, String id, String password, String email, String table) {
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
}

package Authentication;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;

import javax.swing.JFrame;

import GUI.HomePage;

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
          // frame.setVisible(true);
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
      String query = "SELECT * FROM " + table + " WHERE email = '" + email + "' AND password = '" + password + "'";

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

}
package Authentication;

import java.awt.EventQueue;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import GUI.HomePage;

public class Auth extends JFrame {

  // MySQL database connection parameters
  private static final String DB_URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7621761"; // Replace "mydatabase"
                                                                                                 // with your actual
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

  public static List<String> GoogleSearch(String Prompt) {

    Document doc;
    List<String> Results = new ArrayList<String>();
    String s = "https://www.google.com/search?q=" + Prompt;
    s.replace(' ', '+');

    try {
      doc = Jsoup.connect(s).get();
      // get title of the page
      String title = doc.title();
      System.out.println("Title: " + title);
      // get all links
      Elements links = doc.select("a[href]");
      for (Element link : links) {
        String x = new String(link.attr("href"));
        // get the value from href attribute
        if (x.startsWith("https")) {
          Results.add(x);
          System.out.println("\nLink : " + x);
        }
        // System.out.println("Text : " + link.text());
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return Results;

  }

  public static void appendToOutput(String message, JTextArea outputArea) {
    outputArea.append(message + "\n");
  }

  public static void processInput(String input, JTextArea outputArea) {
    // Your code to process the input string
    appendToOutput(input + "\n", outputArea);
  }

  public static boolean isValidEmail(String email) {
    // Regular expression pattern for email validation
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    // Create a Pattern object
    Pattern pattern = Pattern.compile(regex);

    // Create a Matcher object
    Matcher matcher = pattern.matcher(email);

    // Check if the email matches the pattern
    return matcher.matches();
  }

  public static boolean isInteger(String input) {
    try {
      Integer.parseInt(input);
      return true; // Parsing succeeded, input is an integer
    } catch (NumberFormatException e) {
      return false; // Parsing failed, input is not an integer
    }
  }

  public static boolean isExist(String id, String value, String table) {
    try {
      Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
      String query = "SELECT * FROM " + table + " WHERE " + id + " = ?";
      PreparedStatement statement = conn.prepareStatement(query);
      statement.setString(1, value);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

}

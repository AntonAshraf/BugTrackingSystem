package Authentication;

import GUI.HomePage;
import java.awt.EventQueue;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;




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
          //frame.setVisible(true);
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

  public static boolean authenticatebugdev(String developerid) {
	    // Establish database connection and execute query
	    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	         Statement statement = connection.createStatement()) {
	        // Construct the query to search for email and password in the table "projectma"
	    	String query = "SELECT * FROM Developers WHERE id = " + developerid ;
	        
	        // Execute the query
	        ResultSet resultSet = statement.executeQuery(query);
	        
	        // Check if any rows were returned
	        if (resultSet.next()) {
	            return true; // id were found in the database
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    
	    return false; // id were not found in the database
	}
  
  public static List<String> getColumnValues(String columnName, String table) {
	    List<String> columnValues = new ArrayList<>();
	    try {
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	        String query = "SELECT " + columnName + " FROM " + table;
	        //              SELECT       name         FROM     Bugs
	        PreparedStatement statement = conn.prepareStatement(query);

	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            columnValues.add(resultSet.getString(columnName));
	        }

	        resultSet.close();
	        statement.close();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return columnValues;
	}
  
  public static List<String> getColumnspecificValues(String columnName, String table,String identifier,String value) {
	    List<String> columnValues = new ArrayList<>();
	    try {
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	        String query = "SELECT " + columnName + " FROM " + table + " WHERE " + identifier +" = ?";
	        //              SELECT       name         FROM     Bugs
	        PreparedStatement statement = conn.prepareStatement(query);
	        statement.setString(1, value);
	        
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            columnValues.add(resultSet.getString(columnName));
	        }

	        resultSet.close();
	        statement.close();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return columnValues;
	}


  public static String getIDByName(String value, String targetvalue, String table, String identifier) {
	    String ID = "-1";

	    try {
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	        String query = "SELECT " + targetvalue + " FROM " + table + " WHERE " + identifier + " = ?";
	        //              SELECT          id         FROM   Developers  WHERE      name         = value
	        PreparedStatement statement = conn.prepareStatement(query);
	        statement.setString(1, value);

	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            ID = resultSet.getString(targetvalue);
	        }

	        resultSet.close();
	        statement.close();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return ID;
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
  
  public static boolean insertDataBug(String bugid , String name, String type, String priority, String projectname, String startdate, String deadline, String level,String testerid) {
	    try {
	      Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	      
	                  String fixstatus ="open";
	                  String fixdonedate ="";
	                  
	                  
				      String query = "INSERT INTO Bugs (bugid,name,type,priority,projectname,startdate,deadline,donedate, level, status,testerid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			
				      PreparedStatement statement = conn.prepareStatement(query);
				      statement.setString(1, bugid);
				      statement.setString(2, name);
				      statement.setString(3, type);
				      statement.setString(4, priority);
				      statement.setString(5, projectname);
				      statement.setString(6, startdate);
				      statement.setString(7, deadline);
				      statement.setString(8, fixdonedate);
				      statement.setString(9, level);
				      statement.setString(10, fixstatus);
				      statement.setString(11, testerid);
				      
			
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
	  
			} 
	    
	                 catch (SQLException ex) {
				      ex.printStackTrace();
				      return false;
				   
				    }
	  }
  
  public static boolean updateDatabug(String table,String identifier,String searchvalue,String columnewvalue, String newvalue) {
      //Auth.updateDatabug(Bugs, bugid, 3 , developerid, 4);
   try {
         Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
         //Example                    Bugs              developerid       4            bugid          3
         String query = "UPDATE " + table + " SET " + columnewvalue + "  = ? WHERE "+ identifier + " = ? ";
         PreparedStatement statement = conn.prepareStatement(query);
         statement.setString(1, newvalue);
         statement.setString(2, searchvalue);

         int rowsUpdated = statement.executeUpdate();

         statement.close();
         conn.close();

         if (rowsUpdated > 0) {
             System.out.println("Data updated successfully!");
             return true;
         } else {
             System.out.println("Data update failed!");
             return false;
         }
     } catch (SQLException ex) {
         ex.printStackTrace();
         return false;
     }
 }
  
  public static void viewdata(JTable table,String type) {
      // Establish database connection and execute query
      try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
           Statement statement = connection.createStatement()) {
          // Construct the query to select all columns from the "bugs" table
          String query = "SELECT * FROM "+ type ;

          // Execute the query
          ResultSet resultSet = statement.executeQuery(query);

          // Create a DefaultTableModel to store the query results
          DefaultTableModel tableModel = new DefaultTableModel();

          // Get the metadata of the result set
          ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();

          // Get the column count
          int columnCount = metaData.getColumnCount();

          // Add column names to the table model
          for (int i = 1; i <= columnCount; i++) {
              tableModel.addColumn(metaData.getColumnName(i));
          }

          // Add rows to the table model
          while (resultSet.next()) {
              Object[] rowData = new Object[columnCount];
              for (int i = 1; i <= columnCount; i++) {
                  rowData[i - 1] = resultSet.getObject(i);
              }
              tableModel.addRow(rowData);
          }

          // Set the table model to the JTable
          table.setModel(tableModel);
      } catch (SQLException ex) {
          ex.printStackTrace();
      }
      
  }
  
  public static void viewspecificdata(JTable table,String datatable,String specificcolum,String specificvalue) {
      // Establish database connection and execute query
      try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
           Statement statement = connection.createStatement()) {
          // Construct the query to select all columns from the "bugs" table
          //                                Bugs                    testerid              5
    	  String query = "SELECT * FROM "+ datatable + " WHERE " + specificcolum + " = " + specificvalue;
       
          // Execute the query
          ResultSet resultSet = statement.executeQuery(query);

          // Create a DefaultTableModel to store the query results
          DefaultTableModel tableModel = new DefaultTableModel();

          // Get the metadata of the result set
          ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();

          // Get the column count
          int columnCount = metaData.getColumnCount();

          // Add column names to the table model
          for (int i = 1; i <= columnCount; i++) {
              tableModel.addColumn(metaData.getColumnName(i));
          }

          // Add rows to the table model
          while (resultSet.next()) {
              Object[] rowData = new Object[columnCount];
              for (int i = 1; i <= columnCount; i++) {
                  rowData[i - 1] = resultSet.getObject(i);
              }
              tableModel.addRow(rowData);
          }

          // Set the table model to the JTable
          table.setModel(tableModel);
      } catch (SQLException ex) {
          ex.printStackTrace();
      }
      
  }
 


}

package GUI;

import Authentication.Auth;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class AuthGUI extends JFrame{

  private JTextField adtxtName;
  private JTextField adtxtId;
  private JTextField adtxtPhone;
  private JTextField adtxtEmail;
  private JTextField adtxtEnterYourName;
  private JTextField adtxtEnterYourAge;
  private JTextField adtxtEnterYourId;
  private JTextField adtxtEnterYourEmail;
  private JTextField dvltxtName;
  private JTextField dvltxtId;
  private JTextField dvltxtEnterYourName;
  private JTextField dvltxtEnterYourAge;


  private void signupPage(String userType, String Table) {

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

        Boolean x = Auth.insertData(name, id, password, email, Table);
        if (x) {

          System.out.println("Data inserted successfully!");
          UserGUI.UserPage(userType, name, id, email);

        } else {
          JButton btnSubmittt = new JButton("id already exists or invalid id try again");
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

  private void loginPage (String userType, String Table) {
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
            boolean found = Auth.authenticateUser(email, password, Table);

            // Display result based on whether email and password were found
            if (found) {
              System.out.println("Found");
              UserGUI.UserPage(userType,"null", "-1", email);
            } else {
              System.out.println("Not found");
              JButton btnSubmitdvll = new JButton("Invalid email or password try again");
              btnSubmitdvll.setBounds(100, 118, 204, 23);
              dvlFrame.getContentPane().add(btnSubmitdvll);
            }
          }
        });

  }
  

  public void signup() {
    JFrame upFrame = new JFrame("sign up");

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

  public void login() {
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

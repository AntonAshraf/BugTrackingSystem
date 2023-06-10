package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DB.DataBase;
import ChatSockets.*;
import system.Admin;
import system.Dates;
import system.Developer;
import system.Project_Manager;
import system.Tester;
import EmailSender.SendMail;

public class UserGUI {

  static HomePage home = new HomePage();
  static AuthGUI auth = new AuthGUI();
  static DataBase cmd = new DataBase();
  private static String path;
  private static JTextField textField;
  private static String formattedDate;

  private static class FileViewWithSizeLimit extends javax.swing.filechooser.FileView {
    private long maxSize;

    public FileViewWithSizeLimit(long maxSize) {
      this.maxSize = maxSize;
    }

    public Boolean isTraversable(File f) {
      return (f.isFile() && f.length() <= maxSize);
    }
  }

  public static void UserPage(String UserType, String name, String id, String email) {

    if (UserType.equals("Project Manager")) {
      projectmanager();
    } else if (UserType.equals("Developer")) {
      developer(email);
    } else if (UserType.equals("Admin")) {
      admin();
    } else if (UserType.equals("Tester")) {
      tester(email);
    }
  }

  public static void projectmanager() {
    final JFrame prowFrame = new JFrame("Project Manager Window");

    prowFrame.setSize(500, 400);
    prowFrame.setLocationRelativeTo(null);
    prowFrame.setVisible(true);
    prowFrame.setResizable(false);
    prowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    prowFrame.getContentPane().setLayout(null);

    ImageIcon background = new ImageIcon("src/main/resources/images/pmbg.png");
    JLabel bgLabel = new JLabel(background);
    bgLabel.setSize(500, 400);
    bgLabel.setLocation(0, 0);
    prowFrame.add(bgLabel);

    JButton btnCheckPerform = new JButton("Check Performance");
    btnCheckPerform.setBounds(162, 60, 150, 25);
    bgLabel.add(btnCheckPerform);

    JButton btnMonitor = new JButton("Monitor Bugs");
    btnMonitor.setBounds(162, 110, 150, 25);
    bgLabel.add(btnMonitor);

    btnMonitor.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DataBase.viewTable("Bugs");
      }
    });

    btnCheckPerform.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        prowFrame.dispose();
        final JFrame PerformFrame = new JFrame("Check Performance");
        PerformFrame.setSize(500, 400);
        PerformFrame.setLocationRelativeTo(null);
        PerformFrame.setResizable(true);
        PerformFrame.getContentPane().setLayout(null);
        PerformFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PerformFrame.setVisible(true);

        JLabel updatetxtEnterRole = new JLabel();
        updatetxtEnterRole.setText("Choose User Role");
        updatetxtEnterRole.setBounds(187, 80, 133, 20);
        PerformFrame.getContentPane().add(updatetxtEnterRole);

        JButton btnTesters = new JButton("Testers");
        btnTesters.setBounds(150, 110, 175, 25);
        PerformFrame.getContentPane().add(btnTesters);

        JButton btnDevs = new JButton("Developers");
        btnDevs.setBounds(150, 160, 175, 25);
        PerformFrame.getContentPane().add(btnDevs);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(150, 210, 175, 25);
        PerformFrame.add(btnBack);

        btnBack.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            PerformFrame.dispose();
            projectmanager();
          }
        });

        btnTesters.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Project_Manager.PerformanceView("Tester");
          }
        });

        btnDevs.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Project_Manager.PerformanceView("Developer");
          }
        });
      }
    });

    JButton btnViewTesters = new JButton("Monitor Testers");
    btnViewTesters.setBounds(162, 160, 150, 25);
    bgLabel.add(btnViewTesters);

    JButton btnViewDevs = new JButton("Monitor Devs");
    btnViewDevs.setBounds(162, 210, 150, 25);
    bgLabel.add(btnViewDevs);

    btnViewTesters.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DataBase.viewTable("Testers");
      }
    });

    btnViewDevs.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DataBase.viewTable("Developers");
      }
    });

    JButton btnBack = new JButton("Log Out");
    btnBack.setBounds(162, 260, 150, 25);
    bgLabel.add(btnBack);

    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        prowFrame.dispose();
        home.homePage();
      }
    });
  }

  public static void developer(final String email) {

    final String ID = DataBase.getIDByName(email, "id", "Developers", "email");

    final JFrame devwFrame = new JFrame("Developer window");
    devwFrame.setSize(500, 400);
    devwFrame.setLocationRelativeTo(null);
    devwFrame.setVisible(true);
    devwFrame.setResizable(false);
    devwFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    devwFrame.getContentPane().setLayout(null);

    ImageIcon background = new ImageIcon("src/main/resources/images/devbg.png");
    JLabel bgLabel = new JLabel(background);
    bgLabel.setSize(500, 400);
    bgLabel.setLocation(0, 0);
    devwFrame.add(bgLabel);

    JButton btnbugs = new JButton("View Bugs");
    btnbugs.setBounds(175, 110, 125, 25);
    bgLabel.add(btnbugs);

    JButton btnfinishbug = new JButton("Finish Bug");
    btnfinishbug.setBounds(175, 160, 125, 25);
    bgLabel.add(btnfinishbug);

    JButton btnBack = new JButton("Log Out");
    btnBack.setBounds(175, 210, 125, 25);
    bgLabel.add(btnBack);

    ImageIcon chaticon = new ImageIcon("src/main/resources/images/chaticon.png");
    JButton btnChat = new JButton(chaticon);
    btnChat.setBounds(436, 0, 50, 50);
    bgLabel.add(btnChat);

    btnChat.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ChatEntry.startChat(email);

      }
    });

    ImageIcon searchicon = new ImageIcon("src/main/resources/images/searchicon.png");
    JButton btnsearch = new JButton(searchicon);
    btnsearch.setBounds(385, 0, 50, 50);
    bgLabel.add(btnsearch);

    btnsearch.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        Developer.search();
      }
    });

    btnbugs.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        JFrame frame = new JFrame("View Bugs");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        DataBase.viewspecificdata(table, "Bugs", "developerid", ID);
        if (table.getRowCount() == 0) {
          JOptionPane.showMessageDialog(null, "No Bugs Assigned");
        } else {
          frame.setVisible(true);
        }
      }
    });

    btnfinishbug.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        final JFrame bugfinishFrame = new JFrame("Developer window");
        bugfinishFrame.setSize(300, 225);
        bugfinishFrame.setLocationRelativeTo(null);
        
        bugfinishFrame.setResizable(false);
        bugfinishFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bugfinishFrame.getContentPane().setLayout(null);

        JButton btnvbug = new JButton("Submit");
        btnvbug.setBounds(80, 140, 120, 25);
        bugfinishFrame.getContentPane().add(btnvbug);

        JLabel FinishtxtChooseBug = new JLabel();
        FinishtxtChooseBug.setText("Choose Bug to Close:");
        FinishtxtChooseBug.setBounds(25, 10, 130, 20);
        bugfinishFrame.getContentPane().add(FinishtxtChooseBug);

        List<String> Bugs = DataBase.getColumnspecific2Values("name", "Bugs", "developerid", ID,"status","open");
        
        if (Bugs.size() == 0) {
          JOptionPane.showMessageDialog(null, "No Bugs Assigned");
          bugfinishFrame.dispose();
        } else {
          bugfinishFrame.setVisible(true);
        }
        String Bugsarray[] = new String[Bugs.size()];
        for (int j = 0; j < Bugs.size(); j++) {
          Bugsarray[j] = Bugs.get(j);
          System.out.println(j);
        }

        final JComboBox BugsCombo = new JComboBox(Bugsarray);
        BugsCombo.setSelectedIndex(0);
        BugsCombo.setBounds(25, 35, 200, 20);
        bugfinishFrame.getContentPane().add(BugsCombo);

        btnvbug.addActionListener(new ActionListener() {

          public void actionPerformed(ActionEvent e) {
            bugfinishFrame.dispose();
            String donedate = Dates.getCurrentDate();
            String bugname = (String) BugsCombo.getSelectedItem();
            DataBase.updateDatabug("Bugs", "name", bugname, "status", "closed"); // change status of bug
            DataBase.increment("Developers", "donebugs", ID, "id"); // increment donebug for developer
            DataBase.updateDatabug("Bugs", "name", bugname, "donedate", donedate); // add donedate to the bug
            String deadline = DataBase.getIDByName(bugname, "deadline", "Bugs", "name"); // get deadline of the bug
            long days = Dates.getDaysBetweenDates(donedate, deadline); // get days between dates using deadline and
                                                                          // donedate
            DataBase.updatelongDatabug("Bugs", "name", bugname, "timetaken", days); // update taken time in the bugs
                                                                                    // table

          }
        });
      }
    });

    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        devwFrame.dispose();
        home.homePage();
      }
    });
  }

  public static void admin() {
    final JFrame adFrame = new JFrame("Admin Window");

    adFrame.setSize(500, 400);
    adFrame.setLocationRelativeTo(null);
    adFrame.setVisible(true);
    adFrame.setResizable(false);
    adFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    adFrame.getContentPane().setLayout(null);

    ImageIcon background = new ImageIcon("src/main/resources/images/adminbg.png");
    JLabel bgLabel = new JLabel(background);
    bgLabel.setSize(500, 400);
    bgLabel.setLocation(0, 0);
    adFrame.add(bgLabel);

    JButton btnViewBugs = new JButton("View Bugs");
    btnViewBugs.setBounds(175, 60, 125, 25);
    bgLabel.add(btnViewBugs);

    JButton btnViewTesters = new JButton("View Testers");
    btnViewTesters.setBounds(300, 60, 125, 25);
    bgLabel.add(btnViewTesters);

    JButton btnViewDevs = new JButton("View Devs");
    btnViewDevs.setBounds(50, 60, 125, 25);
    bgLabel.add(btnViewDevs);

    btnViewTesters.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        DataBase.viewTable("Testers");
      }
    });

    btnViewDevs.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DataBase.viewTable("Developers");
      }
    });

    JButton btnAdd = new JButton("Add Users");
    btnAdd.setBounds(175, 110, 125, 25);
    bgLabel.add(btnAdd);

    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        adFrame.dispose();

        final JFrame SignUpFrame = new JFrame("Add User");

        SignUpFrame.setSize(500, 400);
        SignUpFrame.setLocationRelativeTo(null);
        SignUpFrame.setVisible(true);
        SignUpFrame.setResizable(false);
        SignUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SignUpFrame.getContentPane().setLayout(null);

        final JTextField SignUptxtName = new JTextField();
        SignUptxtName.setBounds(25, 35, 200, 20);
        SignUpFrame.getContentPane().add(SignUptxtName);
        SignUptxtName.setColumns(10);

        final JTextField SignUptxtId = new JTextField();
        SignUptxtId.setBounds(25, 85, 200, 20);
        SignUpFrame.getContentPane().add(SignUptxtId);
        SignUptxtId.setColumns(10);

        final JTextField SignUptxtPassword = new JPasswordField();
        SignUptxtPassword.setBounds(25, 135, 200, 20);
        SignUpFrame.getContentPane().add(SignUptxtPassword);
        SignUptxtPassword.setColumns(10);

        final JTextField SignUptxtEmail = new JTextField();
        SignUptxtEmail.setBounds(25, 185, 200, 20);
        SignUpFrame.getContentPane().add(SignUptxtEmail);
        SignUptxtEmail.setColumns(10);

        JButton btnSubmit = new JButton("Add User");
        btnSubmit.setBounds(350, 300, 90, 25);
        SignUpFrame.getContentPane().add(btnSubmit);

        JLabel SignUptxtEnterYourName = new JLabel();
        SignUptxtEnterYourName.setText("Enter your Name:");
        SignUptxtEnterYourName.setBounds(25, 10, 133, 20);
        SignUpFrame.getContentPane().add(SignUptxtEnterYourName);

        JLabel SignUptxtEnterYourId = new JLabel();
        SignUptxtEnterYourId.setText("Enter your ID:");
        SignUptxtEnterYourId.setBounds(25, 60, 133, 20);
        SignUpFrame.getContentPane().add(SignUptxtEnterYourId);

        JLabel SignUptxtEnterYourPassword = new JLabel();
        SignUptxtEnterYourPassword.setText("Enter your Password:");
        SignUptxtEnterYourPassword.setBounds(25, 110, 133, 20);
        SignUpFrame.getContentPane().add(SignUptxtEnterYourPassword);

        JLabel SignUptxtEnterYourEmail = new JLabel();
        SignUptxtEnterYourEmail.setText("Enter your E-mail:");
        SignUptxtEnterYourEmail.setBounds(25, 160, 133, 20);
        SignUpFrame.getContentPane().add(SignUptxtEnterYourEmail);

        JLabel SignUptxtEnterYourRole = new JLabel();
        SignUptxtEnterYourRole.setText("Choose your Role:");
        SignUptxtEnterYourRole.setBounds(25, 210, 133, 20);
        SignUpFrame.getContentPane().add(SignUptxtEnterYourRole);

        String[] UserOptions = { "Tester", "Developer", "Project Manager", "Admin" };

        final JComboBox UserList = new JComboBox(UserOptions);
        UserList.setSelectedIndex(0);
        UserList.setBounds(25, 235, 200, 30);
        SignUpFrame.getContentPane().add(UserList);

        btnSubmit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String name = SignUptxtName.getText();
            String id = SignUptxtId.getText();
            String password = SignUptxtPassword.getText();
            String email = SignUptxtEmail.getText();
            String role = (String) UserList.getSelectedItem();
            String Table = "";
            String userType = "";

            if (role == "Tester") {
              Table = "Testers";
              userType = "Tester";
            } else if (role == "Developer") {
              Table = "Developers";
              userType = "Developer";
            } else if (role == "Project Manager") {
              Table = "ProjectManagers";
              userType = "Project Manager";
            } else if (role == "Admin") {
              Table = "Admins";
              userType = "Admin";
            }

            Boolean x = DataBase.insertData(name, id, password, email, Table);
            if (x) {
              SignUpFrame.dispose();
              System.out.println("Data inserted successfully!");
              admin();

            } else {
              JOptionPane.showMessageDialog(SignUpFrame, "Invalid Data.", "Error!", JOptionPane.WARNING_MESSAGE);

            }
            SignUptxtName.setText("");
            SignUptxtId.setText("");
            SignUptxtPassword.setText("");
            SignUptxtEmail.setText("");
          }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(50, 300, 90, 25);
        SignUpFrame.getContentPane().add(btnBack);

        btnBack.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            SignUpFrame.dispose();
            admin();
          }
        });
      }
    });

    JButton btnUpdate = new JButton("Update Users");
    btnUpdate.setBounds(175, 160, 125, 25);
    bgLabel.add(btnUpdate);

    JButton btnDelete = new JButton("Delete Users");
    btnDelete.setBounds(175, 210, 125, 25);
    bgLabel.add(btnDelete);

    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        adFrame.dispose();
        final JFrame DeleteFrame = new JFrame("Delete User");
        DeleteFrame.setSize(500, 400);
        DeleteFrame.setLocationRelativeTo(null);
        DeleteFrame.setVisible(true);
        DeleteFrame.setResizable(false);
        DeleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DeleteFrame.getContentPane().setLayout(null);

        JLabel updatetxtEnterRole = new JLabel();
        updatetxtEnterRole.setText("Choose User Role");
        updatetxtEnterRole.setBounds(183, 10, 133, 20);
        DeleteFrame.getContentPane().add(updatetxtEnterRole);

        JButton btnTesters = new JButton("Testers");
        btnTesters.setBounds(150, 40, 175, 25);
        DeleteFrame.getContentPane().add(btnTesters);

        JButton btnDevs = new JButton("Developers");
        btnDevs.setBounds(150, 90, 175, 25);
        DeleteFrame.getContentPane().add(btnDevs);

        JButton btnPMs = new JButton("Project Managers");
        btnPMs.setBounds(150, 140, 175, 25);
        DeleteFrame.getContentPane().add(btnPMs);

        JButton btnAdmins = new JButton("Admins");
        btnAdmins.setBounds(150, 190, 175, 25);
        DeleteFrame.getContentPane().add(btnAdmins);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(150, 240, 175, 25);
        DeleteFrame.getContentPane().add(btnBack);

        btnTesters.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Admin.delete("Tester", DeleteFrame);
          }
        });

        btnDevs.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Admin.delete("Developer", DeleteFrame);
          }
        });

        btnPMs.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Admin.delete("Project Manager", DeleteFrame);
          }
        });

        btnAdmins.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Admin.delete("Admin", DeleteFrame);
          }
        });

        btnBack.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            DeleteFrame.dispose();
            admin();
          }
        });
      }
    });

    btnUpdate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        adFrame.dispose();
        final JFrame Updateframe = new JFrame("User Updater");
        Updateframe.setSize(500, 400);
        Updateframe.setLocationRelativeTo(null);
        Updateframe.setResizable(false);
        Updateframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Updateframe.getContentPane().setLayout(null);
        Updateframe.setVisible(true);

        JLabel updatetxtEnterRole = new JLabel();
        updatetxtEnterRole.setText("Choose User Role");
        updatetxtEnterRole.setBounds(183, 10, 133, 20);
        Updateframe.getContentPane().add(updatetxtEnterRole);

        JButton btnTesters = new JButton("Testers");
        btnTesters.setBounds(150, 40, 175, 25);
        Updateframe.getContentPane().add(btnTesters);

        JButton btnDevs = new JButton("Developers");
        btnDevs.setBounds(150, 90, 175, 25);
        Updateframe.getContentPane().add(btnDevs);

        JButton btnPMs = new JButton("Project Managers");
        btnPMs.setBounds(150, 140, 175, 25);
        Updateframe.getContentPane().add(btnPMs);

        JButton btnAdmins = new JButton("Admins");
        btnAdmins.setBounds(150, 190, 175, 25);
        Updateframe.getContentPane().add(btnAdmins);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(150, 240, 175, 25);
        Updateframe.getContentPane().add(btnBack);

        btnTesters.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Admin.Update("Tester", Updateframe);
          }
        });

        btnDevs.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Admin.Update("Developer", Updateframe);
          }
        });

        btnPMs.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Admin.Update("Project Manager", Updateframe);
          }
        });

        btnAdmins.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Admin.Update("Admin", Updateframe);
          }
        });

        btnBack.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Updateframe.dispose();
            admin();
          }
        });
      }

    });

    JButton btnBack = new JButton("Log Out");
    btnBack.setBounds(175, 260, 125, 25);
    bgLabel.add(btnBack);

    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        adFrame.dispose();
        home.homePage();
      }
    });

    btnViewBugs.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DataBase.viewTable("Bugs");
      }
    });
  }

  public static void tester(final String email) {
    final String ID = DataBase.getIDByName(email, "id", "Testers", "email");

    final JFrame testerFrame = new JFrame("Tester Window");
    testerFrame.setSize(500, 400);
    testerFrame.setVisible(true);
    testerFrame.setLocationRelativeTo(null);
    testerFrame.setResizable(false);
    testerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    testerFrame.getContentPane().setLayout(null);

    ImageIcon background = new ImageIcon("src/main/resources/images/testerbg.png");
    JLabel bgLabel = new JLabel(background);
    bgLabel.setSize(500, 400);
    bgLabel.setLocation(0, 0);
    testerFrame.add(bgLabel);

    JButton btnAddBug = new JButton("Add Bug");
    btnAddBug.setBounds(175, 60, 125, 25);
    bgLabel.add(btnAddBug);

    JButton btnViewBugs = new JButton("View Bugs");
    btnViewBugs.setBounds(175, 110, 125, 25);
    bgLabel.add(btnViewBugs);

    btnViewBugs.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("Bug Viewer");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        DataBase.viewspecificdata(table, "Bugs", "testerid", ID);
        // if no bugs are found
        if (table.getRowCount() == 0) {
          JOptionPane.showMessageDialog(null, "No Bugs Found");
          frame.dispose();
        } else {
          frame.setVisible(true);
        }
      }
    });

    ImageIcon chaticon = new ImageIcon("src/main/resources/images/chaticon.png");
    JButton btnChat = new JButton(chaticon);
    btnChat.setBounds(436, 0, 50, 50);
    bgLabel.add(btnChat);

    btnChat.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ChatEntry.hostChat(email);
      }
    });

    JButton btnViewDevs = new JButton("View Devs");
    btnViewDevs.setBounds(175, 210, 125, 25);
    bgLabel.add(btnViewDevs);

    btnViewDevs.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DataBase.viewTable("Developers");
      }
    });

    JButton btnBack = new JButton("Log Out");
    btnBack.setBounds(175, 260, 125, 25);
    bgLabel.add(btnBack);

    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        testerFrame.dispose();
        home.homePage();
      }
    });

    JButton btnAssignBug = new JButton("Assign Bug");
    btnAssignBug.setBounds(175, 160, 125, 25);
    bgLabel.add(btnAssignBug);

    btnAssignBug.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        testerFrame.dispose();
        final JFrame assignFrame = new JFrame("Assign Bug");
        assignFrame.setSize(500, 400);
        assignFrame.setLocationRelativeTo(null);
        assignFrame.setResizable(false);
        assignFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        assignFrame.setVisible(true);
        assignFrame.getContentPane().setLayout(null);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(50, 300, 90, 25);
        assignFrame.getContentPane().add(btnBack);

        btnBack.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            assignFrame.dispose();
            tester(email);
          }
        });

        JLabel assignBugtxtChooseBug = new JLabel();
        assignBugtxtChooseBug.setText("Choose Bug Name:");
        assignBugtxtChooseBug.setBounds(25, 10, 133, 20);
        assignFrame.getContentPane().add(assignBugtxtChooseBug);

        List<String> Bugs = DataBase.getColumnspecific3Values("name", "Bugs", "testerid", ID, "status",
            "open", "developerid");
        String Bugsarray[] = new String[Bugs.size()];
        for (int j = 0; j < Bugs.size(); j++) {
          Bugsarray[j] = Bugs.get(j);
        }
        // display error message if no bugs are available
        if (Bugsarray.length == 0) {
          JOptionPane.showMessageDialog(null, "No Bugs Available");
          assignFrame.dispose();
          tester(email);
        }

        final JComboBox BugsCombo = new JComboBox(Bugsarray);
        BugsCombo.setSelectedIndex(0);
        BugsCombo.setBounds(25, 35, 200, 20);
        assignFrame.getContentPane().add(BugsCombo);

        JLabel assignBugtxtChooseDev = new JLabel();
        assignBugtxtChooseDev.setText("Choose Dev Name:");
        assignBugtxtChooseDev.setBounds(25, 60, 133, 20);
        assignFrame.getContentPane().add(assignBugtxtChooseDev);

        List<String> Devs = DataBase.getColumnValues("name", "Developers");
        String Devarray[] = new String[Devs.size()];
        for (int j = 0; j < Devs.size(); j++) {
          Devarray[j] = Devs.get(j);
        }

        final JComboBox DevsCombo = new JComboBox(Devarray);
        DevsCombo.setSelectedIndex(0);
        DevsCombo.setBounds(25, 85, 200, 20);
        assignFrame.getContentPane().add(DevsCombo);

        JLabel DueDate = new JLabel();
        DueDate.setText("Due Date:");
        DueDate.setBounds(300, 10, 133, 20);
        assignFrame.getContentPane().add(DueDate);

        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
        datePicker.setBounds(300, 35, 150, 30);
        assignFrame.add(datePicker);
             
        

        
        datePicker.getJFormattedTextField().addPropertyChangeListener("value", event -> {
          Calendar selectedCalendar = (Calendar) event.getNewValue();
          if (selectedCalendar != null) {
              // make sure that the selected date is not in the past
              Calendar now = Calendar.getInstance();
              if (selectedCalendar.before(now)) {
                  datePicker.getJFormattedTextField().setValue(null);
                  JOptionPane.showMessageDialog(null, "Please select a future date", "Warning!", JOptionPane.ERROR_MESSAGE);
                  return;
              }
              // get the selected date
              Date selectedDate = selectedCalendar.getTime();
              LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
              formattedDate = localDate.format(formatter);
              datePicker.getJFormattedTextField().setText(formattedDate);
          }
      });


        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(350, 300, 90, 25);
        assignFrame.getContentPane().add(btnSubmit);

        JButton btnattach = new JButton("Attach File");
        btnattach.setBounds(25, 135, 120, 25);
        assignFrame.getContentPane().add(btnattach);

        // make it smaller and red
        final JLabel lblPath = new JLabel("Max size 5MB");
        lblPath.setBounds(25, 165, 100, 14);
        assignFrame.getContentPane().add(lblPath);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setText(path);
        textField.setBounds(25, 185, 300, 25);
        assignFrame.getContentPane().add(textField);

        JButton btnclear = new JButton("Clear");
        btnclear.setBounds(25, 225, 70, 20);
        assignFrame.getContentPane().add(btnclear);

        btnclear.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            textField.setText("");
            path = "";
          }
        });

        btnattach.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG Images", "png", "jpg");
            fileChooser.setFileFilter(filter);

            // Set the file size limit to 5 MB (5 * 1024 * 1024 bytes)
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileViewWithSizeLimit fsz = new FileViewWithSizeLimit(5 * 1024 * 1024);

            int result = fileChooser.showOpenDialog(assignFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
              File selectedFile = fileChooser.getSelectedFile();
              // Process the selected image file
              System.out.println("Selected file: " + selectedFile.getAbsolutePath());
              path = selectedFile.getAbsolutePath();
              if (fsz.isTraversable(selectedFile)) {
                textField.setText(path);
              } else {
                JOptionPane.showMessageDialog(assignFrame, "File size limit is 5 Mb", "File Limit Exceeded",
                    JOptionPane.WARNING_MESSAGE);
                lblPath.setForeground(Color.RED);
              }
            }
          }
        });

        btnSubmit.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            final String BugName = (String) BugsCombo.getSelectedItem();
            final String DevName = (String) DevsCombo.getSelectedItem();
            String DevID = DataBase.getIDByName(DevName, "id", "Developers", "name");
            DataBase.updateDatabug("Bugs", "name", BugName, "deadline", formattedDate);
            DataBase.updateDatabug("Bugs", "name", BugName, "startdate", Dates.getCurrentDate()); // Make start date = current date assigned to the dev
            
            if (formattedDate == null) {
              JOptionPane.showMessageDialog(assignFrame, "Please add due date.", "Error!",
                  JOptionPane.WARNING_MESSAGE);
              return;
            }
            
            Boolean x = DataBase.updateDatabug("Bugs", "name", BugName, "developerid", DevID);

            if (x) {

              assignFrame.dispose();
              tester(email);
              Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                  try {
                    SendMail.sendEmail(BugName, DevName, path);
                    path = "";
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
                }
              });
              thread.start();
            } else {
              JOptionPane.showMessageDialog(assignFrame, "Invalid Data.", "Error!", JOptionPane.WARNING_MESSAGE);
            }
          }
        });
      }
    });

    btnAddBug.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        testerFrame.dispose();
        Tester.addBug(email, ID);
      }
    });
  }
}

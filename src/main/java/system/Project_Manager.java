package system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import DB.DataBase;

public class Project_Manager {

  public static void PerformanceView(final String user) {
    final JFrame DevPerformFrame = new JFrame(user + " Performance");
    DevPerformFrame.setSize(300, 200);
    DevPerformFrame.setLocationRelativeTo(null);
    DevPerformFrame.setVisible(true);
    DevPerformFrame.setResizable(false);
    DevPerformFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    DevPerformFrame.getContentPane().setLayout(null);

    JLabel FinishtxtChooseTester = new JLabel();
    FinishtxtChooseTester.setText("Select " + user + ":");
    FinishtxtChooseTester.setBounds(25, 10, 150, 20);
    DevPerformFrame.getContentPane().add(FinishtxtChooseTester);

    List<String> Devs = DataBase.getColumnValues("name", user + "s");

    String Devsarray[] = new String[Devs.size()];
    for (int j = 0; j < Devs.size(); j++) {
      Devsarray[j] = Devs.get(j);
    }

    final JComboBox DevsCombo = new JComboBox(Devsarray);
    DevsCombo.setSelectedIndex(0);
    DevsCombo.setBounds(25, 35, 200, 20);
    DevPerformFrame.getContentPane().add(DevsCombo);

    JButton btnSubmit = new JButton("Calculate");
    btnSubmit.setBounds(95, 115, 90, 25);
    DevPerformFrame.getContentPane().add(btnSubmit);

    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (user.equals("Tester"))
          calcTestPerformance(DevPerformFrame, (String) DevsCombo.getSelectedItem());
        else if (user.equals("Developer"))
          calcDevPerformance(DevPerformFrame, (String) DevsCombo.getSelectedItem());
      }
    });
  }

  public static void calcDevPerformance(JFrame frame, String DevName) {
    String ID = DataBase.getIDByName(DevName, "id", "Developers", "name");
    List<String> Priorities = DataBase.getColumnspecificValues("priority", "Bugs", "developerid", ID);
    List<String> Levels = DataBase.getColumnspecificValues("level", "Bugs", "developerid", ID);
    List<Long> TimeList = DataBase.getLongColumnspecificValues("timetaken", "Bugs", "developerid", ID);

    int devdonebugs = DataBase.intgetIDByName(DevName, "donebugs", "Developers", "name");
    double performance = Performance.Developer(devdonebugs, Priorities, Levels, TimeList);

    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    String formattedperformance = decimalFormat.format(performance);

    JOptionPane.showMessageDialog(frame, "Performance: " + formattedperformance,
        "Calculation Successful!", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void calcTestPerformance(JFrame frame, String TesterName) {
    String ID = DataBase.getIDByName(TesterName, "id", "Testers", "name");
    List<String> Priorities = DataBase.getColumnspecificValues("priority", "Bugs", "testerid", ID);
    int allbugcount = DataBase.getRowCount("Bugs");
    int specificbugcount = DataBase.intgetIDByName(TesterName, "numbugs", "Testers", "name");
    double performance = Performance.Tester(allbugcount, specificbugcount, Priorities);

    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    String formattedperformance = decimalFormat.format(performance);

    JOptionPane.showMessageDialog(frame, "Performance: " + formattedperformance,
        "Calculation Successful!", JOptionPane.INFORMATION_MESSAGE);
  }
}

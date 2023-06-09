package system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DB.DataBase;
import GUI.UserGUI;

public class Tester {
  public static void addBug(final String email, final String ID) {
    final JFrame addFrame = new JFrame("Add Bug");
    addFrame.setSize(500, 400);
    addFrame.setLocationRelativeTo(null);
    addFrame.setResizable(false);
    addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    addFrame.setVisible(true);
    addFrame.getContentPane().setLayout(null);

    JLabel addBugtxtEnterName = new JLabel();
    addBugtxtEnterName.setText("Enter Bug Name:");
    addBugtxtEnterName.setBounds(25, 10, 133, 20);
    addFrame.getContentPane().add(addBugtxtEnterName);

    final JTextField addBugtxtName = new JTextField();
    addBugtxtName.setBounds(25, 35, 200, 20);
    addFrame.getContentPane().add(addBugtxtName);
    addBugtxtName.setColumns(10);

    JLabel addBugtxtEnterProjectName = new JLabel();
    addBugtxtEnterProjectName.setText("Enter Project Name:");
    addBugtxtEnterProjectName.setBounds(260, 10, 133, 20);
    addFrame.getContentPane().add(addBugtxtEnterProjectName);

    final JTextField addBugtxtProjectName = new JTextField();
    addBugtxtProjectName.setBounds(260, 35, 200, 20);
    addFrame.getContentPane().add(addBugtxtProjectName);
    addBugtxtProjectName.setColumns(10);

    JLabel addBugtxtEnterStartDate = new JLabel();
    addBugtxtEnterStartDate.setText("Start Date:");
    addBugtxtEnterStartDate.setBounds(260, 110, 133, 20);
    addFrame.getContentPane().add(addBugtxtEnterStartDate);

    final JTextField addBugtxtStartDate = new JTextField();
    addBugtxtStartDate.setText(Dates.getCurrentDate());
    addBugtxtStartDate.setEditable(false);
    addBugtxtStartDate.setBounds(260, 135, 200, 20);
    addFrame.getContentPane().add(addBugtxtStartDate);
    addBugtxtStartDate.setColumns(10);

    JLabel addBugtxtEnterType = new JLabel();
    addBugtxtEnterType.setText("Enter Bug Type:");
    addBugtxtEnterType.setBounds(25, 60, 133, 20);
    addFrame.getContentPane().add(addBugtxtEnterType);

    String[] BugTypes = { "Logic Bug", "Syntax Bug", "Security Bug", "Performance Bug" };

    final JComboBox TypeCombo = new JComboBox(BugTypes);
    TypeCombo.setSelectedIndex(0);
    TypeCombo.setBounds(25, 85, 200, 20);
    addFrame.getContentPane().add(TypeCombo);

    JLabel addBugtxtEnterPriority = new JLabel();
    addBugtxtEnterPriority.setText("Enter Bug Priority:");
    addBugtxtEnterPriority.setBounds(25, 110, 133, 20);
    addFrame.getContentPane().add(addBugtxtEnterPriority);

    String[] BugPriorities = { "Low", "Medium", "High" };

    final JComboBox PriorityCombo = new JComboBox(BugPriorities);
    PriorityCombo.setSelectedIndex(0);
    PriorityCombo.setBounds(25, 135, 200, 20);
    addFrame.getContentPane().add(PriorityCombo);

    JLabel addBugtxtEnterLevel = new JLabel();
    addBugtxtEnterLevel.setText("Enter Bug Level:");
    addBugtxtEnterLevel.setBounds(260, 60, 133, 20);
    addFrame.getContentPane().add(addBugtxtEnterLevel);

    String[] BugLevels = { "Easy", "Medium", "Hard", "Level El Wa7sh" };

    final JComboBox LevelCombo = new JComboBox(BugLevels);
    LevelCombo.setSelectedIndex(0);
    LevelCombo.setBounds(260, 85, 200, 20);
    addFrame.getContentPane().add(LevelCombo);

    JButton btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(350, 300, 90, 25);
    addFrame.getContentPane().add(btnSubmit);

    btnSubmit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String BugName = addBugtxtName.getText();
        String BugID = "";
        String BugType = (String) TypeCombo.getSelectedItem();
        String BugPriority = (String) PriorityCombo.getSelectedItem();
        String BugLevel = (String) LevelCombo.getSelectedItem();
        String ProjectName = addBugtxtProjectName.getText();
        String StartDate = Dates.getCurrentDate();

        if (BugName.equals("") || ProjectName.equals("") || StartDate.equals("")) {
          JOptionPane.showMessageDialog(addFrame, "Please fill all the data.", "Error!", JOptionPane.WARNING_MESSAGE);
          return;
        }
        Boolean inserted = false;
        while (!inserted) {
          Random random = new Random();
          BugID = String.valueOf(random.nextInt(1000));
          inserted = DataBase.insertDataBug(BugID, BugName, BugType, BugPriority, ProjectName, StartDate,
              "", BugLevel, ID);
        }

        if (inserted) {
          addFrame.dispose();
          UserGUI.tester(email);
        } else {
          JOptionPane.showMessageDialog(addFrame, "Invalid Data.", "Error!", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    JButton btnBack = new JButton("Back");
    btnBack.setBounds(50, 300, 90, 25);
    addFrame.getContentPane().add(btnBack);

    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addFrame.dispose();
        UserGUI.tester(email);
      }
    });

  }

}

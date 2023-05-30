package system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GUI.UserGUI;
import DB.DataBase;
import javax.swing.JFrame;

public class Admin  {

  public static void delete(String username, final JFrame window) {
    final JFrame DeleteFrame = new JFrame(username + " Deleter");
    String table = "";
    if (username.equals("Project Manager")) {
      table = "ProjectManagers";
    } else {
      table = username + "s";
    }
    DeleteFrame.setSize(300, 300);
    DeleteFrame.setLocationRelativeTo(null);
    DeleteFrame.setResizable(false);
    DeleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    DeleteFrame.getContentPane().setLayout(null);
    DeleteFrame.setVisible(true);

    JLabel TestertxtChooseName = new JLabel();
    TestertxtChooseName.setText("Choose " + username + " Name:");
    TestertxtChooseName.setBounds(25, 10, 130, 20);
    DeleteFrame.getContentPane().add(TestertxtChooseName);

    List<String> Testers = DataBase.getColumnValues("name", table);
    String Testersarray[] = new String[Testers.size()];
    for (int j = 0; j < Testers.size(); j++) {
      Testersarray[j] = Testers.get(j);
    }

    final JComboBox TestersCombo = new JComboBox(Testersarray);
    TestersCombo.setSelectedIndex(0);
    TestersCombo.setBounds(25, 35, 200, 20);
    DeleteFrame.getContentPane().add(TestersCombo);

    JButton btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(95, 200, 90, 25);
    DeleteFrame.getContentPane().add(btnSubmit);
    final String tab = table;

    btnSubmit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String TesterName = (String) TestersCombo.getSelectedItem();
        
        Boolean x = DataBase.deleteRow(tab, "name", TesterName);

        if (x) {
          DeleteFrame.dispose();
          window.dispose();
          UserGUI.admin();
        } else {
          JOptionPane.showMessageDialog(DeleteFrame, "Invalid Data.", "Error!", JOptionPane.WARNING_MESSAGE);
        }

      }
    });
  }

  public static void Update (String username, final JFrame window) {
    final JFrame updateFrame = new JFrame(username+" Updater");
            updateFrame.setSize(300, 300);
            updateFrame.setLocationRelativeTo(null);
            updateFrame.setResizable(false);
            updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            updateFrame.getContentPane().setLayout(null);
            updateFrame.setVisible(true);

            String table = "";
            if (username.equals("Project Manager")) {
              table = "ProjectManagers";
            } else {
              table = username + "s";
            }

            JLabel PMtxtChooseName = new JLabel();
            PMtxtChooseName.setText("Choose "+username+" Name:");
            PMtxtChooseName.setBounds(25, 10, 200, 20);
            updateFrame.getContentPane().add(PMtxtChooseName);

            List<String> PMs = DataBase.getColumnValues("name", table);
            String PMsarray[] = new String[PMs.size()];
            for (int j = 0; j < PMs.size(); j++) {
              PMsarray[j] = PMs.get(j);
            }

            final JComboBox PMsCombo = new JComboBox(PMsarray);
            PMsCombo.setSelectedIndex(0);
            PMsCombo.setBounds(25, 35, 200, 20);
            updateFrame.getContentPane().add(PMsCombo);

            JLabel PMtxtChooseField = new JLabel();
            PMtxtChooseField.setText("Choose "+username+" Field:");
            PMtxtChooseField.setBounds(25, 60, 200, 20);
            updateFrame.getContentPane().add(PMtxtChooseField);

            String Fieldsarray[] = new String[] { "Name", "ID", "E-Mail", "Password" };

            final JComboBox FieldsCombo = new JComboBox(Fieldsarray);
            FieldsCombo.setSelectedIndex(0);
            FieldsCombo.setBounds(25, 85, 200, 20);
            updateFrame.getContentPane().add(FieldsCombo);

            JLabel PMtxtChangeField = new JLabel();
            PMtxtChangeField.setText("Change Chosen Field:");
            PMtxtChangeField.setBounds(25, 110, 130, 20);
            updateFrame.getContentPane().add(PMtxtChangeField);

            final JTextField PMtxtFieldEntry = new JTextField();
            PMtxtFieldEntry.setBounds(25, 135, 200, 20);
            updateFrame.getContentPane().add(PMtxtFieldEntry);
            PMtxtFieldEntry.setColumns(10);

            JButton btnSubmit = new JButton("Submit");
            btnSubmit.setBounds(95, 200, 90, 25);
            updateFrame.getContentPane().add(btnSubmit);
            final String tab = table;
            btnSubmit.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                String PMName = (String) PMsCombo.getSelectedItem();
                String PMField = (String) FieldsCombo.getSelectedItem();
                String FieldChange = PMtxtFieldEntry.getText();
                String FieldInput = "";

                if (PMField == "Name") {
                  FieldInput = "name";
                } else if (PMField == "ID") {
                  FieldInput = "id";
                } else if (PMField == "E-Mail") {
                  FieldInput = "email";
                } else if (PMField == "Password") {
                  FieldInput = "password";
                }

                Boolean x = DataBase.updateDatabug(tab, "name", PMName, FieldInput, FieldChange);

                if (x) {
                  updateFrame.dispose();
                  window.dispose();
                  UserGUI.admin();
                } else {
                  JOptionPane.showMessageDialog(updateFrame, "Invalid Data.", "Error!", JOptionPane.WARNING_MESSAGE);
                }
                PMtxtFieldEntry.setText("");
              }
            });
  }


}

package system;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Authentication.Auth;

public class Developer {
	public static void search () {
		final JFrame SearchFrame = new JFrame("Search window");
        SearchFrame.setSize(500, 500);
        SearchFrame.setLocationRelativeTo(null);
        SearchFrame.setVisible(true);
        SearchFrame.setResizable(true);
        SearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SearchFrame.getContentPane().setLayout(null);

        final JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        // Create a JTextField for user input
        final JTextField inputField = new JTextField();

        // Create a JButton for sending the input
        JButton sendButton = new JButton("Search");
        sendButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = inputField.getText();
            List<String> Results = new ArrayList<String>();
            Results = Auth.GoogleSearch(input);

            Results.remove(0);
            Results.remove(Results.size() - 1);
            Results.remove(Results.size() - 1);
            Results.remove(Results.size() - 1);

            for (String link : Results) {
              Auth.processInput(link, outputArea);
            }
            Auth.processInput(
                "--------------------------------------------------------------------------------------------------------------------------------------------------",
                outputArea);
            inputField.setText("");
          }
        });

        // Create a JPanel to hold the input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Add the JTextArea and input panel to the JFrame
        SearchFrame.getContentPane().setLayout(new BorderLayout());
        SearchFrame.getContentPane().add(new JScrollPane(outputArea), BorderLayout.CENTER);
        SearchFrame.getContentPane().add(inputPanel, BorderLayout.SOUTH);


	}

}

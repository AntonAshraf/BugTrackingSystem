package system;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import Authentication.Auth;

public class Developer {
  public static void search() {
    final JFrame SearchFrame = new JFrame("Search window");
    SearchFrame.setSize(500, 500);
    SearchFrame.setLocationRelativeTo(null);
    SearchFrame.setVisible(true);
    SearchFrame.setResizable(true);
    SearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    SearchFrame.getContentPane().setLayout(null);

    final JEditorPane outputArea = new JEditorPane();
    outputArea.setEditable(false);
    outputArea.setContentType("text/html"); // Set content type to HTML

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

        StringBuilder htmlContent = new StringBuilder();
        int linkCount = 0;
        for (String link : Results) {
          linkCount++;
          try {
            URL url = new URL(link);
            String host = url.getHost();
            String path = url.getPath();
            String[] pathSegments = path.split("/");
            StringBuilder domainWithPath = new StringBuilder(host);
            if (pathSegments.length > 1) {
              domainWithPath.append("/").append(pathSegments[1]);
              if (pathSegments.length > 2) {
                domainWithPath.append("/").append(pathSegments[2]);
              }
            }
            htmlContent.append("<p>").append(linkCount).append(". <a href='").append(link).append("'>")
                .append(domainWithPath).append("</a></p>");
          } catch (MalformedURLException ex) {
            ex.printStackTrace();
          }
        }
        htmlContent.append("<hr>");
        outputArea.setText(htmlContent.toString());
        inputField.setText("");
      }
    });

    // Add a HyperlinkListener to handle link clicks
    outputArea.addHyperlinkListener(new HyperlinkListener() {

      @Override
      public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
          try {
            Desktop.getDesktop().browse(e.getURL().toURI());
          } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
          }
        }
      }
    });

    // Create a JPanel to hold the input components
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new BorderLayout());
    inputPanel.add(inputField, BorderLayout.CENTER);
    inputPanel.add(sendButton, BorderLayout.EAST);

    // Add the JEditorPane and input panel to the JFrame
    SearchFrame.getContentPane().setLayout(new BorderLayout());
    SearchFrame.getContentPane().add(new JScrollPane(outputArea), BorderLayout.CENTER);
    SearchFrame.getContentPane().add(inputPanel, BorderLayout.SOUTH);

  }

}

package EmailSender;

import system.Bug;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import DB.DataBase;

public class SendMail extends EmailData {

  public static void sendEmail(String BugName, String DevName, String PATH) {
    // Recipient's email ID needs to be mentioned.
    final Bug bug = new Bug(BugName);
    
    String to = bug.getDeveloperEmail();

    
    String TesterName = bug.getTesterName();
    
    // Find the position of the first space
    int spaceIndex = TesterName.indexOf(" ");
 
    // Sender's email ID needs to be mentioned
    final String from = TesterName.substring(0, spaceIndex);

    // Assuming you are sending email from through gmails smtp
    String host = "smtp.gmail.com";

    // Get system properties
    Properties properties = System.getProperties();

    // Setup mail server
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.auth", "true");

    // Get the Session object.// and pass username and password
    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

      protected PasswordAuthentication getPasswordAuthentication() {

        return new PasswordAuthentication("ooptester1@gmail.com", "ixzcbsrhunzwvsbe");

      }

    });

    // Used to debug SMTP issues
    session.setDebug(true);

    try {
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

      // Set Subject: header field
      message.setSubject(EmailData.getSubject(BugName));
      
      Multipart multipart = new MimeMultipart();

      MimeBodyPart attachmentPart = new MimeBodyPart();

      MimeBodyPart textPart = new MimeBodyPart();

      textPart.setText(EmailData.getbody(DevName, BugName));
      multipart.addBodyPart(textPart);

      if (PATH == null) {
        System.out.println("No attachment");
      } else {
        try {

          File f = new File(PATH);

          attachmentPart.attachFile(f);
          multipart.addBodyPart(attachmentPart);

        } catch (IOException e) {

          e.printStackTrace();

        }
      }

      message.setContent(multipart);

      System.out.println("sending...");
      // Send message
      Transport.send(message);
      System.out.println("Sent message successfully....");
    } catch (MessagingException mex) {
      mex.printStackTrace();
    }

  }
  public static void sendEmail(String DevName, String email, String ip, int port) {
    String to = DataBase.getIDByName(DevName, "email", "Developers", "name");

    final String from = email;

    String host = "smtp.gmail.com";

    Properties properties = System.getProperties();

    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.auth", "true");

    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

      protected PasswordAuthentication getPasswordAuthentication() {
        String Pass = DataBase.getIDByName(email, "password", "Testers", "email");
        return new PasswordAuthentication(from, Pass);
      }

    });

    try {
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        message.setSubject(EmailData.getSubject());

        String portString = Integer.toString(port);
        message.setText(EmailData.getbody(DevName, ip, portString, email));
        
        Transport.send(message);
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }
  }

}

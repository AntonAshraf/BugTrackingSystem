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

public class SendMail extends EmailData {

  public static void sendEmail(String BugName, String DevName, String PATH) {
    // Recipient's email ID needs to be mentioned.
    final Bug bug = new Bug(BugName);
    String to = bug.getDeveloperEmail();

    // Sender's email ID needs to be mentioned
    final String from = bug.getTesterEmail();

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

        return new PasswordAuthentication(from, bug.getTesterPassword());

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
      message.setSubject(EmailData.getSubject(host));

      Multipart multipart = new MimeMultipart();

      MimeBodyPart attachmentPart = new MimeBodyPart();

      MimeBodyPart textPart = new MimeBodyPart();

      try {

        File f = new File(PATH);

        attachmentPart.attachFile(f);
        textPart.setText(EmailData.getbody(DevName, BugName));
        multipart.addBodyPart(textPart);
        multipart.addBodyPart(attachmentPart);

      } catch (IOException e) {

        e.printStackTrace();

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

}
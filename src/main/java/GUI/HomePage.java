package GUI;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

  public void homePage() {

    final AuthGUI auth = new AuthGUI();
    final JFrame homeFrame = new JFrame("Main Menu");

    homeFrame.setLocation(710, 340);
    homeFrame.setSize(500, 400);
    homeFrame.setLocationRelativeTo(null);
    homeFrame.setVisible(true);
    homeFrame.setResizable(false);
    homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    homeFrame.getContentPane().setLayout(null);
    ImageIcon background = new ImageIcon("src/main/resources/images/bg.png");
    JLabel bgLabel = new JLabel(background);
    bgLabel.setSize(500, 400);
    bgLabel.setLocation(0, 0);
    homeFrame.add(bgLabel);

    ImageIcon signinicon = new ImageIcon("src/main/resources/images/signup.png");
    JButton btnsignup = new JButton(signinicon);
    btnsignup.setOpaque(false);
    btnsignup.setContentAreaFilled(false);
    btnsignup.setBorderPainted(false);
    btnsignup.setBounds(140, 100, 200, 38);
    bgLabel.add(btnsignup);

    ImageIcon loginicon = new ImageIcon("src/main/resources/images/login.png");
    JButton btnlogin = new JButton(loginicon);
    btnlogin.setOpaque(false); // Remove Opacity
    btnlogin.setContentAreaFilled(false); // Remove filled background
    btnlogin.setBorderPainted(false); // Remove Button border
    btnlogin.setBounds(140, 150, 200, 38);
    bgLabel.add(btnlogin);

    ImageIcon infoicon = new ImageIcon("src/main/resources/images/info.png");
    JButton btninfo = new JButton(infoicon);
    btninfo.setOpaque(false); // Remove Opacity
    btninfo.setContentAreaFilled(false); // Remove filled background
    btninfo.setBorderPainted(false); // Remove Button border
    btninfo.setBounds(140, 200, 200, 38);
    bgLabel.add(btninfo);

    ImageIcon exiticon = new ImageIcon("src/main/resources/images/exit.png");
    JButton btnexit = new JButton(exiticon);
    btnexit.setOpaque(false); // Remove Opacity
    btnexit.setContentAreaFilled(false); // Remove filled background
    btnexit.setBorderPainted(false); // Remove Button border
    btnexit.setBounds(140, 250, 200, 38);
    bgLabel.add(btnexit);

    btnlogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        homeFrame.dispose();
        auth.login();
      }
    });

    btnsignup.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        homeFrame.dispose();
        auth.signup();
      }
    });
    btninfo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        homeFrame.dispose();
        auth.info();
      }
    });
    btnexit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        homeFrame.dispose();
      }
    });

  }

}

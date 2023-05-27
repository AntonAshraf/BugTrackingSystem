package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame{
  
  private JPanel contentPane;

  public void homePage() {
    AuthGUI auth = new AuthGUI();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 514, 356);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JButton btnsignup = new JButton("sign up");
    btnsignup.setBounds(176, 94, 130, 23);
    contentPane.add(btnsignup);

    JButton btnlogin = new JButton("login");
    btnlogin.setBounds(176, 194, 130, 23);
    contentPane.add(btnlogin);

    btnlogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        auth.login();
      }
    });

    btnsignup.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        auth.signup();
      }
    });

  }

}

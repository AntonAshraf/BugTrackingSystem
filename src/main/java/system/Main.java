package system;

import java.awt.EventQueue;

import GUI.HomePage;

public class Main {

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          HomePage frame = new HomePage();
          frame.homePage();
          // frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

  }
}

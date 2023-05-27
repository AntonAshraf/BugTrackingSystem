package GUI;
import Authentication.Auth;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class UserGUI {

  public static void UserPage(String UserType, String name, String id, String email) {
    if (UserType.equals("Project Manager")) {
      projectmanager();
    } else if (UserType.equals("Developer")) {
      developer();
    } else if (UserType.equals("Admin")) {
      admin();
    } else if (UserType.equals("Tester")) {
      tester();
    }
  }

  public static void projectmanager() {
		    JFrame prowFrame = new JFrame("project manager window");

		    prowFrame.setSize(400, 300);
		    prowFrame.setVisible(true);

		    prowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		    prowFrame.getContentPane().setLayout(null);
		  }

  public static void developer() {
    JFrame devwFrame = new JFrame("Developer window");

    devwFrame.setSize(400, 300);
    devwFrame.setVisible(true);

    devwFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    devwFrame.getContentPane().setLayout(null);
  }

  public static void admin() {
    JFrame adwFrame = new JFrame("Admin window");
    
    adwFrame.setSize(400, 300); 
    adwFrame.setVisible(true);

    adwFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    adwFrame.getContentPane().setLayout(null);
  }

  public static void tester() {
		    JFrame testerFrame = new JFrame("Tester window");

		    testerFrame.setSize(400, 300);
		    testerFrame.setVisible(true);

		    testerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		    testerFrame.getContentPane().setLayout(null);

		    JButton btnbug = new JButton("add bug");
		    btnbug.setBounds(45, 218, 104, 23);
		    testerFrame.getContentPane().add(btnbug);
		    
		    JButton btnvbug = new JButton("view bugs");
		    btnvbug.setBounds(145, 218, 104, 23);
		    testerFrame.getContentPane().add(btnvbug);
		    
		    JButton btnvdev = new JButton("view Developers");
		    btnvdev.setBounds(45, 118, 104, 23);
		    testerFrame.getContentPane().add(btnvdev);
		    
		    btnvbug.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
				    
				    JFrame frame = new JFrame("Bug Viewer");
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
			        JTable table = new JTable();
			        JScrollPane scrollPane = new JScrollPane(table);
			        frame.add(scrollPane, BorderLayout.CENTER);
	
			        Auth.viewdata(table,"Bugs");
	
			        frame.pack();
			        frame.setVisible(true);
                    
                }
            });
		    btnvdev.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
				    
				    JFrame dframe = new JFrame("Bug Viewer");
			        dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
			        JTable table = new JTable();
			        JScrollPane scrollPane = new JScrollPane(table);
			        dframe.add(scrollPane, BorderLayout.CENTER);
	
			        Auth.viewdata(table,"Developers");
	
			        dframe.pack();
			        dframe.setVisible(true);
                    
                }
            });
		  }
           

}

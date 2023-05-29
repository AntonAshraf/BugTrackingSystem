package GUI;
import Authentication.Auth;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class UserGUI {
	
  static HomePage home = new HomePage();
	//                            ok               null        -1        ok
  public static void UserPage(String UserType, String name, String id, String email) {
    if (UserType.equals("Project Manager")) {
      projectmanager();
    } else if (UserType.equals("Developer")) {
      developer(email);
    } else if (UserType.equals("Admin")) {
      admin();
    } else if (UserType.equals("Tester")) {
      tester(email);
    }
  }

  public static void projectmanager() {
		    JFrame prowFrame = new JFrame("Project Manager Window");

		    prowFrame.setSize(500, 400);
		    prowFrame.setLocationRelativeTo(null);
		    prowFrame.setVisible(true);
		    prowFrame.setResizable(false);
		    prowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    prowFrame.getContentPane().setLayout(null);
		    
		    JButton btnCheckPerform = new JButton("Check Performance");
		    btnCheckPerform.setBounds(175, 90, 125, 25);
		    prowFrame.add(btnCheckPerform);
		    
		    JButton btnMonitor = new JButton("Monitor Bugs");
		    btnMonitor.setBounds(175, 140, 125, 25);
		    prowFrame.add(btnMonitor);
		    
		    JButton btnBack = new JButton("Back");
		    btnBack.setBounds(175, 190, 125, 25);
		    prowFrame.add(btnBack);
		    
		    btnBack.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	prowFrame.dispose();
		      	  	home.homePage();
		        }
		    });
		  }

  public static void developer(String email) {
    JFrame devwFrame = new JFrame("Developer window");

    devwFrame.setSize(500, 400);
    devwFrame.setLocationRelativeTo(null);
    devwFrame.setVisible(true);
    devwFrame.setResizable(false);
    devwFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    devwFrame.getContentPane().setLayout(null);
    
    JButton btnBack = new JButton("Back");
    btnBack.setBounds(175, 240, 125, 25);
    devwFrame.add(btnBack);
    
    AuthGUI authGUI = new AuthGUI();
    String x = authGUI.getName();
    System.out.println(x);
    
    btnBack.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	devwFrame.dispose();
      	  	home.homePage();
        }
    });
  }

  public static void admin() {
    JFrame adFrame = new JFrame("Admin Window");
    
    adFrame.setSize(500, 400); 
    adFrame.setLocationRelativeTo(null);
    adFrame.setVisible(true);
    adFrame.setResizable(false);
    adFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    adFrame.getContentPane().setLayout(null);
    
    ImageIcon background = new ImageIcon("C:\\Users\\PC\\Desktop\\College\\project oop\\adminbg.png");
    JLabel bgLabel = new JLabel(background);
    bgLabel.setSize(500,400);
    bgLabel.setLocation(0,0);
    adFrame.add(bgLabel);
    
    JButton btnViewBugs = new JButton("View Bugs");
    btnViewBugs.setBounds(175, 135, 125, 25);
    bgLabel.add(btnViewBugs);
    
    JButton btnUpdate = new JButton("Update Users");
    btnUpdate.setBounds(175, 200, 125, 25);
    bgLabel.add(btnUpdate);
    
    JButton btnBack = new JButton("Back");
    btnBack.setBounds(175, 240, 125, 25);
    bgLabel.add(btnBack);
    
    btnBack.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	adFrame.dispose();
      	  	home.homePage();
        }
    });
    
    btnViewBugs.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
		    JFrame frame = new JFrame("Bug Viewer");
		    frame.setSize(500,400);
		    frame.setLocationRelativeTo(null);
		    frame.setResizable(false);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        JTable table = new JTable();
	        JScrollPane scrollPane = new JScrollPane(table);
	        frame.add(scrollPane, BorderLayout.CENTER);

	        Auth.viewdata(table,"Bugs");

	        frame.pack();
	        frame.setVisible(true);
            
        }
    });
  }

  public static void tester(String email) {
	  		String ID = Auth.getIDByName(email, "id", "Testers","email");
	  		
		    JFrame testerFrame = new JFrame("Tester Window");
		    testerFrame.setSize(500, 400);
		    testerFrame.setVisible(true);
		    testerFrame.setLocationRelativeTo(null);
		    testerFrame.setResizable(false);
		    testerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    testerFrame.getContentPane().setLayout(null);

		    ImageIcon background = new ImageIcon("C:\\Users\\PC\\Desktop\\College\\project oop\\testerbg.png");
		    JLabel bgLabel = new JLabel(background);
		    bgLabel.setSize(500,400);
		    bgLabel.setLocation(0,0);
		    testerFrame.add(bgLabel);
		    
		    JButton btnAddBug = new JButton("Add Bug");
		    btnAddBug.setBounds(175, 60, 125, 25);
		    bgLabel.add(btnAddBug);
		    
		    JButton btnViewBugs = new JButton("View Bugs");
		    btnViewBugs.setBounds(175, 110, 125, 25);
		    bgLabel.add(btnViewBugs);
		    
		    btnViewBugs.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
				    JFrame frame = new JFrame("Bug Viewer");
				    frame.setSize(500,400);
				    frame.setLocationRelativeTo(null);
				    frame.setResizable(true);
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        JTable table = new JTable();
			        JScrollPane scrollPane = new JScrollPane(table);
			        frame.add(scrollPane, BorderLayout.CENTER);

			        Auth.viewspecificdata(table,"Bugs","testerid",ID);
                    
			        frame.pack();
			        frame.setVisible(true);
		            
		        }
		    });
		    
		    JButton btnViewDevs = new JButton("View Developers");
		    btnViewDevs.setBounds(175, 210, 125, 25);
		    bgLabel.add(btnViewDevs);
		    
		    btnViewDevs.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
				    JFrame frame = new JFrame("Developer Viewer");
				    frame.setSize(500,400);
				    frame.setLocationRelativeTo(null);
				    frame.setResizable(true);
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        JTable table = new JTable();
			        JScrollPane scrollPane = new JScrollPane(table);
			        frame.add(scrollPane, BorderLayout.CENTER);

			        Auth.viewdata(table,"Developers");

			        frame.pack();
			        frame.setVisible(true);
		            
		        }
		    });
		    
		    JButton btnBack = new JButton("Back");
		    btnBack.setBounds(175, 260, 125, 25);
		    bgLabel.add(btnBack);
		    
		    btnBack.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	testerFrame.dispose();
		      	  	home.homePage();
		        }
		    });
		    
		    JButton btnAssignBug = new JButton("Assign Bug");
		    btnAssignBug.setBounds(175, 160, 125, 25);
		    bgLabel.add(btnAssignBug);
		    
		    btnAssignBug.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
			    		testerFrame.dispose();
		    			JFrame assignFrame = new JFrame("Assign Bug");
			    		assignFrame.setSize(500,400);
			    		assignFrame.setLocationRelativeTo(null);
			    		assignFrame.setResizable(false);
			    		assignFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    		assignFrame.setVisible(true);
			    		assignFrame.getContentPane().setLayout(null);
					    
			    		JButton btnBack = new JButton("Back");
					    btnBack.setBounds(50, 300, 90, 25);
					    assignFrame.getContentPane().add(btnBack);
					    
					    btnBack.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	assignFrame.dispose();
					      	  	tester(email);
					        }
					    });
			    		
			    		JLabel assignBugtxtChooseBug = new JLabel();
			    		assignBugtxtChooseBug.setText("Choose Bug Name:");
			    		assignBugtxtChooseBug.setBounds(25, 10, 133, 20);
					    assignFrame.getContentPane().add(assignBugtxtChooseBug);
			    		
					    List<String> Bugs = Auth.getColumnspecificValues("name", "Bugs","testerid",ID);
					    String Bugsarray[] = new String[Bugs.size()];                
			            for(int j =0;j<Bugs.size();j++){  
			            	Bugsarray[j] = Bugs.get(j);  
			            }  

					    JComboBox BugsCombo = new JComboBox(Bugsarray);
					    BugsCombo.setSelectedIndex(0);
					    BugsCombo.setBounds(25, 35, 200, 20);
					    assignFrame.getContentPane().add(BugsCombo);
					    
					    JLabel assignBugtxtChooseDev = new JLabel();
			    		assignBugtxtChooseDev.setText("Choose Dev Name:");
			    		assignBugtxtChooseDev.setBounds(25, 60, 133, 20);
					    assignFrame.getContentPane().add(assignBugtxtChooseDev);
			    		
					    List<String> Devs = Auth.getColumnValues("name", "Developers");
					    String Devarray[] = new String[Devs.size()];                
			            for(int j =0;j<Devs.size();j++){  
			              Devarray[j] = Devs.get(j);  
			            }  

					    JComboBox DevsCombo = new JComboBox(Devarray);
					    DevsCombo.setSelectedIndex(0);
					    DevsCombo.setBounds(25, 85, 200, 20);
					    assignFrame.getContentPane().add(DevsCombo);
					    
					    JButton btnSubmit = new JButton("Submit");
					    btnSubmit.setBounds(350, 300, 90, 25);
					    assignFrame.getContentPane().add(btnSubmit);
//					    
					    btnSubmit.addActionListener(new ActionListener() {
					        @Override
					        public void actionPerformed(ActionEvent e) {
					          String BugName = (String) BugsCombo.getSelectedItem();
					          String DevName = (String) DevsCombo.getSelectedItem();
					          String DevID = Auth.getIDByName(DevName,"id","Developers","name");
					          
					          Boolean y = Auth.authenticatebugdev(DevID);
					          
					          if(y) {
					        	  Boolean x = Auth.updateDatabug("Bugs", "name", BugName , "developerid", DevID);
						          
						          if(x) {
						        	  assignFrame.dispose();
							      	  tester(email);
						          }else {
						          	  JOptionPane.showMessageDialog(assignFrame, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);
						          }
					          }else {
					        	  JOptionPane.showMessageDialog(assignFrame, "Invalid Developer.","Error!",JOptionPane.WARNING_MESSAGE);
					          }
					          
					        }
					      });
		    		}
		    	}	
		    );
		    
		    btnAddBug.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
					    testerFrame.dispose();
			    		JFrame addFrame = new JFrame("Add Bug");
					    addFrame.setSize(500,400);
					    addFrame.setLocationRelativeTo(null);
					    addFrame.setResizable(false);
					    addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					    addFrame.setVisible(true);
					    addFrame.getContentPane().setLayout(null);
					    
					    JLabel addBugtxtEnterName = new JLabel();
					    addBugtxtEnterName.setText("Enter Bug Name:");
					    addBugtxtEnterName.setBounds(25, 10, 133, 20);
					    addFrame.getContentPane().add(addBugtxtEnterName);
					    
					    JTextField addBugtxtName = new JTextField();
					    addBugtxtName.setBounds(25, 35, 200, 20);
					    addFrame.getContentPane().add(addBugtxtName);
					    addBugtxtName.setColumns(10);
					    
					    JLabel addBugtxtEnterID = new JLabel();
					    addBugtxtEnterID.setText("Enter Bug ID:");
					    addBugtxtEnterID.setBounds(260, 10, 133, 20);
					    addFrame.getContentPane().add(addBugtxtEnterID);
					    
					    JTextField addBugtxtID = new JTextField();
					    addBugtxtID.setBounds(260, 35, 200, 20);
					    addFrame.getContentPane().add(addBugtxtID);
					    addBugtxtID.setColumns(10);
					    
					    JLabel addBugtxtEnterProjectName = new JLabel();
					    addBugtxtEnterProjectName.setText("Enter Project Name:");
					    addBugtxtEnterProjectName.setBounds(260, 60, 133, 20);
					    addFrame.getContentPane().add(addBugtxtEnterProjectName);
					    
					    JTextField addBugtxtProjectName = new JTextField();
					    addBugtxtProjectName.setBounds(260, 85, 200, 20);
					    addFrame.getContentPane().add(addBugtxtProjectName);
					    addBugtxtProjectName.setColumns(10);
					    
					    JLabel addBugtxtEnterStartDate = new JLabel();
					    addBugtxtEnterStartDate.setText("Enter Start Date:");
					    addBugtxtEnterStartDate.setBounds(260, 110, 133, 20);
					    addFrame.getContentPane().add(addBugtxtEnterStartDate);
					    
					    JTextField addBugtxtStartDate = new JTextField();
					    addBugtxtStartDate.setBounds(260, 135, 200, 20);
					    addFrame.getContentPane().add(addBugtxtStartDate);
					    addBugtxtStartDate.setColumns(10);
					    
					    JLabel addBugtxtEnterDeadline = new JLabel();
					    addBugtxtEnterDeadline.setText("Enter Deadline Date:");
					    addBugtxtEnterDeadline.setBounds(260, 160, 133, 20);
					    addFrame.getContentPane().add(addBugtxtEnterDeadline);
					    
					    JTextField addBugtxtDeadline = new JTextField();
					    addBugtxtDeadline.setBounds(260, 185, 200, 20);
					    addFrame.getContentPane().add(addBugtxtDeadline);
					    addBugtxtDeadline.setColumns(10);
					    
					    JLabel addBugtxtEnterType = new JLabel();
					    addBugtxtEnterType.setText("Enter Bug Type:");
					    addBugtxtEnterType.setBounds(25, 60, 133, 20);
					    addFrame.getContentPane().add(addBugtxtEnterType);
					    
					    String[] BugTypes = {"Logic Bug", "Syntax Bug", "Security Bug", "Performance Bug"};

					    JComboBox TypeCombo = new JComboBox(BugTypes);
					    TypeCombo.setSelectedIndex(0);
					    TypeCombo.setBounds(25, 85, 200, 20);
					    addFrame.getContentPane().add(TypeCombo);
					    
					    JLabel addBugtxtEnterPriority = new JLabel();
					    addBugtxtEnterPriority.setText("Enter Bug Priority:");
					    addBugtxtEnterPriority.setBounds(25, 110, 133, 20);
					    addFrame.getContentPane().add(addBugtxtEnterPriority);
					    
					    String[] BugPriorities = {"Low", "Medium", "High"};

					    JComboBox PriorityCombo = new JComboBox(BugPriorities);
					    PriorityCombo.setSelectedIndex(0);
					    PriorityCombo.setBounds(25, 135, 200, 20);
					    addFrame.getContentPane().add(PriorityCombo);
					    
					    JLabel addBugtxtEnterLevel = new JLabel();
					    addBugtxtEnterLevel.setText("Enter Bug Level:");
					    addBugtxtEnterLevel.setBounds(25, 160, 133, 20);
					    addFrame.getContentPane().add(addBugtxtEnterLevel);
					    
					    String[] BugLevels = {"Easy", "Medium", "Hard", "Level El Wa7sh"};

					    JComboBox LevelCombo = new JComboBox(BugLevels);
					    LevelCombo.setSelectedIndex(0);
					    LevelCombo.setBounds(25, 185, 200, 20);
					    addFrame.getContentPane().add(LevelCombo);
					   
					    JButton btnSubmit = new JButton("Submit");
					    btnSubmit.setBounds(350, 300, 90, 25);
					    addFrame.getContentPane().add(btnSubmit);
					    
					    btnSubmit.addActionListener(new ActionListener() {
					        @Override
					        public void actionPerformed(ActionEvent e) {
					          String BugName = addBugtxtName.getText();
					          String BugID = addBugtxtID.getText();
					          String BugType = (String) TypeCombo.getSelectedItem();
					          String BugPriority = (String) PriorityCombo.getSelectedItem();
					          String BugLevel = (String) LevelCombo.getSelectedItem();
					          String ProjectName = addBugtxtProjectName.getText();
					          String StartDate = addBugtxtStartDate.getText();
					          String DeadlineDate = addBugtxtDeadline.getText();
					          
					          Boolean x = Auth.insertDataBug(BugID, BugName, BugType, BugPriority, ProjectName, StartDate, DeadlineDate, BugLevel, ID);
					          
					          if(x) {
					        	  addFrame.dispose();
						      	  tester(email);
					          }else {
					          	  JOptionPane.showMessageDialog(addFrame, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);
					          }
					          
					          addBugtxtName.setText("");
					          addBugtxtID.setText("");
					          addBugtxtProjectName.setText("");
					          addBugtxtStartDate.setText("");
					          addBugtxtDeadline.setText("");
					          
					        }
					      });
					    
					    JButton btnBack = new JButton("Back");
					    btnBack.setBounds(50, 300, 90, 25);
					    addFrame.getContentPane().add(btnBack);
					    
					    btnBack.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	addFrame.dispose();
					      	  	tester(email);
					        }
					    });
			        }
		   		}	
		    );
		  }
}

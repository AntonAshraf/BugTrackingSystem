package GUI;
import Authentication.Auth;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.text.DecimalFormat;

import javax.swing.*;

public class UserGUI {
	
  static HomePage home = new HomePage();
  static AuthGUI auth = new AuthGUI();
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
		    
		    ImageIcon background = new ImageIcon("C:\\Users\\PC\\Desktop\\College\\project oop\\pmbg.png");
		    JLabel bgLabel = new JLabel(background);
		    bgLabel.setSize(500,400);
		    bgLabel.setLocation(0,0);
		    prowFrame.add(bgLabel);
		    
		    JButton btnCheckPerform = new JButton("Check Performance");
		    btnCheckPerform.setBounds(162, 60, 150, 25);
		    bgLabel.add(btnCheckPerform);
		    
		    JButton btnMonitor = new JButton("Monitor Bugs");
		    btnMonitor.setBounds(162, 110, 150, 25);
		    bgLabel.add(btnMonitor);
		    
		    btnMonitor.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
				    JFrame frame = new JFrame("Bug Viewer");
				    frame.setSize(500,400);
				    frame.setLocationRelativeTo(null);
				    frame.setResizable(true);
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        JTable table = new JTable();
			        JScrollPane scrollPane = new JScrollPane(table);
			        frame.add(scrollPane, BorderLayout.CENTER);
			        Auth.viewdata(table,"Bugs");
			        frame.setVisible(true);
		            
		        }
		    });
		    
		    btnCheckPerform.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
				    prowFrame.dispose();
		    		JFrame PerformFrame = new JFrame("pre");
				    PerformFrame.setSize(500,400);
				    PerformFrame.setLocationRelativeTo(null);
				    PerformFrame.setResizable(true);
				    PerformFrame.getContentPane().setLayout(null);
				    PerformFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    PerformFrame.setVisible(true);
		            
				    JLabel updatetxtEnterRole = new JLabel();
				    updatetxtEnterRole.setText("Choose User Role");
				    updatetxtEnterRole.setBounds(187, 80, 133, 20);
				    PerformFrame.getContentPane().add(updatetxtEnterRole);
				    
				    JButton btnTesters = new JButton("Testers");
				    btnTesters.setBounds(150, 110, 175, 25);
				    PerformFrame.getContentPane().add(btnTesters);
				    
				    JButton btnDevs = new JButton("Developers");
				    btnDevs.setBounds(150, 160, 175, 25);
				    PerformFrame.getContentPane().add(btnDevs);
				    
				    JButton btnBack = new JButton("Back");
				    btnBack.setBounds(150, 210, 175, 25);
				    PerformFrame.add(btnBack);
				    
				    btnBack.addActionListener(new ActionListener() {
				        public void actionPerformed(ActionEvent e) {
				        	PerformFrame.dispose();
				      	  	projectmanager();
				        }
				    });
				    
				    btnTesters.addActionListener(new ActionListener() {
				    	public void actionPerformed(ActionEvent e) {
				    		JFrame TesterPerformFrame = new JFrame("Tester Performance");
				    		TesterPerformFrame.setSize(300, 200);
				    		TesterPerformFrame.setLocationRelativeTo(null);
				    		TesterPerformFrame.setVisible(true);
				    		TesterPerformFrame.setResizable(false);
				    		TesterPerformFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    		TesterPerformFrame.getContentPane().setLayout(null);
				    		
				    		JLabel FinishtxtChooseTester = new JLabel();
				    	    FinishtxtChooseTester.setText("Select Tester:");
				    	    FinishtxtChooseTester.setBounds(25, 10, 130, 20);
				    	    TesterPerformFrame.getContentPane().add(FinishtxtChooseTester);
				    	    
				    	    List<String> Testers = Auth.getColumnValues("name", "Testers");
				    	    
				    	    String Testersarray[] = new String[Testers.size()];                
				            for(int j =0;j<Testers.size();j++){  
				            Testersarray[j] = Testers.get(j); 
				          	System.out.println(j);
				            }  

				    	    JComboBox TestersCombo = new JComboBox(Testersarray);
				    	    TestersCombo.setSelectedIndex(0);
				    	    TestersCombo.setBounds(25, 35, 200, 20);
				    	    TesterPerformFrame.getContentPane().add(TestersCombo);
				    	    
				    	    JButton btnSubmit = new JButton("Calculate");
						    btnSubmit.setBounds(95, 115, 90, 25);
						    TesterPerformFrame.getContentPane().add(btnSubmit);
						    
						    btnSubmit.addActionListener(new ActionListener() {
						        @Override
						        public void actionPerformed(ActionEvent e) {
						        	String TesterName = (String) TestersCombo.getSelectedItem();
						        	String ID = Auth.getIDByName(TesterName, "id", "Testers", "name");
						        	List<String> Priorities = Auth.getColumnspecificValues("priority", "Bugs", "testerid", ID);
						        	int allbugcount = Auth.getRowCount("Bugs");
						        	int specificbugcount = Auth.intgetIDByName(TesterName,"numbugs","Testers","name");
						        	double performance = Auth.testper(allbugcount, specificbugcount, Priorities);
						        	System.out.println(performance);
						        	
						        	DecimalFormat decimalFormat = new DecimalFormat("#.##");
						            String formattedperformance = decimalFormat.format(performance);
						        	
				                	JOptionPane.showMessageDialog(TesterPerformFrame, "Performance: " + formattedperformance,"Calculation Successful!",JOptionPane.INFORMATION_MESSAGE);
						        }
						      });
				    	}
				    });
				    
				    btnDevs.addActionListener(new ActionListener() {
				    	public void actionPerformed(ActionEvent e) {
				    		JFrame DevPerformFrame = new JFrame("Developer Performance");
				    		DevPerformFrame.setSize(300, 200);
				    		DevPerformFrame.setLocationRelativeTo(null);
				    		DevPerformFrame.setVisible(true);
				    		DevPerformFrame.setResizable(false);
				    		DevPerformFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    		DevPerformFrame.getContentPane().setLayout(null);
				    		
				    		JLabel FinishtxtChooseTester = new JLabel();
				    	    FinishtxtChooseTester.setText("Select Developer:");
				    	    FinishtxtChooseTester.setBounds(25, 10, 150, 20);
				    	    DevPerformFrame.getContentPane().add(FinishtxtChooseTester);
				    	    
				    	    List<String> Devs = Auth.getColumnValues("name", "Developers");
				    	    
				    	    String Devsarray[] = new String[Devs.size()];                
				            for(int j =0;j<Devs.size();j++){  
				            Devsarray[j] = Devs.get(j); 
				          	System.out.println(j);
				            }  

				    	    JComboBox DevsCombo = new JComboBox(Devsarray);
				    	    DevsCombo.setSelectedIndex(0);
				    	    DevsCombo.setBounds(25, 35, 200, 20);
				    	    DevPerformFrame.getContentPane().add(DevsCombo);
				    	    
				    	    JButton btnSubmit = new JButton("Calculate");
						    btnSubmit.setBounds(95, 115, 90, 25);
						    DevPerformFrame.getContentPane().add(btnSubmit);
						    
						    btnSubmit.addActionListener(new ActionListener() {
						        @Override
						        public void actionPerformed(ActionEvent e) {
						        	String DevName = (String) DevsCombo.getSelectedItem();
						        	String ID = Auth.getIDByName(DevName, "id", "Testers", "name");
						        	List<String> Priorities = Auth.getColumnspecificValues("priority", "Bugs", "developerid", ID);
						        	List<Long> TimeList = Auth.getLongColumnspecificValues("timetaken", "Bugs", "developerid", ID);
						        	int devdonebugs = Auth.intgetIDByName(DevName,"donebugs","Developers","name");
						        	double performance = Auth.devper(devdonebugs, Priorities, TimeList);
						        	System.out.println(performance);
						        	
						        	DecimalFormat decimalFormat = new DecimalFormat("#.##");
						            String formattedperformance = decimalFormat.format(performance);
						        	
						        	JOptionPane.showMessageDialog(DevPerformFrame, "Performance: " + formattedperformance,"Calculation Successful!",JOptionPane.INFORMATION_MESSAGE);
						        }
						      });
				    	}
				    });
		        }
		    });
		    
		    JButton btnViewTesters = new JButton("Monitor Testers");
		    btnViewTesters.setBounds(162, 160, 150, 25);
		    bgLabel.add(btnViewTesters);
		    
		    JButton btnViewDevs = new JButton("Monitor Devs");
		    btnViewDevs.setBounds(162, 210, 150, 25);
		    bgLabel.add(btnViewDevs);
		    
		    btnViewTesters.addActionListener(new ActionListener() {

		        public void actionPerformed(ActionEvent e) {

		        	JFrame frame = new JFrame("Testers Viewer");
				    frame.setSize(500,400);
				    frame.setLocationRelativeTo(null);
				    frame.setResizable(true);
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        JTable table = new JTable();
			        JScrollPane scrollPane = new JScrollPane(table);
			        frame.add(scrollPane, BorderLayout.CENTER);

			        Auth.viewdata(table,"Testers");
			        frame.setVisible(true);

		        }
		    });
		    
		    btnViewDevs.addActionListener(new ActionListener() {

		        public void actionPerformed(ActionEvent e) {

		            JFrame frame = new JFrame("Developers Viewer");
				    frame.setSize(500,400);
				    frame.setLocationRelativeTo(null);
				    frame.setResizable(true);
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        JTable table = new JTable();
			        JScrollPane scrollPane = new JScrollPane(table);
			        frame.add(scrollPane, BorderLayout.CENTER);

			        Auth.viewdata(table,"Developers");
			        frame.setVisible(true);

		        }
		    });
		    
		    JButton btnBack = new JButton("Log Out");
		    btnBack.setBounds(162, 260, 150, 25);
		    bgLabel.add(btnBack);
		    
		    btnBack.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	prowFrame.dispose();
		      	  	home.homePage();
		        }
		    });
		  }

  public static void developer(String email) {
	  
	    String ID = Auth.getIDByName(email, "id", "Developers","email");

	    JFrame devwFrame = new JFrame("Developer window");
	    devwFrame.setSize(500, 400);
	    devwFrame.setLocationRelativeTo(null);
	    devwFrame.setVisible(true);
	    devwFrame.setResizable(false);
	    devwFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    devwFrame.getContentPane().setLayout(null);

	    ImageIcon background = new ImageIcon("C:\\Users\\PC\\Desktop\\College\\project oop\\devbg.png");
	    JLabel bgLabel = new JLabel(background);
	    bgLabel.setSize(500,400);
	    bgLabel.setLocation(0,0);
	    devwFrame.add(bgLabel);

	    JButton btnbugs = new JButton("View Bugs");
	    btnbugs.setBounds(175, 110, 125, 25);
	    bgLabel.add(btnbugs);
	    
	    JButton btnfinishbug = new JButton("Finish Bug");
	    btnfinishbug.setBounds(175, 160, 125, 25);
	    bgLabel.add(btnfinishbug);

	    JButton btnBack = new JButton("Log Out");
	    btnBack.setBounds(175, 210, 125, 25);
	    bgLabel.add(btnBack);
	    

	    btnbugs.addActionListener(new ActionListener() {

	        public void actionPerformed(ActionEvent e) {

	            JFrame frame = new JFrame("View Bugs");
	            frame.setSize(500, 400);
	            frame.setLocationRelativeTo(null);
	            frame.setResizable(false);
	            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	            JTable table = new JTable();
	            JScrollPane scrollPane = new JScrollPane(table);
	            frame.add(scrollPane, BorderLayout.CENTER);

	            Auth.viewspecificdata(table,"Bugs","developerid",ID);
	            
	            frame.setVisible(true);
	        }
	    });

	    btnfinishbug.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFrame bugfinishFrame = new JFrame("Developer window");
	    		bugfinishFrame.setSize(300, 225);
	    		bugfinishFrame.setLocationRelativeTo(null);
	    		bugfinishFrame.setVisible(true);
	    		bugfinishFrame.setResizable(false);
	    		bugfinishFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    		bugfinishFrame.getContentPane().setLayout(null);
	    		
	    		JButton btnvbug = new JButton("Submit");
	    	    btnvbug.setBounds(80, 140, 120, 25);
	    	    bugfinishFrame.getContentPane().add(btnvbug);
	    	    
	    	    JLabel FinishtxtChooseBug = new JLabel();
	    	    FinishtxtChooseBug.setText("Choose Bug to Close:");
	    	    FinishtxtChooseBug.setBounds(25, 10, 130, 20);
	        	bugfinishFrame.getContentPane().add(FinishtxtChooseBug);
	    	    
	    	    List<String> Bugs = Auth.getColumnspecificValues("name", "Bugs","developerid",ID);
	    	    
	    	    String Bugsarray[] = new String[Bugs.size()];                
	            for(int j =0;j<Bugs.size();j++){  
	          	Bugsarray[j] = Bugs.get(j); 
	          	System.out.println(j);
	            }  

	    	    JComboBox BugsCombo = new JComboBox(Bugsarray);
	            BugsCombo.setSelectedIndex(0);
	    	    BugsCombo.setBounds(25, 35, 200, 20);
	    	    bugfinishFrame.getContentPane().add(BugsCombo);
	    	    
	    	    JLabel FinishtxtEnterDate = new JLabel();
	    	    FinishtxtEnterDate.setText("Enter Date of Bug Closing:");
	    	    FinishtxtEnterDate.setBounds(25, 60, 190, 20);
	        	bugfinishFrame.getContentPane().add(FinishtxtEnterDate);
	        	
	        	JTextField FinishtxtDateEntry = new JTextField();
	        	FinishtxtDateEntry.setBounds(25, 85, 200, 20);
			    bugfinishFrame.getContentPane().add(FinishtxtDateEntry);
			    FinishtxtDateEntry.setColumns(10);

	    	    btnvbug.addActionListener(new ActionListener() {

	    	        public void actionPerformed(ActionEvent e) {
	    	        	bugfinishFrame.dispose();
	    	        	String donedate = FinishtxtDateEntry.getText();
	    	        	String bugname = (String) BugsCombo.getSelectedItem();
	    	        	Auth.updateDatabug("Bugs", "name", bugname, "status", "closed"); // change status of bug
	    	        	Auth.increment("Developers","donebugs",ID,"id");  // increment donebug for developer
	    	        	Auth.updateDatabug("Bugs", "name", bugname, "donedate", donedate); //add donedate to the bug 
	    	            String deadline = Auth.getIDByName(bugname,"deadline","Bugs","name");  // get deadline of the bug
	    	            long days = Auth.getDaysBetweenDates(donedate, deadline); // get days between dates using deadline and donedate               
	    	            Auth.updatelongDatabug("Bugs", "name", bugname, "timetaken", days); // update taken time in the bugs table
	    	            
	    	        }
	    	    });
	    	}
	    });

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
    btnViewBugs.setBounds(175, 60, 125, 25);
    bgLabel.add(btnViewBugs);
    
    JButton btnViewTesters = new JButton("View Testers");
    btnViewTesters.setBounds(300, 60, 125, 25);
    bgLabel.add(btnViewTesters);
    
    JButton btnViewDevs = new JButton("View Devs");
    btnViewDevs.setBounds(50, 60, 125, 25);
    bgLabel.add(btnViewDevs);
    
    btnViewTesters.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {

        	JFrame frame = new JFrame("Testers Viewer");
		    frame.setSize(500,400);
		    frame.setLocationRelativeTo(null);
		    frame.setResizable(true);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        JTable table = new JTable();
	        JScrollPane scrollPane = new JScrollPane(table);
	        frame.add(scrollPane, BorderLayout.CENTER);

	        Auth.viewdata(table,"Testers");
	        frame.setVisible(true);

        }
    });
    
    btnViewDevs.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            JFrame frame = new JFrame("Developers Viewer");
		    frame.setSize(500,400);
		    frame.setLocationRelativeTo(null);
		    frame.setResizable(true);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        JTable table = new JTable();
	        JScrollPane scrollPane = new JScrollPane(table);
	        frame.add(scrollPane, BorderLayout.CENTER);

	        Auth.viewdata(table,"Developers");
	        frame.setVisible(true);

        }
    });
    
    JButton btnAdd = new JButton("Add Users");
    btnAdd.setBounds(175, 110, 125, 25);
    bgLabel.add(btnAdd);
    
    btnAdd.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	adFrame.dispose();
        	
        	JFrame SignUpFrame = new JFrame("Add User");

            SignUpFrame.setSize(500, 400);
            SignUpFrame.setLocationRelativeTo(null);
            SignUpFrame.setVisible(true);
            SignUpFrame.setResizable(false);
            SignUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            SignUpFrame.getContentPane().setLayout(null);
            
            	
            JTextField SignUptxtName = new JTextField();
            SignUptxtName.setBounds(25, 35, 200, 20);
            SignUpFrame.getContentPane().add(SignUptxtName);
            SignUptxtName.setColumns(10);

            JTextField SignUptxtId = new JTextField();
            SignUptxtId.setBounds(25, 85, 200, 20);
            SignUpFrame.getContentPane().add(SignUptxtId);
            SignUptxtId.setColumns(10);

            JTextField SignUptxtPassword = new JPasswordField();
            SignUptxtPassword.setBounds(25, 135, 200, 20);
            SignUpFrame.getContentPane().add(SignUptxtPassword);
            SignUptxtPassword.setColumns(10);

            JTextField SignUptxtEmail = new JTextField();
            SignUptxtEmail.setBounds(25, 185, 200, 20);
            SignUpFrame.getContentPane().add(SignUptxtEmail);
            SignUptxtEmail.setColumns(10);

            JButton btnSubmit = new JButton("Add User");
            btnSubmit.setBounds(350, 300, 90, 25);
            SignUpFrame.getContentPane().add(btnSubmit);

            JLabel SignUptxtEnterYourName = new JLabel();
            SignUptxtEnterYourName.setText("Enter your Name:");
            SignUptxtEnterYourName.setBounds(25, 10, 133, 20);
            SignUpFrame.getContentPane().add(SignUptxtEnterYourName);

            JLabel SignUptxtEnterYourId = new JLabel();
            SignUptxtEnterYourId.setText("Enter your ID:");
            SignUptxtEnterYourId.setBounds(25, 60, 133, 20);
            SignUpFrame.getContentPane().add(SignUptxtEnterYourId);

            JLabel SignUptxtEnterYourPassword = new JLabel();
            SignUptxtEnterYourPassword.setText("Enter your Password:");
            SignUptxtEnterYourPassword.setBounds(25, 110, 133, 20);
            SignUpFrame.getContentPane().add(SignUptxtEnterYourPassword);

            JLabel SignUptxtEnterYourEmail = new JLabel();
            SignUptxtEnterYourEmail.setText("Enter your E-mail:");
            SignUptxtEnterYourEmail.setBounds(25, 160, 133, 20);
            SignUpFrame.getContentPane().add(SignUptxtEnterYourEmail);
            
            JLabel SignUptxtEnterYourRole = new JLabel();
            SignUptxtEnterYourRole.setText("Choose your Role:");
            SignUptxtEnterYourRole.setBounds(25, 210, 133, 20);
            SignUpFrame.getContentPane().add(SignUptxtEnterYourRole);
            
            String[] UserOptions = {"Tester", "Developer", "Project Manager", "Admin"};

            JComboBox UserList = new JComboBox(UserOptions);
            UserList.setSelectedIndex(0);
            UserList.setBounds(25, 235, 200, 30);
            SignUpFrame.getContentPane().add(UserList);
            
            

            btnSubmit.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
            	String name = SignUptxtName.getText();
                String id = SignUptxtId.getText();
                String password = SignUptxtPassword.getText();
                String email = SignUptxtEmail.getText();
                String role = (String) UserList.getSelectedItem();
                String Table = "";
                String userType = "";
                
                if(role == "Tester") {
                	Table = "Testers";
                	userType = "Tester";
                }else if(role == "Developer") {
                	Table = "Developers";
                	userType = "Developer";
                }else if(role == "Project Manager") {
                	Table = "ProjectManagers";
                	userType = "Project Manager";
                }else if(role == "Admin") {
                	Table = "Admins";
                	userType = "Admin";
                }

                Boolean x = Auth.insertData(name, id, password, email, Table);
                if (x) {
                  SignUpFrame.dispose();
                  System.out.println("Data inserted successfully!");
                  admin();

                } else {
                	JOptionPane.showMessageDialog(SignUpFrame, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);

                }
                SignUptxtName.setText("");
                SignUptxtId.setText("");
                SignUptxtPassword.setText("");
                SignUptxtEmail.setText("");
              }
            });
            
            JButton btnBack = new JButton("Back");
            btnBack.setBounds(50, 300, 90, 25);
            SignUpFrame.getContentPane().add(btnBack);
            
            btnBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	SignUpFrame.dispose();
              	  	admin();
                }
              });
        }
    });
    
    JButton btnUpdate = new JButton("Update Users");
    btnUpdate.setBounds(175, 160, 125, 25);
    bgLabel.add(btnUpdate);
    
    JButton btnDelete = new JButton("Delete Users");
    btnDelete.setBounds(175, 210, 125, 25);
    bgLabel.add(btnDelete);
    
    btnDelete.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	adFrame.dispose();
        	JFrame DeleteFrame = new JFrame("Delete User");
        	DeleteFrame.setSize(500, 400);
        	DeleteFrame.setLocationRelativeTo(null);
        	DeleteFrame.setVisible(true);
        	DeleteFrame.setResizable(false);
        	DeleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	DeleteFrame.getContentPane().setLayout(null);
        	
        	JLabel updatetxtEnterRole = new JLabel();
		    updatetxtEnterRole.setText("Choose User Role");
		    updatetxtEnterRole.setBounds(183, 10, 133, 20);
		    DeleteFrame.getContentPane().add(updatetxtEnterRole);
		    
		    JButton btnTesters = new JButton("Testers");
		    btnTesters.setBounds(150, 40, 175, 25);
		    DeleteFrame.getContentPane().add(btnTesters);
		    
		    JButton btnDevs = new JButton("Developers");
		    btnDevs.setBounds(150, 90, 175, 25);
		    DeleteFrame.getContentPane().add(btnDevs);
		    
		    JButton btnPMs = new JButton("Project Managers");
		    btnPMs.setBounds(150, 140, 175, 25);
		    DeleteFrame.getContentPane().add(btnPMs);
		    
		    JButton btnAdmins = new JButton("Admins");
		    btnAdmins.setBounds(150, 190, 175, 25);
		    DeleteFrame.getContentPane().add(btnAdmins);
		    
		    JButton btnBack = new JButton("Back");
		    btnBack.setBounds(150, 240, 175, 25);
		    DeleteFrame.getContentPane().add(btnBack);
		    
		    btnTesters.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	JFrame Testersframe = new JFrame("Tester Deleter");
		        	Testersframe.setSize(300,300);
		        	Testersframe.setLocationRelativeTo(null);
		        	Testersframe.setResizable(false);
		        	Testersframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	Testersframe.getContentPane().setLayout(null);
		        	Testersframe.setVisible(true);
		        	
		        	JLabel TestertxtChooseName = new JLabel();
		        	TestertxtChooseName.setText("Choose Tester Name:");
		        	TestertxtChooseName.setBounds(25, 10, 130, 20);
		        	Testersframe.getContentPane().add(TestertxtChooseName);
		    		
				    List<String> Testers = Auth.getColumnValues("name","Testers");
				    String Testersarray[] = new String[Testers.size()];                
		            for(int j =0;j<Testers.size();j++){  
		            	Testersarray[j] = Testers.get(j);  
		            }  

				    JComboBox TestersCombo = new JComboBox(Testersarray);
				    TestersCombo.setSelectedIndex(0);
				    TestersCombo.setBounds(25, 35, 200, 20);
				    Testersframe.getContentPane().add(TestersCombo);
				    
				    JButton btnSubmit = new JButton("Submit");
				    btnSubmit.setBounds(95, 200, 90, 25);
				    Testersframe.getContentPane().add(btnSubmit);
				    
				    btnSubmit.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				        	String TesterName = (String) TestersCombo.getSelectedItem();
				        	
				        	Boolean x = Auth.deleteRow("Testers","name",TesterName);
				        	
				        	if(x) {
				        		Testersframe.dispose();
				        		DeleteFrame.dispose();
				        		admin();
				        	}else {
				        		JOptionPane.showMessageDialog(Testersframe, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);
				        	}
				        	
				        }
				      });
                }
              });
		    
		    btnDevs.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	JFrame Devsframe = new JFrame("Developer Deleter");
		        	Devsframe.setSize(300,300);
		        	Devsframe.setLocationRelativeTo(null);
		        	Devsframe.setResizable(false);
		        	Devsframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	Devsframe.getContentPane().setLayout(null);
		        	Devsframe.setVisible(true);
		        	
		        	JLabel DevtxtChooseName = new JLabel();
		        	DevtxtChooseName.setText("Choose Developer Name:");
		        	DevtxtChooseName.setBounds(25, 10, 200, 20);
		        	Devsframe.getContentPane().add(DevtxtChooseName);
		    		
				    List<String> Devs = Auth.getColumnValues("name","Devs");
				    String Devsarray[] = new String[Devs.size()];                
		            for(int j =0;j<Devs.size();j++){  
		            	Devsarray[j] = Devs.get(j);  
		            }  

				    JComboBox DevsCombo = new JComboBox(Devsarray);
				    DevsCombo.setSelectedIndex(0);
				    DevsCombo.setBounds(25, 35, 200, 20);
				    Devsframe.getContentPane().add(DevsCombo);
				    
				    JButton btnSubmit = new JButton("Submit");
				    btnSubmit.setBounds(95, 200, 90, 25);
				    Devsframe.getContentPane().add(btnSubmit);
				    
				    btnSubmit.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				        	String DevName = (String) DevsCombo.getSelectedItem();
				        	
				        	Boolean x = Auth.deleteRow("Devs","name",DevName);
				        	
				        	if(x) {
				        		Devsframe.dispose();
				        		DeleteFrame.dispose();
				        		admin();
				        	}else {
				        		JOptionPane.showMessageDialog(Devsframe, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);
				        	}
				        	
				        }
				      });
                }
              });
		    
		    btnPMs.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	JFrame PMsframe = new JFrame("Project Manager Deleter");
		        	PMsframe.setSize(300,300);
		        	PMsframe.setLocationRelativeTo(null);
		        	PMsframe.setResizable(false);
		        	PMsframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	PMsframe.getContentPane().setLayout(null);
		        	PMsframe.setVisible(true);
		        	
		        	JLabel PMtxtChooseName = new JLabel();
		        	PMtxtChooseName.setText("Choose Project Manager Name:");
		        	PMtxtChooseName.setBounds(25, 10, 200, 20);
		        	PMsframe.getContentPane().add(PMtxtChooseName);
		    		
				    List<String> PMs = Auth.getColumnValues("name","ProjectManagers");
				    String PMsarray[] = new String[PMs.size()];                
		            for(int j =0;j<PMs.size();j++){  
		            	PMsarray[j] = PMs.get(j);  
		            }  

				    JComboBox PMsCombo = new JComboBox(PMsarray);
				    PMsCombo.setSelectedIndex(0);
				    PMsCombo.setBounds(25, 35, 200, 20);
				    PMsframe.getContentPane().add(PMsCombo);
				    
				    JButton btnSubmit = new JButton("Submit");
				    btnSubmit.setBounds(95, 200, 90, 25);
				    PMsframe.getContentPane().add(btnSubmit);
				    
				    btnSubmit.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				        	String PMName = (String) PMsCombo.getSelectedItem();
				        	
				        	Boolean x = Auth.deleteRow("ProjectManagers","name",PMName);
				        	
				        	if(x) {
				        		PMsframe.dispose();
				        		DeleteFrame.dispose();
				        		admin();
				        	}else {
				        		JOptionPane.showMessageDialog(PMsframe, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);
				        	}
				        	
				        }
				      });
                }
              });
		    
		    btnAdmins.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	JFrame Adminsframe = new JFrame("Admin Deleter");
		        	Adminsframe.setSize(300,300);
		        	Adminsframe.setLocationRelativeTo(null);
		        	Adminsframe.setResizable(false);
		        	Adminsframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	Adminsframe.getContentPane().setLayout(null);
		        	Adminsframe.setVisible(true);
		        	
		        	JLabel AdmintxtChooseName = new JLabel();
		        	AdmintxtChooseName.setText("Choose Admin Name:");
		        	AdmintxtChooseName.setBounds(25, 10, 130, 20);
		        	Adminsframe.getContentPane().add(AdmintxtChooseName);
		    		
				    List<String> Admins = Auth.getColumnValues("name","Admins");
				    String Adminsarray[] = new String[Admins.size()];                
		            for(int j =0;j<Admins.size();j++){  
		            	Adminsarray[j] = Admins.get(j);  
		            }  

				    JComboBox AdminsCombo = new JComboBox(Adminsarray);
				    AdminsCombo.setSelectedIndex(0);
				    AdminsCombo.setBounds(25, 35, 200, 20);
				    Adminsframe.getContentPane().add(AdminsCombo);
				    
				    JButton btnSubmit = new JButton("Submit");
				    btnSubmit.setBounds(95, 200, 90, 25);
				    Adminsframe.getContentPane().add(btnSubmit);
				    
				    btnSubmit.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				        	String AdminName = (String) AdminsCombo.getSelectedItem();
				        	
				        	Boolean x = Auth.deleteRow("Admins","name",AdminName);
				        	
				        	if(x) {
				        		Adminsframe.dispose();
				        		DeleteFrame.dispose();
				        		admin();
				        	}else {
				        		JOptionPane.showMessageDialog(Adminsframe, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);
				        	}
				        	
				        }
				      });
                }
              });
		    
		    btnBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	DeleteFrame.dispose();
              	  	admin();
                }
            });
        }
    });
    
    btnUpdate.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
		    adFrame.dispose();
    		JFrame Updateframe = new JFrame("User Updater");
		    Updateframe.setSize(500,400);
		    Updateframe.setLocationRelativeTo(null);
		    Updateframe.setResizable(false);
		    Updateframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    Updateframe.getContentPane().setLayout(null);
		    Updateframe.setVisible(true);
		    
		    JLabel updatetxtEnterRole = new JLabel();
		    updatetxtEnterRole.setText("Choose User Role");
		    updatetxtEnterRole.setBounds(183, 10, 133, 20);
		    Updateframe.getContentPane().add(updatetxtEnterRole);
		    
		    JButton btnTesters = new JButton("Testers");
		    btnTesters.setBounds(150, 40, 175, 25);
		    Updateframe.getContentPane().add(btnTesters);
		    
		    JButton btnDevs = new JButton("Developers");
		    btnDevs.setBounds(150, 90, 175, 25);
		    Updateframe.getContentPane().add(btnDevs);
		    
		    JButton btnPMs = new JButton("Project Managers");
		    btnPMs.setBounds(150, 140, 175, 25);
		    Updateframe.getContentPane().add(btnPMs);
		    
		    JButton btnAdmins = new JButton("Admins");
		    btnAdmins.setBounds(150, 190, 175, 25);
		    Updateframe.getContentPane().add(btnAdmins);
		    
		    JButton btnBack = new JButton("Back");
		    btnBack.setBounds(150, 240, 175, 25);
		    Updateframe.getContentPane().add(btnBack);
		    
		    btnTesters.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	JFrame Testersframe = new JFrame("Tester Updater");
		        	Testersframe.setSize(300,300);
		        	Testersframe.setLocationRelativeTo(null);
		        	Testersframe.setResizable(false);
		        	Testersframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	Testersframe.getContentPane().setLayout(null);
		        	Testersframe.setVisible(true);
		        	
		        	JLabel TestertxtChooseName = new JLabel();
		        	TestertxtChooseName.setText("Choose Tester Name:");
		        	TestertxtChooseName.setBounds(25, 10, 130, 20);
		        	Testersframe.getContentPane().add(TestertxtChooseName);
		    		
				    List<String> Testers = Auth.getColumnValues("name","Testers");
				    String Testersarray[] = new String[Testers.size()];                
		            for(int j =0;j<Testers.size();j++){  
		            	Testersarray[j] = Testers.get(j);  
		            }  

				    JComboBox TestersCombo = new JComboBox(Testersarray);
				    TestersCombo.setSelectedIndex(0);
				    TestersCombo.setBounds(25, 35, 200, 20);
				    Testersframe.getContentPane().add(TestersCombo);
				    
				    JLabel TestertxtChooseField = new JLabel();
		        	TestertxtChooseField.setText("Choose Tester Field:");
		        	TestertxtChooseField.setBounds(25, 60, 130, 20);
		        	Testersframe.getContentPane().add(TestertxtChooseField);
		    		
				    String Fieldsarray[] = new String[]{"Name","ID","E-Mail","Password"}; 

				    JComboBox FieldsCombo = new JComboBox(Fieldsarray);
				    FieldsCombo.setSelectedIndex(0);
				    FieldsCombo.setBounds(25, 85, 200, 20);
				    Testersframe.getContentPane().add(FieldsCombo);
				    
				    JLabel TestertxtChangeField = new JLabel();
		        	TestertxtChangeField.setText("Change Chosen Field:");
		        	TestertxtChangeField.setBounds(25, 110, 130, 20);
		        	Testersframe.getContentPane().add(TestertxtChangeField);
		        	
		        	JTextField TestertxtFieldEntry = new JTextField();
		        	TestertxtFieldEntry.setBounds(25, 135, 200, 20);
				    Testersframe.getContentPane().add(TestertxtFieldEntry);
				    TestertxtFieldEntry.setColumns(10);
				    
				    JButton btnSubmit = new JButton("Submit");
				    btnSubmit.setBounds(95, 200, 90, 25);
				    Testersframe.getContentPane().add(btnSubmit);
				    
				    btnSubmit.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				        	String TesterName = (String) TestersCombo.getSelectedItem();
				        	String TesterField = (String) FieldsCombo.getSelectedItem();
				        	String FieldChange = TestertxtFieldEntry.getText();
				        	String FieldInput = "";
				        	
				        	if(TesterField == "Name") {
				        		FieldInput = "name";
				        	}else if(TesterField == "ID") {
				        		FieldInput = "id";
				        	}else if(TesterField == "E-Mail") {
				        		FieldInput = "email";
				        	}else if(TesterField == "Password") {
				        		FieldInput = "password";
				        	}
				        	
				        	Boolean x = Auth.updateDatabug("Testers", "name", TesterName, FieldInput, FieldChange);
				        	
				        	if(x) {
				        		Testersframe.dispose();
				        		Updateframe.dispose();
				        		admin();
				        	}else {
				        		JOptionPane.showMessageDialog(Testersframe, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);
				        	}
				        	TestertxtFieldEntry.setText("");
				        }
				      });
		        }
		    });
		    
		    btnDevs.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	JFrame Devsframe = new JFrame("Dev Updater");
		        	Devsframe.setSize(300,300);
		        	Devsframe.setLocationRelativeTo(null);
		        	Devsframe.setResizable(false);
		        	Devsframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	Devsframe.getContentPane().setLayout(null);
		        	Devsframe.setVisible(true);
		        	
		        	JLabel DevtxtChooseName = new JLabel();
		        	DevtxtChooseName.setText("Choose Developer Name:");
		        	DevtxtChooseName.setBounds(25, 10, 200, 20);
		        	Devsframe.getContentPane().add(DevtxtChooseName);
		    		
				    List<String> Devs = Auth.getColumnValues("name","Developers");
				    String Devsarray[] = new String[Devs.size()];                
		            for(int j =0;j<Devs.size();j++){  
		            	Devsarray[j] = Devs.get(j);  
		            }  

				    JComboBox DevsCombo = new JComboBox(Devsarray);
				    DevsCombo.setSelectedIndex(0);
				    DevsCombo.setBounds(25, 35, 200, 20);
				    Devsframe.getContentPane().add(DevsCombo);
				    
				    JLabel DevtxtChooseField = new JLabel();
		        	DevtxtChooseField.setText("Choose Developer Field:");
		        	DevtxtChooseField.setBounds(25, 60, 200, 20);
		        	Devsframe.getContentPane().add(DevtxtChooseField);
		    		
				    String Fieldsarray[] = new String[]{"Name","ID","E-Mail","Password"}; 

				    JComboBox FieldsCombo = new JComboBox(Fieldsarray);
				    FieldsCombo.setSelectedIndex(0);
				    FieldsCombo.setBounds(25, 85, 200, 20);
				    Devsframe.getContentPane().add(FieldsCombo);
				    
				    JLabel DevtxtChangeField = new JLabel();
		        	DevtxtChangeField.setText("Change Chosen Field:");
		        	DevtxtChangeField.setBounds(25, 110, 130, 20);
		        	Devsframe.getContentPane().add(DevtxtChangeField);
		        	
		        	JTextField DevtxtFieldEntry = new JTextField();
		        	DevtxtFieldEntry.setBounds(25, 135, 200, 20);
				    Devsframe.getContentPane().add(DevtxtFieldEntry);
				    DevtxtFieldEntry.setColumns(10);
				    
				    JButton btnSubmit = new JButton("Submit");
				    btnSubmit.setBounds(95, 200, 90, 25);
				    Devsframe.getContentPane().add(btnSubmit);
				    
				    btnSubmit.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				        	String DevName = (String) DevsCombo.getSelectedItem();
				        	String DevField = (String) FieldsCombo.getSelectedItem();
				        	String FieldChange = DevtxtFieldEntry.getText();
				        	String FieldInput = "";
				        	
				        	if(DevField == "Name") {
				        		FieldInput = "name";
				        	}else if(DevField == "ID") {
				        		FieldInput = "id";
				        	}else if(DevField == "E-Mail") {
				        		FieldInput = "email";
				        	}else if(DevField == "Password") {
				        		FieldInput = "password";
				        	}
				        	
				        	Boolean x = Auth.updateDatabug("Developers", "name", DevName, FieldInput, FieldChange);
				        	
				        	if(x) {
				        		Devsframe.dispose();
				        		Updateframe.dispose();
				        		admin();
				        	}else {
				        		JOptionPane.showMessageDialog(Devsframe, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);
				        	}
				        	DevtxtFieldEntry.setText("");
				        }
				      });
		        }
		    });
		    
		    btnPMs.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	JFrame PMsframe = new JFrame("Project Manager Updater");
		        	PMsframe.setSize(300,300);
		        	PMsframe.setLocationRelativeTo(null);
		        	PMsframe.setResizable(false);
		        	PMsframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	PMsframe.getContentPane().setLayout(null);
		        	PMsframe.setVisible(true);
		        	
		        	JLabel PMtxtChooseName = new JLabel();
		        	PMtxtChooseName.setText("Choose Project Manager Name:");
		        	PMtxtChooseName.setBounds(25, 10, 200, 20);
		        	PMsframe.getContentPane().add(PMtxtChooseName);
		    		
				    List<String> PMs = Auth.getColumnValues("name","ProjectManagers");
				    String PMsarray[] = new String[PMs.size()];                
		            for(int j =0;j<PMs.size();j++){  
		            	PMsarray[j] = PMs.get(j);  
		            }  

				    JComboBox PMsCombo = new JComboBox(PMsarray);
				    PMsCombo.setSelectedIndex(0);
				    PMsCombo.setBounds(25, 35, 200, 20);
				    PMsframe.getContentPane().add(PMsCombo);
				    
				    JLabel PMtxtChooseField = new JLabel();
		        	PMtxtChooseField.setText("Choose Project Manager Field:");
		        	PMtxtChooseField.setBounds(25, 60, 200, 20);
		        	PMsframe.getContentPane().add(PMtxtChooseField);
		    		
				    String Fieldsarray[] = new String[]{"Name","ID","E-Mail","Password"}; 

				    JComboBox FieldsCombo = new JComboBox(Fieldsarray);
				    FieldsCombo.setSelectedIndex(0);
				    FieldsCombo.setBounds(25, 85, 200, 20);
				    PMsframe.getContentPane().add(FieldsCombo);
				    
				    JLabel PMtxtChangeField = new JLabel();
		        	PMtxtChangeField.setText("Change Chosen Field:");
		        	PMtxtChangeField.setBounds(25, 110, 130, 20);
		        	PMsframe.getContentPane().add(PMtxtChangeField);
		        	
		        	JTextField PMtxtFieldEntry = new JTextField();
		        	PMtxtFieldEntry.setBounds(25, 135, 200, 20);
				    PMsframe.getContentPane().add(PMtxtFieldEntry);
				    PMtxtFieldEntry.setColumns(10);
				    
				    JButton btnSubmit = new JButton("Submit");
				    btnSubmit.setBounds(95, 200, 90, 25);
				    PMsframe.getContentPane().add(btnSubmit);
				    
				    btnSubmit.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				        	String PMName = (String) PMsCombo.getSelectedItem();
				        	String PMField = (String) FieldsCombo.getSelectedItem();
				        	String FieldChange = PMtxtFieldEntry.getText();
				        	String FieldInput = "";
				        	
				        	if(PMField == "Name") {
				        		FieldInput = "name";
				        	}else if(PMField == "ID") {
				        		FieldInput = "id";
				        	}else if(PMField == "E-Mail") {
				        		FieldInput = "email";
				        	}else if(PMField == "Password") {
				        		FieldInput = "password";
				        	}
				        	
				        	Boolean x = Auth.updateDatabug("ProjectManagers", "name", PMName, FieldInput, FieldChange);
				        	
				        	if(x) {
				        		PMsframe.dispose();
				        		Updateframe.dispose();
				        		admin();
				        	}else {
				        		JOptionPane.showMessageDialog(PMsframe, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);
				        	}
				        	PMtxtFieldEntry.setText("");
				        }
				      });
		        }
		    });
		    
		    btnAdmins.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	JFrame Adminsframe = new JFrame("Admin Updater");
		        	Adminsframe.setSize(300,300);
		        	Adminsframe.setLocationRelativeTo(null);
		        	Adminsframe.setResizable(false);
		        	Adminsframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	Adminsframe.getContentPane().setLayout(null);
		        	Adminsframe.setVisible(true);
		        	
		        	JLabel AdmintxtChooseName = new JLabel();
		        	AdmintxtChooseName.setText("Choose Admin Name:");
		        	AdmintxtChooseName.setBounds(25, 10, 130, 20);
		        	Adminsframe.getContentPane().add(AdmintxtChooseName);
		    		
				    List<String> Admins = Auth.getColumnValues("name","Admins");
				    String Adminsarray[] = new String[Admins.size()];                
		            for(int j =0;j<Admins.size();j++){  
		            	Adminsarray[j] = Admins.get(j);  
		            }  

				    JComboBox AdminsCombo = new JComboBox(Adminsarray);
				    AdminsCombo.setSelectedIndex(0);
				    AdminsCombo.setBounds(25, 35, 200, 20);
				    Adminsframe.getContentPane().add(AdminsCombo);
				    
				    JLabel AdmintxtChooseField = new JLabel();
		        	AdmintxtChooseField.setText("Choose Admin Field:");
		        	AdmintxtChooseField.setBounds(25, 60, 130, 20);
		        	Adminsframe.getContentPane().add(AdmintxtChooseField);
		    		
				    String Fieldsarray[] = new String[]{"Name","ID","E-Mail","Password"}; 

				    JComboBox FieldsCombo = new JComboBox(Fieldsarray);
				    FieldsCombo.setSelectedIndex(0);
				    FieldsCombo.setBounds(25, 85, 200, 20);
				    Adminsframe.getContentPane().add(FieldsCombo);
				    
				    JLabel AdmintxtChangeField = new JLabel();
		        	AdmintxtChangeField.setText("Change Chosen Field:");
		        	AdmintxtChangeField.setBounds(25, 110, 130, 20);
		        	Adminsframe.getContentPane().add(AdmintxtChangeField);
		        	
		        	JTextField AdmintxtFieldEntry = new JTextField();
		        	AdmintxtFieldEntry.setBounds(25, 135, 200, 20);
				    Adminsframe.getContentPane().add(AdmintxtFieldEntry);
				    AdmintxtFieldEntry.setColumns(10);
				    
				    JButton btnSubmit = new JButton("Submit");
				    btnSubmit.setBounds(95, 200, 90, 25);
				    Adminsframe.getContentPane().add(btnSubmit);
				    
				    btnSubmit.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				        	String AdminName = (String) AdminsCombo.getSelectedItem();
				        	String AdminField = (String) FieldsCombo.getSelectedItem();
				        	String FieldChange = AdmintxtFieldEntry.getText();
				        	String FieldInput = "";
				        	
				        	if(AdminField == "Name") {
				        		FieldInput = "name";
				        	}else if(AdminField == "ID") {
				        		FieldInput = "id";
				        	}else if(AdminField == "E-Mail") {
				        		FieldInput = "email";
				        	}else if(AdminField == "Password") {
				        		FieldInput = "password";
				        	}
				        	
				        	Boolean x = Auth.updateDatabug("Admins", "name", AdminName, FieldInput, FieldChange);
				        	
				        	if(x) {
				        		Adminsframe.dispose();
				        		Updateframe.dispose();
				        		admin();
				        	}else {
				        		JOptionPane.showMessageDialog(Adminsframe, "Invalid Data.","Error!",JOptionPane.WARNING_MESSAGE);
				        	}
				        	AdmintxtFieldEntry.setText("");
				        }
				      });
		        }
		    });
		    
		    btnBack.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	Updateframe.dispose();
		      	  	admin();
		        }
		    });
        }

    });
    
    JButton btnBack = new JButton("Log Out");
    btnBack.setBounds(175, 260, 125, 25);
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
		    frame.setResizable(true);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        JTable table = new JTable();
	        JScrollPane scrollPane = new JScrollPane(table);
	        frame.add(scrollPane, BorderLayout.CENTER);

	        Auth.viewdata(table,"Bugs");

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

			        frame.setVisible(true);
		            
		        }
		    });
		    
		    JButton btnViewDevs = new JButton("View Devs");
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

			        frame.setVisible(true);
		            
		        }
		    });
		    
		    JButton btnBack = new JButton("Log Out");
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

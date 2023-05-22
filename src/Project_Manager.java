package system;

import java.util.ArrayList;

public class Project_Manager extends User implements IBugReport{
	
	ArrayList<Developer> developers;
	ArrayList<Tester> testers;
	ArrayList<Bug> bugs;
	
	
	public Project_Manager(int id, String name, String email, String password,ArrayList<Developer> developers, ArrayList<Tester> testers,ArrayList<Bug> bugs) {
		
		super(id, name, email, password);
		this.developers = developers;
		this.testers = testers;
		this.bugs = bugs;

	}

  public void viewBugs()
  {
    for (Bug bug : bugs) {
      System.out.println(bug.getBugStatus());
    }
  }


}

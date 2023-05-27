package system;

import java.util.ArrayList;

public class Tester extends User implements IBugReport{
	
  private ArrayList<Bug> bugs;
	private ArrayList<Developer> developer;
  private int numOfBugsFound;

	
	public Tester(int id, String name, String email, String password,ArrayList<Developer> developer) 
	{
		super(id,name,email,password);
		this.developer = developer;
    numOfBugsFound = 0;
	}

	public void AddBug(Bug bug)
	{
    // TODO: add bug to the list of bugs in database
		numOfBugsFound++;
    //sendEmailToDeveloper(bug);
	}

	public void viewBugs()
  {
    for (Bug bug : bugs) {
      System.out.println(bug.getBugStatus());
    }	
	}
	
	public void AssignBugsToDeveloper(Developer dev, Bug bug){	
		dev.addBug(bug);
	}

}

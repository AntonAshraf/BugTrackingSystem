package system;

import java.util.ArrayList;

public class Tester extends User implements IBugReport{
	
  private ArrayList<Bug> bugs;
  private ArrayList<Developer> developer;
  private int numOfBugsFound;
  private ArrayList<String> listofmesages;
  private  ArrayList<Bug> discoverdbugs;
  

	
	public Tester(int id, String name, String email, String password,ArrayList<Developer> developer) 
	{
		super(id,name,email,password);
		this.developer = developer;
    numOfBugsFound = 0;
	}

	public void AddBug(Bug bug)
	{
    // TODO: add bug to the list of bugs in database
		this.discoverdbugs.add(bug);
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
	
	public void recivedmessages(String message) {
		this.listofmesages.add(message);
		
		
	}

	public int getNumOfBugsFound() {
		return numOfBugsFound;
	}

	public ArrayList<Bug> getDiscoverdbugs() {
		return discoverdbugs;
	}
	public int gettotalnumofbugs() {
		int i =0;
		for(Bug bug:this.bugs) {
			i++;
		}
		return i;
	}
	
	
	
		
		
}



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
	public Project_Manager(int id, String name, String email, String password) {
		
		super(id, name, email, password);
		
	}

  public void viewBugs()
  {
    for (Bug bug : bugs) {
      System.out.println(bug.getBugStatus());
    }
  }
public double devper(Developer dev) {
	
	int[] arr = dev.getdbugsinfo();
	int sum =0;
	for(Bug bug:dev.getAssigned_bugs()) {
		String bugpriority = bug.getPriority();

		if(bugpriority.equals("High")) {
			sum = sum + 3;
		}else if(bugpriority.equals("Medium")) {
			sum = sum + 2;
		}else if(bugpriority.equals("Low")) {
			sum = sum + 1;
		}
	}
	return ((arr[0]*sum)/(arr[1]));
}
public double testvper(Tester t) {
	
	int totalnumofbus = t.gettotalnumofbugs();
	int testerownbugs = t.getNumOfBugsFound();
	int sum =0;
	for(Bug bug:t.getDiscoverdbugs()) {
		String bugpriority = bug.getPriority();

		if(bugpriority.equals("High")) {
			sum +=3;
		}else if(bugpriority.equals("Medium")) {
			sum +=2;
		}else if(bugpriority.equals("Low")) {
			sum +=1;
		}
	}
	return ((testerownbugs*sum)/(totalnumofbus));
}


}

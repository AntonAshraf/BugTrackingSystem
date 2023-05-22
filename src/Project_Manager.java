import java.util.ArrayList;

public class Project_Manager extends User {
	
	ArrayList<Developer> developers;
	ArrayList<Tester> testers;
	ArrayList<Bug> bugs;
	
	
	public Project_Manager(int id, String name, String email, String password,ArrayList<Developer> developers, ArrayList<Tester> testers,ArrayList<Bug> bugs) {
		
		super(id, name, email, password);
		this.developers = developers;
		this.testers = testers;
		this.bugs = bugs;
		
		
	}
	public void monitor_bugs(Bug bug, String status)
	{
		bug.setStatus(status);
		
	}
	public ArrayList<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(ArrayList<Developer> developers) {
		this.developers = developers;
	}
	public ArrayList<Tester> getTesters() {
		return testers;
	}
	public void setTesters(ArrayList<Tester> testers) {
		this.testers = testers;
	}
	public ArrayList<Bug> getBugs() {
		return bugs;
	}
	public void setBugs(ArrayList<Bug> bugs) {
		this.bugs = bugs;
	}
	
	
	

}

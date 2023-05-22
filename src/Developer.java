
import java.util.ArrayList;

public class Developer extends User {
	
	private ArrayList<Bug> Assigned_bugs;
	
	public Developer(int id, String name, String email, String password,ArrayList<Bug> Assigned_bugs)
	
	{
		super(id, name, email, password);
		
		this.Assigned_bugs = Assigned_bugs;
		
		
		
	}
	public ArrayList<Bug> getAssigned_bugs() {
		return Assigned_bugs;
	}
	public void setAssigned_bugs(ArrayList<Bug> assigned_bugs) {
		Assigned_bugs = assigned_bugs;
	}
	public void change_bug_status(Bug bug, String status)
	{
		
		
		bug.setStatus(status);
		
	}
	
	

}

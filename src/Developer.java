package system;

import java.util.ArrayList;

public class Developer extends User {
	
	private ArrayList<Bug> Assigned_bugs;
	private int num_of_closed_bugs;
	private int num_of_reopened_bugs;
	
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
		if (status=="opened" || status=="closed") {
			bug.setStatus(status);
			
			
			String s = bug.getBugStatus();
			if (s == "opened" && status == "closed")
			{
				num_of_closed_bugs++;
				
			}if(s == "closed" && status == "opend") {
				num_of_reopened_bugs++;
				num_of_closed_bugs--;
			}
			
			
		}else {
			System.out.print("Wrong Bug Status");
		}
		
	}
	public double performance(){
		return num_of_closed_bugs - num_of_closed_bugs;
	}
	

}

package system;

import java.util.ArrayList;

public class Tester extends User {
	
	private ArrayList<Bug> bugs; 
	private ArrayList<Developer> developer;
	private ArrayList<Bug> Assigned_bugs;
	private int num_of_Assigned_bugs;
	
	public void Add_bug(Bug bug)
	
	{
		bugs.add(bug);
		
		
	}
	public ArrayList<Bug> get_assigned_bugs()
	{
		return Assigned_bugs;
	}
	public void monitor_bug_status(Bug bug, String status) 
	{ 
		if(status=="opend" || status=="closed") {
		bug.setStatus(status);}
		else {
			System.out.print("wrong status");
		}
		
		
	}
	
	public void Assign_bugs_to_developer(Developer dev, ArrayList<Bug> bugs)
	
	{
		
		dev.setAssigned_bugs(bugs);
		int n = bugs.size();
		num_of_Assigned_bugs+=n;
		
	}
	public Tester(int id, String name, String email, String password,ArrayList<Bug> bugs,ArrayList<Developer> developer,ArrayList<Bug> Assigned_bugs) 
	{
		super(id,name,email,password);
		this.developer = developer;
		this.Assigned_bugs = Assigned_bugs;
		this.bugs = bugs;
		
		
		
	}
	public double performance() {
		return num_of_Assigned_bugs;
	}

	

}

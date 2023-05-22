package system;

import java.util.ArrayList;

public class Tester extends User {
	
	private ArrayList<BUG> bugs; 
	private ArrayList<Developer> developer;
	private ArrayList<BUG> Assigned_bugs;
	
	public BUG Add_bug(Bug bug)
	
	{
		bugs.add(bug);
		
		
	}
	public ArrayList<Bug> get_assigned_bugs()
	{
		return Assigned_bugs;
	}
	public void monitor_bug_status(BUG bug, String status) 
	{ 
		Bug b = bug;
		String s = status;
		b.setStatus(s);
		
		
	}
	public void Assign_bug_to_developer(Developer dev, Bug bug)
	
	{
		Developer d = dev;
		Bug b1 = bug;
		
		d.setAssignedbug(b1);
		
	}
	public void Assign_bugs_to_developer(Developer dev, ArrayList<Bug> bugs)
	
	{
		Developer d1 = dev;
		ArrayList<Bug> bugs = bugs ;
		
		d1.setAssignedbugs(dev,bugs);
		
	}
	public Tester(ArrayList<Bug> bugs,ArrayList<Developer> developer,ArrayList<Bug> Assigned_bugs) 
	{
		super(id, name, email, password);
		
		this.bugs = bugs;
		this.developer = developer;
		this.Assigned_bugs = Assigned_bugs;
		
		
		
	}

	

}

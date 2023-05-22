package system;

import java.util.*;

public class Developer extends User {
	
	private ArrayList<Bug> Assigned_bugs;
	private int num_of_closed_bugs;
	
	public Developer(int id, String name, String email, String password,ArrayList<Bug> Assigned_bugs) {
		super(id, name, email, password);
		this.Assigned_bugs = Assigned_bugs;
	}

	public ArrayList<Bug> getAssigned_bugs() {
		return Assigned_bugs;
	}

	public void changeBugStatus(Bug bug, String status)
	{
    if (status == "closed" && bug.getBugStatus() == "opened"){
      bug.setStatus(status);
      num_of_closed_bugs++;
    } else if  (status == "closed") {
      System.out.println("Bug is already closed");
    }  else {
      System.out.println("Wrong status");
    }
  }

  public void addBug (Bug bug) {
    Assigned_bugs.add(bug);
  }

}

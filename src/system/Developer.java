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
  public void sendemail(Tester t,String new_status ){
	  t.recivedmessages(new_status);
	  
  }
  public int[] getdbugsinfo() {
	  
	  int[] arr = new int[2];
	  int numofassignedbugs =0;
	  int numofsolvedbugs = 0;
	  
	  for(Bug bug:this.Assigned_bugs) {
		  
		  numofassignedbugs++;
		  if(bug.getStatus() == "Closed") {
			  numofsolvedbugs++;
		  }  
	  }
	  arr[0] = numofsolvedbugs;
	  arr[1] = numofassignedbugs;
	  return arr;
  }
  

}

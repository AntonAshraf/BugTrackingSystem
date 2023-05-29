package system;

import java.util.*;

public class Developer extends User {
	
	private ArrayList<Bug> Assigned_bugs;
	private int num_of_closed_bugs;
	
	public Developer(int id, String name, String email, String password,ArrayList<Bug> Assigned_bugs) {
		super(id, name, email, password);
		this.Assigned_bugs = Assigned_bugs;
	}
	public Developer(int id, String name, String email, String password) {
		super(id, name, email, password);
	
	}

	public ArrayList<Bug> getAssigned_bugs() {
		return Assigned_bugs;
	}

	public void changeBugStatus(Bug bug, String status)
	{
    if (status.equals("closed") && bug.getBugStatus().equals("opened")){
      bug.setStatus(status);
      num_of_closed_bugs++;
    } else if  (status.equals("closed")) {
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
		  if(bug.getStatus().equals("Closed")) {
			  numofsolvedbugs++;
		  }  
	  }
	  arr[0] = numofsolvedbugs;
	  arr[1] = numofassignedbugs;
	  return arr;
	  
  }
public void setAssigned_bugs(ArrayList<Bug> assigned_bugs) {
	Assigned_bugs = assigned_bugs;
}
  

}

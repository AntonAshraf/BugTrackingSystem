package system;

import java.util.ArrayList;

public class Admin extends User

{
  private ArrayList<User> users;
  private ArrayList<Bug> Assigned_bugs;

  public Admin(int id, String name, String email, String password, ArrayList<User> users,
      ArrayList<Bug> Assigned_bugs) {

    super(id, name, email, password);
    this.users = users;
    this.Assigned_bugs = Assigned_bugs;
  }

  public ArrayList<User> getUsers() {
    return users;
  }

  public void setUsers(ArrayList<User> users) {
    this.users = users;
  }

  public ArrayList<Bug> getAssigned_bugs() {
    return Assigned_bugs;
  }

  public void setAssigned_bugs(ArrayList<Bug> assigned_bugs) {
    Assigned_bugs = assigned_bugs;
  }

  public void Add_users(User user) {
    users.add(user);
  }

  public void delete_users(User user) {
    users.remove(user);
  }
  public void ADD_user(String name,String email,int id,String role,String password) {
	  String r = role;
	  if (r.equals("Developer")) {
		  Developer dev = new Developer(id,name,email,password);
		  //Add in database
	  }else if (r.equals("Tester")) {
		  Tester t = new Tester(id,name,email,password);
		  //Add in database	  
	  }else if (r.equals("Project_Manager")) {
		  Project_Manager pm = new Project_Manager(id,name,email,password);
		  //Add in database	  
	  
  }
	  
}
}

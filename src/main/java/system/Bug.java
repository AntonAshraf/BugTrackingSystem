package system;

import Authentication.Auth;

public class Bug{
	
	private String bugId;
	private String name;

	public Bug(String name) {
    this.name = name;
    bugId = Auth.getIDByName(name, "bugid", "Bugs", "name");
	}
  public Bug(int bugId) {
    this.bugId = Integer.toString(bugId);
    name = Auth.getIDByName(this.bugId, "name", "Bugs", "bugid");
  }
  public String getID() {
    return bugId;
  }
  public String getName() {
    return name;
  }
  public String getType() {
    return Auth.getIDByName(bugId, "type", "Bugs", "bugid");
  }
  public String getPriority() {
    return Auth.getIDByName(bugId, "priority", "Bugs", "bugid");
  }
  public String getProjectName() {
    return Auth.getIDByName(bugId, "projectname", "Bugs", "bugid");
  }
  public String getStartDate() {
    return Auth.getIDByName(bugId, "startdate", "Bugs", "bugid");
  }  
  public String Deadline() {
    return Auth.getIDByName(bugId, "deadline", "Bugs", "bugid");
  }
  public String getDifficultyLevel() {
    return Auth.getIDByName(bugId, "level", "Bugs", "bugid");
  }
  public String getStatus() {
    return Auth.getIDByName(bugId, "status", "Bugs", "bugid");
  }
  public String getTesterID() {
    return Auth.getIDByName(bugId, "testerid", "Bugs", "bugid");
  }
  public String getDeveloperID() {
    return Auth.getIDByName(bugId, "developerid", "Bugs", "bugid");
  }
  public String getTesterName() {
    return Auth.getIDByName(getTesterID(), "name", "Testers", "bugid");
  }
	public String getDeveloperName (){
    return Auth.getIDByName(getDeveloperID(), "name", "Developers", "bugid");
  }

}

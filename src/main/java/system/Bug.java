package system;

import DB.DataBase;

public class Bug{
	
	private String bugId;
	private String name;

	public Bug(String name) {
    this.name = name;
    bugId = DataBase.getIDByName(name, "bugid", "Bugs", "name");
	}

  public String getID() {
    return bugId;
  }
  public String getName() {
    return name;
  }
  public String getType() {
    return DataBase.getIDByName(bugId, "type", "Bugs", "bugid");
  }
  public String getPriority() {
    return DataBase.getIDByName(bugId, "priority", "Bugs", "bugid");
  }
  public String getProjectName() {
    return DataBase.getIDByName(bugId, "projectname", "Bugs", "bugid");
  }
  public String getStartDate() {
    return DataBase.getIDByName(bugId, "startdate", "Bugs", "bugid");
  }  
  public String Deadline() {
    return DataBase.getIDByName(bugId, "deadline", "Bugs", "bugid");
  }
  public String getDifficultyLevel() {
    return DataBase.getIDByName(bugId, "level", "Bugs", "bugid");
  }
  public String getStatus() {
    return DataBase.getIDByName(bugId, "status", "Bugs", "bugid");
  }
  public String getTesterID() {
    return DataBase.getIDByName(bugId, "testerid", "Bugs", "bugid");
  }
  public String getDeveloperID() {
    return DataBase.getIDByName(bugId, "developerid", "Bugs", "bugid");
  }
  public String getTesterName() {
    return DataBase.getIDByName(getTesterID(), "name", "Testers", "id");
  }
	public String getDeveloperName (){
    return DataBase.getIDByName(getDeveloperID(), "name", "Developers", "id");
  }
  public String getTesterEmail() {
    return DataBase.getIDByName(getTesterID(), "email", "Testers", "id");
  }
  public String getDeveloperEmail() {
    return DataBase.getIDByName(getDeveloperID(), "email", "Developers", "id");
  }
  public String getTesterPassword() {
    return DataBase.getIDByName(getTesterID(), "password", "Testers", "id");
  }

}

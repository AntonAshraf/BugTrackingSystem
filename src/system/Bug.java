package system;


public class Bug{
	
	private int bugId;
	private String name;
	private String type;
	private String priority;
	private String projectName;
	private String date;
	private String status;
	private int testerID;
	private int developerID;
	
//	public int genID() {
//		return 
//	}
	
	public Bug(int bugId, String name, String type, String priority, String projectName,int testerID) {
    // add due date
    // add when it closed
		this.bugId = bugId;
		this.name = name;
		this.type = type;
		this.priority = priority;
		this.projectName = projectName;
		this.date = Date.getCurrentDate();
		this.status = "Opened";
		this.testerID = testerID;
//		this.developerID = null;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDeveloperID(int developerID) {
		this.developerID = developerID;
	}
	

	public String getPriority() {
		return priority;
	}
	public String getBugStatus() {
		return "Bug [bugId=" + bugId + ", name=" + name + ", type=" + type + ", priority=" + priority + ", projectName="
				+ projectName + ", date=" + date + ", status=" + status + ", testerID=" + testerID + ", developerID="
				+ developerID + "]";
	}
	
}

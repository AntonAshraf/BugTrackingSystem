package EmailSender;

import DB.DataBase;
import system.Bug;

public class EmailData {
  public static String getSubject(String Bugname) {
    String BugID = DataBase.getIDByName(Bugname, "bugid", "Bugs", "name");
    return "Bug Report: BugID #" + BugID + " - " + Bugname;
  }

  public static String getSubject() {
    return "Join the chat room to discuss the bug";
  }

  public static String getbody(String devName, String BugName) {
    Bug bug = new Bug(BugName);
    String BugID = bug.getID();
    String BugType = bug.getType();
    String BugDifficultyLevel = bug.getDifficultyLevel();
    String BugPriority = bug.getPriority();
    String BugProjectName = bug.getProjectName();
    String BugStartDate = bug.getStartDate();
    String BugDueDate = bug.Deadline();
    String TesterName = bug.getTesterName();

    return "Dear " + devName + ",\n\n" +

        "I hope this email finds you well. " +
        "I am writing to inform you about a bug that I have encountered during my testing phase.\n\n" +

        "I have come across a bug with the provided BugID " + BugID + " in the " + BugProjectName + " project. " +
        "This bug is categorized as a " + BugType + " type, indicating the nature of the issue encountered." +
        " Additionally, it has been assigned a difficulty level of " + BugDifficultyLevel + ", " +
        "which reflects the complexity or effort required to resolve the bug.\n\n" +

        "Considering the priority of this bug, it requires your immediate attention and prompt action. " +
        "Its impact on the project and the user experience warrants careful investigation and resolution.\n\n" +

        "Providing detailed information about the bug will assist you in understanding the issue thoroughly and taking appropriate steps to address it. "
        +
        "I have included the necessary details below to facilitate a comprehensive understanding of the bug:\n\n" +
        "Bug Name: " + BugName + "\n" +
        "Priority: " + BugPriority + "\n" +
        "Start Date: " + BugStartDate + "\n" +
        "Due Date: " + BugDueDate + "\n\n" +

        "By reviewing and addressing this bug in a timely manner, we can ensure the overall quality and stability of the project. "
        +
        "Should you require any additional information or clarifications, please do not hesitate to reach out to me.\n\n"
        +

        "Thank you for your attention to this matter.\n\n" +
        "Best regards,\n" +
        TesterName;
  }

  public static String getbody(String devName, String ip, String port, String email) {
  String testerName = DataBase.getIDByName(email, "name", "Testers", "email");
	return "Dear "+ devName +",\n\n"
  + "You are invited to join the chat room for direct communication with the "+ testerName +". "
  + "Please open the Bug Tracking system app and use the following details to easily join the chat room:\n\n"
  + "IP Address: " + ip + "\n"
  + "Port Number: " + port + "\n\n"
  + "Thank you,\n"
  + testerName;

  }
}

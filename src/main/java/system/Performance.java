package system;

import java.util.List;

public class Performance {

  public static double Tester(int numofallbugs, int numtesterbugs, List<String> bugpriorityList) {
    int sum = 0;
    for (String bugpriority : bugpriorityList) {
        if (bugpriority.equals("High")) {
            sum += 3;
        } else if (bugpriority.equals("Medium")) {
            sum += 2;
        } else if (bugpriority.equals("Low")) {
            sum += 1;
        }
    }
    System.out.println("sum: " + sum + " numtesterbugs: " + numtesterbugs +" numofallbugs: " + numofallbugs);
    return (numtesterbugs * sum) / (double) numofallbugs;
}

public static double Developer(int numdevbugs, List<String> bugpriorityList, List<String> levels, List<Long> timeList) {
    int sum = 0;          // Initialize the sum variable to 0
    int timescore = 0;    // Initialize the timescore variable to 0

    // Iterate over each bug's priority and time taken
    for (int i = 0; i < bugpriorityList.size(); i++) {
        String bugpriority = bugpriorityList.get(i); // Get the priority of the current bug
        long time = timeList.get(i);                 // Get the time taken for the current bug
        
        if (time >= 0) {
            timescore += 3;    // If time is greater than 0, increment timescore by 3
        } else {
            timescore += 1;    // Otherwise, increment timescore by 1
        }
        
        // Calculate the sum based on the bug priority
        if (bugpriority.equals("High")) {
            sum += 3;       // If bugpriority is "High", increment sum by 3
        } else if (bugpriority.equals("Medium")) {
            sum += 2;       // If bugpriority is "Medium", increment sum by 2
        } else if (bugpriority.equals("Low")) {
            sum += 1;       // If bugpriority is "Low", increment sum by 1
        }
        if (levels.get(i).equals("Hard")) {
            sum += 3;       // If bugpriority is "High", increment sum by 3
        } else if (levels.get(i).equals("Medium")) {
            sum += 2;       // If bugpriority is "Medium", increment sum by 2
        } else if (levels.get(i).equals("Easy")) {
            sum += 1;       // If bugpriority is "Low", increment sum by 1
        } else if (levels.get(i).equals("Level El Wa7sh")) {
            sum += 10;       // If bugpriority is "Low", increment sum by 1
        }
    }
    System.out.println("sum: " + sum + " numdevbugs: " + numdevbugs +" timescore: " + timescore);
    return numdevbugs * sum * timescore * 0.01;    // Return the calculated performance score
}



}

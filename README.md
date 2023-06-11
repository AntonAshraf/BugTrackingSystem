# Bug Tracking System
## Description 🗒️
The Bug Tracking System project is a comprehensive software application developed in Java that enables efficient tracking and management of bugs in software development. It leverages object-oriented programming principles to create a robust and scalable bug tracking solution. By utilizing the features and technologies mentioned earlier, it offers a wide range of capabilities for bug monitoring, assignment, and reporting.

The system allows developers to track the status of bugs, including their severity, priority, and assigned developer. It facilitates seamless bug assignment to the appropriate developers, ensuring effective bug management and resolution. The progress of bug fixes can be easily monitored, providing real-time insights into the status of each bug.

## Technologies & Features ⚒️
The system's GUI, developed using Java Swing, provides a user-friendly interface for interacting with the bug tracking functionalities. It integrates an online shared MySQL storage as the database backend, ensuring reliable and secure data storage and retrieval.

In addition to bug tracking capabilities, the project also includes an authentication system that validates email addresses and ensures data integrity in the database. This adds an extra layer of security and prevents redundant or invalid data from being stored.

Furthermore to the mentioned functionalities, the project is structured as a Maven project. Maven is a powerful build automation tool for Java projects that helps manage dependencies, build processes, and project configuration. By utilizing Maven, the project benefits from simplified dependency management, consistent build processes, and improved project structure.

With Maven, the project can easily manage and resolve external libraries and dependencies required by the Java Swing GUI and the MySQL database integration. Maven's dependency management simplifies the process of adding, updating, and resolving library dependencies, ensuring that the project has all the necessary components for successful compilation and execution.

![Page Flow](https://github.com/AntonAshraf/BugTrackingSystem/blob/main/src/main/resources/Documentations/Page%20Flow.png)
###### Complete page flow for the application

## Users 
The Bug Tracking System project accommodates multiple user roles, including testers, developers, project managers, and admins. Each role is equipped with specific functionalities tailored to their responsibilities and permissions. 

### Tester 🕵️
  - Define bugs with detailed information, including bug name, ID, type, priority, level of difficulty, project name, start date, and due date.
  - View all bugs defiend by them.
  - Interact with developers, assign bugs to specific developers.
  - Attach images to bug reports within the specified size limit (5MB).
  - Send email notifications to assigned developers with comprehensive bug details.
  - Host chat rooms for direct communication with developers.


![Tester View](https://github.com/AntonAshraf/BugTrackingSystem/blob/main/src/main/resources/Videos/Tester.gif)
  ###### Tester View & Authentication pages

### Developer 🧑‍💻
  - View all bugs assigned to them.
  - Update the status of assigned bugs as they progress in resolving them.
  - Participate in chat rooms by entering the required IP address and port number for direct communication with testers.
  - Search for relevant information and access useful links related to bug fixing.

![Developer View](https://github.com/AntonAshraf/BugTrackingSystem/blob/main/src/main/resources/Videos/Developer.gif)
  ###### Developer View


### Project Manager 🤵
  - Have a comprehensive view of testers, developers, and bugs in the system.
  - Calculate performance metrics for testers and developers based on parameters like the number of issued and solved bugs, difficulty, and bug level.
  - Generate reports on bug status, performance metrics, and other relevant data.

![Project Manager View](https://github.com/AntonAshraf/BugTrackingSystem/blob/main/src/main/resources/Videos/Project%20Manager.gif)
  ###### Project Manager View 

### Admin 🦸
  - View, add, update, and delete user accounts.
  - Have elevated privileges and complete control over user management in the system.

![Admin View](https://github.com/AntonAshraf/BugTrackingSystem/blob/main/src/main/resources/Videos/Admin.gif)
  ###### Admin View

##  Conclusion 🔚
By combining these features and technologies, the Bug Tracking System project offers a robust, user-friendly, and efficient solution for bug tracking and management. It enhances software quality, productivity, and communication among stakeholders, making it an ideal choice for an object-oriented programming course project.

You can try the application now from [here](https://bit.ly/BugTrackingSystemApplication) after downloading [Java](https://www.oracle.com/eg/java/technologies/downloads/#jdk20-windows)!!

---
### Collaborators 🤝

- [Ismail Fakhr](https://github.com/Ismailfakhr)
- [Alaa Imam](https://github.com/AlaaImam)
- [Ahmed Kamal](https://github.com/AhmadKamal0)
- [Mahmoud Hany](https://github.com/MahmoudHanyFathalla)
- [Anton Ashraf](https://github.com/AntonAshraf)

CREATE DATABASE IF NOT EXISTS sql7621761; 
----------------------------------------------
USE sql7621761; -- Switch to your database

CREATE TABLE IF NOT EXISTS Developers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    donebugs INT NOT NULL
);

-----------------------------------------------

USE sql7621761;

CREATE TABLE IF NOT EXISTS Testers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
    numbugs INT NOT NULL,
);
-----------------------------------------------

USE sql7621761;

CREATE TABLE IF NOT EXISTS ProjectMangers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL

);

-------------------------------------------------
USE sql7621761;

CREATE TABLE IF NOT EXISTS Admins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

----------------------------------------------------
USE sql7621761;

CREATE TABLE IF NOT EXISTS Bugs (
    bugid INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    priority VARCHAR(255) NOT NULL,
    projectname VARCHAR(255) NOT NULL,
    testerid INT,
    developerid INT,
    startdate VARCHAR(255) NOT NULL,
    deadline VARCHAR(255) NOT NULL,
    donedate VARCHAR(255) NOT NULL,
    FOREIGN KEY (testerid) REFERENCES tester(id),
    FOREIGN KEY (developerid) REFERENCES developer(id)
    timetaken long NOT NULL,
);

---------------------------------------------------
-- Extra Commands
USE sql7621761;

INSERT INTO Bugs (name, type, priority, projectname, testerid, developerid, startdate, deadline, donedate)
VALUES ('Bug 1', 'Functional', 'High', 'Project A', 1, 1, '2023-05-01', '2023-05-10', '2023-05-09'),
       ('Bug 2', 'Performance', 'Medium', 'Project B', 2, 2, '2023-05-05', '2023-05-15', '2023-05-14'),
       ('Bug 3', 'UI', 'Low', 'Project C', 3, 3, '2023-05-10', '2023-05-20', '2023-05-18');

---------------------------------------------------
USE sql7621761;

UPDATE Testers
SET numbugs = 3
WHERE id = 1;

---------------------------------------------------
-- For the sake of the example, we will rename the ProjectManager table to ProjectManagers
USE sql7621761;

RENAME TABLE ProjectManager TO ProjectManagers;

---------------------------------------------------
-- To Add coulmn to a table
USE sql7621761;

ALTER TABLE Developers
ADD donebugs INT;

---------------------------------------------------
              -- Extra Commands --

-- RENAME TABLE ProjectManager TO ProjectManagers;
-- SHOW TABLES;
-- Select deadline   from Bugs
-- DELETE FROM Bugs WHERE bugid = 333
-- DELETE FROM Bugs WHERE bugid = 1100
-- ALTER TABLE Bugs
-- ADD timetaken INT;
-- select priority from Bugs  where developerid = 1
-- select * from Bugs

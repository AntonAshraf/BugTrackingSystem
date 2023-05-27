CREATE DATABASE IF NOT EXISTS oopdata; 
----------------------------------------------
USE oopdata; -- Switch to your database

CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-----------------------------------------------

USE oopdata;

CREATE TABLE IF NOT EXISTS tester (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
-----------------------------------------------

USE oopdata;

CREATE TABLE IF NOT EXISTS projectma (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-------------------------------------------------

USE oopdata;

INSERT INTO projectma (id, name, email, password)
VALUES (1, 'mahmoud', 'mahmoudhanyfathalla@gmail.com', 'tmsa7'),
       (2, 'alaa', 'alaaadel@gmail.com', '3alolo'),
       (3, 'ismail', 'isamilfakhr@gmail.com', 'som3a');
      
---------------------------------------------------
USE oopdata;

CREATE TABLE IF NOT EXISTS admindata (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
----------------------------------------------------

USE oopdata;

SELECT * FROM projectma
---------------------------------------------------


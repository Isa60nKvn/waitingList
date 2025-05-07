# MyJDBC - Simple Java MySQL CLI App

This project is a basic command-line application built with Java that demonstrates how to interact with a MySQL database using JDBC (Java Database Connectivity). It allows inserting user data (name and student ID) into a database and displaying the most recently added user. Ideal for those learning JDBC, SQL, and Java database interaction.

## Features

- Connects to a MySQL database using JDBC
- Inserts new users (name and student ID) into the `users` table
- Displays the last inserted user
- Automatically clears the table when the program starts
- CLI-based input loop for continuous user entry

## Technologies Used

- Java
- JDBC
- MySQL
- IntelliJ Terminal

---

## Setup Instructions

### 1. Database Setup

Make sure you have MySQL installed and running. Then, create a schema and table with the following SQL:

```sql
CREATE DATABASE login_schema;

USE login_schema;

CREATE TABLE users (
  waitingNumber INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  studentID VARCHAR(50)
);

---

## 2. Output Example

Name    : Alice
StudentID: 20231234
User inserted successfully.
---- Name & Waiting Number ----
Wait Number: 1
Name       : Alice
StudentID  : 20231234
-------------------------------
Add another name? (1 = yes, 0 = no):

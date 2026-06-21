# Employee Management System (Java)

## Overview

Employee Management System is a console-based Java application developed using Core Java concepts. The application allows users to manage employee records through CRUD (Create, Read, Update, Delete) operations while storing data permanently in a text file.

This project was built to strengthen understanding of Object-Oriented Programming (OOP), Collections Framework, File Handling, Exception Handling, and Java fundamentals through practical implementation.

---

## Features

### Employee Management

* Add new employees
* View all employees
* Search employees by:

  * Employee ID
  * Employee Name
* Update employee salary
* Delete employee records (In Progress)

### Data Persistence

* Employee records are stored in a text file (`Employees.txt`)
* Data is automatically loaded when the application starts
* No need to re-enter employee details after restarting the program

### Validation

* Exception handling for invalid inputs
* Employee search validation
* File existence checking

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList (Collections Framework)
* File Handling

  * FileReader
  * FileWriter
  * BufferedReader
* Exception Handling
* Switch Case Menu System

---

## Project Structure

```text
Employee Management System
│
├── Main.java
├── Employee.java
├── Employees.txt
│
├── Add Employee
├── View Employee
├── Search Employee
├── Update Employee
├── Delete Employee (Planned)
│
└── File Storage System
```

---

## Concepts Implemented

### Core Java

* Classes and Objects
* Constructors
* Encapsulation
* Getters and Setters
* Loops
* Conditional Statements
* Switch Statements

### Collections Framework

* ArrayList

### File Handling

* Reading data from a file
* Writing data to a file
* Loading existing employee records

### Exception Handling

* try-catch blocks
* Input validation
* File handling exceptions

---

## Sample Menu

```text
MENU

1. Add Employee
2. View Employee
3. Search Employee
4. Update Salary
5. Delete Employee
6. Exit
```

---

## Future Improvements

* Delete Employee functionality
* Duplicate Employee ID validation
* Employee sorting by salary and name
* HashMap implementation for faster searching
* JDBC integration
* MySQL database support
* Spring Boot REST API version
* GUI version using JavaFX

---

## Learning Outcomes

This project helped me gain practical experience with:

* Object-Oriented Programming
* Collections Framework
* File Handling
* CRUD Operations
* Data Persistence
* Exception Handling
* Menu-Driven Application Development

---

## Author

Aman

Java Backend Developer| Building Real-World Projects

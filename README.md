 Bank Transaction Management System (Spring Boot + JDBC)

Project Overview

This project implements a Bank Transaction System using Spring Boot and MySQL to demonstrate transaction management (commit & rollback) in Java.

The system allows users to:

- Create bank accounts
- Check account balance
- Transfer money between accounts

---

Objective

To understand how transactions work in real-world applications:

- Commit → when all operations succeed
- Rollback → when any error occurs

---

Technologies Used

- Java
- Spring Boot
- Spring JDBC ("JdbcTemplate")
- MySQL
- Postman (for API testing)

---

Project Structure

com.example.bank
│
├── controller       → Handles API requests
├── service          → Business logic + transaction
├── repository       → Database interaction (SQL)
├── model            → Account class
└── BankApplication  → Main class

---

Database Setup

Step 1: Create Database

CREATE DATABASE bank_db;
USE bank_db;

Step 2: Create Table

CREATE TABLE account (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    balance DOUBLE
);

---

Application Configuration

Update "application.properties":

spring.datasource.url=jdbc:mysql://localhost:3306/bank_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

---

 How to Run the Project

1. Open project in Eclipse
2. Right-click → Run As → Spring Boot App
3. Check console:

Tomcat started on port 8080

---

API Endpoints

1 Create Account

POST "/bank/create"

Body:

{
  "name": "User1",
  "balance": 10000
}

---

 2 Get Account Details

GET "/bank/{id}"

Example:

http://localhost:8080/bank/1

---

Conclusion

This project demonstrates how Spring Boot manages transactions efficiently using "@Transactional". It ensures data integrity and reliability in financial operations like money transfer.


# 🧩 JDBC CRUD Application (PostgreSQL + Java)

This project demonstrates how to perform basic **CRUD (Create, Read, Update, Delete)** operations in Java using **JDBC (Java Database Connectivity)** with **PostgreSQL**.  
It also includes an optional **Swing-based GUI** for managing student records.

---

## 🚀 Features
✅ Connects to a PostgreSQL database using JDBC  
✅ Performs full CRUD operations  
✅ Uses **PreparedStatement** for secure SQL execution  
✅ Reads database credentials from an external `config.properties` file  
✅ Includes a simple **Swing UI** for interactive use  
✅ Handles exceptions gracefully  

---

## 🛠️ Technologies Used
- **Java 17+**
- **JDBC**
- **PostgreSQL**
- **Swing (optional GUI)**
- **IntelliJ IDEA**

---

## ⚙️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>

2. Create a PostgreSQL Database

Open your PostgreSQL terminal or pgAdmin and run:

CREATE DATABASE students;
\c students

CREATE TABLE student (
  sid INT PRIMARY KEY,
  sname VARCHAR(50),
  smarks INT
);

3. Create a Configuration File

In your project root, create a file named config.properties
(Do not push it to GitHub! It’s already ignored in .gitignore)

db.url=jdbc:postgresql://localhost:5432/students
db.username=postgres
db.password=yourpassword

4. Run the Project (Console Version)

You can directly run:

javac src/Main.java
java -cp .;postgresql-<version>.jar src/Main


Or inside IntelliJ IDEA:

Open project

Add PostgreSQL JDBC driver to classpath

Run Main.java

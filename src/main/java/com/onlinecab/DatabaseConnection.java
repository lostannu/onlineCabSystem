package main.java.com.onlinecab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/online_cab_system";  // Replace with your DB name
    private static final String USER = "root";  // Replace with your MySQL username
    private static final String PASSWORD = "1234";  // Replace with your MySQL password

    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Return the connection object
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Database connection failed: " + e.getMessage());
        }
    }
}

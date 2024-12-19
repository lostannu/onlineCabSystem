package main.java.com.onlinecab;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseConnection {

    public static void main(String[] args) {
        // Attempt to establish the database connection
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null && conn.isValid(2)) {  // Check if the connection is valid
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to establish a valid connection.");
            }
        } catch (SQLException e) {
            System.err.println("Error during database connection: " + e.getMessage());
            e.printStackTrace();  // Print stack trace for debugging purposes
        }
    }
}

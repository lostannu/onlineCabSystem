package main.java.com.onlinecab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnection {
    // Database connection details (loaded from a properties file)
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    private static Connection connection = null;

    static {
        try {
            // Load database configuration from properties file
            InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties");
            if (input == null) {
                throw new RuntimeException("Unable to find database.properties");
            }

            Properties properties = new Properties();
            properties.load(input);

            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");

            // Load the JDBC Driver
            Class.forName(properties.getProperty("db.driver"));

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database connection: " + e.getMessage());
        }
    }

    // Method to establish or retrieve the existing connection
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new SQLException("Error establishing database connection: " + e.getMessage());
            }
        }
        return connection;
    }

    // Method to close the database connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to close database connection: " + e.getMessage());
        }
    }
}

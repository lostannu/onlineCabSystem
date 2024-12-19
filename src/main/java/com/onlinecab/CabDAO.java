package main.java.com.onlinecab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CabDAO {

    private static final String INSERT_CAB_SQL = "INSERT INTO Cabs (cab_id, driver_name, license_plate, availability) VALUES (?, ?, ?, ?)";
    private static final String SELECT_AVAILABLE_CABS_SQL = "SELECT * FROM Cabs WHERE availability = TRUE";
    private static final String UPDATE_CAB_AVAILABILITY_SQL = "UPDATE Cabs SET availability = ? WHERE cab_id = ?";
    private static final String DELETE_CAB_SQL = "DELETE FROM Cabs WHERE cab_id = ?";

    // Insert a new cab into the database
    public boolean addNewCab(int cabId, String driverName, String licensePlate, boolean availability) throws IllegalArgumentException {
        validateCabInput(cabId, driverName, licensePlate); // Input validation
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_CAB_SQL)) {

            preparedStatement.setInt(1, cabId);
            preparedStatement.setString(2, driverName);
            preparedStatement.setString(3, licensePlate);
            preparedStatement.setBoolean(4, availability);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("A new cab was inserted successfully!");
                return true;
            } else {
                System.err.println("Failed to insert the new cab. No rows affected.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // List all available cabs
    public void listAvailableCabs() {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_AVAILABLE_CABS_SQL)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean hasResults = false;

            while (resultSet.next()) {
                hasResults = true;
                int cabId = resultSet.getInt("cab_id");
                String driverName = resultSet.getString("driver_name");
                String licensePlate = resultSet.getString("license_plate");
                boolean availability = resultSet.getBoolean("availability");

                System.out.println("Cab ID: " + cabId + ", Driver: " + driverName + ", License Plate: " + licensePlate + ", Available: " + availability);
            }

            if (!hasResults) {
                System.out.println("No available cabs found.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while listing available cabs: " + e.getMessage());
        }
    }

    // Update the availability of a cab
    public boolean updateCabAvailability(int cabId, boolean availability) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_CAB_AVAILABILITY_SQL)) {

            preparedStatement.setBoolean(1, availability);
            preparedStatement.setInt(2, cabId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cab availability updated successfully!");
                return true;
            } else {
                System.err.println("No cab found with ID: " + cabId);
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while updating cab availability: " + e.getMessage());
            return false;
        }
    }

    // Delete a cab record from the database
    public boolean deleteCab(int cabId) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_CAB_SQL)) {

            preparedStatement.setInt(1, cabId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cab record deleted successfully!");
                return true;
            } else {
                System.err.println("No cab found with ID: " + cabId);
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while deleting the cab: " + e.getMessage());
            return false;
        }
    }

    // Private helper method for input validation
    private void validateCabInput(int cabId, String driverName, String licensePlate) {
        if (cabId <= 0) {
            throw new IllegalArgumentException("Cab ID must be a positive integer.");
        }
        if (driverName == null || driverName.trim().isEmpty()) {
            throw new IllegalArgumentException("Driver name cannot be null or empty.");
        }
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            throw new IllegalArgumentException("License plate cannot be null or empty.");
        }
    }
}

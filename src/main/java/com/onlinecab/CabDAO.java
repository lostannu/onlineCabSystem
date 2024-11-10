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
    public void addNewCab(int cabId, String driverName, String licensePlate, boolean availability) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_CAB_SQL)) {
            
            preparedStatement.setInt(1, cabId);
            preparedStatement.setString(2, driverName);
            preparedStatement.setString(3, licensePlate);
            preparedStatement.setBoolean(4, availability);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("A new cab was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // List all available cabs
    public void listAvailableCabs() {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_AVAILABLE_CABS_SQL)) {
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int cabId = resultSet.getInt("cab_id");
                String driverName = resultSet.getString("driver_name");
                String licensePlate = resultSet.getString("license_plate");
                boolean availability = resultSet.getBoolean("availability");

                System.out.println("Cab ID: " + cabId + ", Driver: " + driverName + ", License Plate: " + licensePlate + ", Available: " + availability);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update the availability of a cab
    public void updateCabAvailability(int cabId, boolean availability) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_CAB_AVAILABILITY_SQL)) {
            
            preparedStatement.setBoolean(1, availability);
            preparedStatement.setInt(2, cabId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cab availability updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a cab record from the database
    public void deleteCab(int cabId) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_CAB_SQL)) {
            
            preparedStatement.setInt(1, cabId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cab record deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


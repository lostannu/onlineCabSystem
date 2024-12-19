package main.java.com.onlinecab;

public class TestCRUDOperations {
    public static void main(String[] args) {
        // Initialize the CabDAO object
        CabDAO cabDAO = new CabDAO();

        // Testing the insert operation
        try {
            System.out.println("Testing insert operation...");
            cabDAO.addNewCab(1, "John Doe", "ABC1234", true);  // Example data
        } catch (IllegalArgumentException | SQLException e) {
            System.err.println("Error during insert: " + e.getMessage());
        }

        // Testing the list operation
        try {
            System.out.println("Testing list operation...");
            cabDAO.listAvailableCabs();  // List all available cabs
        } catch (SQLException e) {
            System.err.println("Error during listing cabs: " + e.getMessage());
        }

        // Testing the update operation
        try {
            System.out.println("Testing update operation...");
            cabDAO.updateCabAvailability(1, false);  // Change availability to false
        } catch (SQLException e) {
            System.err.println("Error during update: " + e.getMessage());
        }

        // Testing the delete operation
        try {
            System.out.println("Testing delete operation...");
            cabDAO.deleteCab(1);  // Delete the cab record
        } catch (SQLException e) {
            System.err.println("Error during delete: " + e.getMessage());
        }
    }
}

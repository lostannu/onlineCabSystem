package main.java.com.onlinecab;

public class TestCRUDOperations {
    public static void main(String[] args) {
        // Testing the insert operation
        CabDAO cabDAO = new CabDAO();
        cabDAO.addNewCab(1, "John Doe", "ABC1234", true);  // Example data

        // Testing the list operation
        cabDAO.listAvailableCabs();  // List all available cabs

        // Testing the update operation
        cabDAO.updateCabAvailability(1, false);  // Change availability to false

        // Testing the delete operation
        cabDAO.deleteCab(1);  // Delete the cab record
    }
}

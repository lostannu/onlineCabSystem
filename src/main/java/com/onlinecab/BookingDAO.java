public class BookingDAO {

    public Booking saveBooking(Booking booking) {
        // Simulate saving booking to the database
        return booking; // Just returns the booking object for simplicity
    }

    public List<Booking> findBookingsByUserEmail(String email) {
        // Simulate retrieving bookings for a specific user
        if ("test@example.com".equals(email)) {
            return Arrays.asList(
                new Booking("New York", "Boston", "SUV", "2025-01-15")
            );
        }
        return new ArrayList<>();
    }
}

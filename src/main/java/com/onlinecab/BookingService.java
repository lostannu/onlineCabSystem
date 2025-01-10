public class BookingService {
    private BookingDAO bookingDAO;

    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public Booking bookCab(String email, String pickupLocation, String dropLocation, String cabType, String bookingDate) {
        Booking booking = new Booking(pickupLocation, dropLocation, cabType, bookingDate);
        return bookingDAO.saveBooking(booking);
    }

    public List<Booking> getBookingsByUser(String email) {
        return bookingDAO.findBookingsByUserEmail(email);
    }
}

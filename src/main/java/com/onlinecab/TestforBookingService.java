import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookingServiceTest {

    private BookingService bookingService;
    private BookingDAO bookingDAO;

    @BeforeEach
    void setUp() {
        bookingDAO = mock(BookingDAO.class);
        bookingService = new BookingService(bookingDAO);
    }

    @Test
    void testBookCab() {
        Booking booking = new Booking("New York", "Boston", "SUV", "2025-01-15");

        when(bookingDAO.saveBooking(booking)).thenReturn(booking);

        Booking bookedCab = bookingService.bookCab("test@example.com", "New York", "Boston", "SUV", "2025-01-15");

        assertNotNull(bookedCab);
        assertEquals("SUV", bookedCab.getCabType());
        assertEquals("New York", bookedCab.getPickupLocation());
    }

    @Test
    void testGetBookingsByUser() {
        String email = "test@example.com";
        List<Booking> bookings = List.of(new Booking("New York", "Boston", "SUV", "2025-01-15"));

        when(bookingDAO.findBookingsByUserEmail(email)).thenReturn(bookings);

        List<Booking> userBookings = bookingService.getBookingsByUser(email);

        assertNotNull(userBookings);
        assertFalse(userBookings.isEmpty());
        assertEquals("New York", userBookings.get(0).getPickupLocation());
    }
}

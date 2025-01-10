import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookingDAOTest {

    private BookingDAO bookingDAO;

    @BeforeEach
    void setUp() {
        bookingDAO = mock(BookingDAO.class); // Mock the DAO
    }

    @Test
    void testSaveBooking() {
        Booking booking = new Booking("New York", "Boston", "SUV", "2025-01-15");

        when(bookingDAO.saveBooking(booking)).thenReturn(booking);

        Booking savedBooking = bookingDAO.saveBooking(booking);

        assertNotNull(savedBooking);
        assertEquals("New York", savedBooking.getPickupLocation());
        assertEquals("Boston", savedBooking.getDropLocation());
        assertEquals("SUV", savedBooking.getCabType());
        assertEquals("2025-01-15", savedBooking.getBookingDate());
    }

    @Test
    void testFindBookingsByUserEmail() {
        String email = "test@example.com";
        List<Booking> bookings = List.of(new Booking("New York", "Boston", "SUV", "2025-01-15"));

        when(bookingDAO.findBookingsByUserEmail(email)).thenReturn(bookings);

        List<Booking> foundBookings = bookingDAO.findBookingsByUserEmail(email);

        assertNotNull(foundBookings);
        assertFalse(foundBookings.isEmpty());
        assertEquals("New York", foundBookings.get(0).getPickupLocation());
        assertEquals("SUV", foundBookings.get(0).getCabType());
    }

    @Test
    void testFindBookingsByUserEmailNotFound() {
        when(bookingDAO.findBookingsByUserEmail("nonexistent@example.com")).thenReturn(List.of());

        List<Booking> bookings = bookingDAO.findBookingsByUserEmail("nonexistent@example.com");

        assertNotNull(bookings);
        assertTrue(bookings.isEmpty());
    }
}

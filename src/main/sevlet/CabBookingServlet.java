import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CabBookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pickupLocation = request.getParameter("pickupLocation");
        String dropLocation = request.getParameter("dropLocation");
        String cabType = request.getParameter("cabType");
        String bookingDate = request.getParameter("bookingDate");

        // Save booking details to database (simplified here)
        // Redirect to booking confirmation page
        response.sendRedirect("bookingConfirmation.jsp");
    }
}

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BookingDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve booking details for the logged-in user
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        // Simulate getting booking details (e.g., from a database)
        String bookingDetails = "Pickup Location: XYZ, Drop Location: ABC, Cab Type: Sedan";

        request.setAttribute("bookingDetails", bookingDetails);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookingDetails.jsp");
        dispatcher.forward(request, response);
    }
}

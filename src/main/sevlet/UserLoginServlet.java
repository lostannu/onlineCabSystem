import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate login details (e.g., check against database)
        boolean isValidUser = validateUser(email, password);

        if (isValidUser) {
            // Set user session and redirect to booking page
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("booking.jsp");
        } else {
            // Invalid credentials, redirect to login with an error
            response.sendRedirect("login.jsp?error=invalid");
        }
    }

    private boolean validateUser(String email, String password) {
        // Replace with actual validation (e.g., check against a database)
        return email.equals("test@example.com") && password.equals("password123");
    }
}

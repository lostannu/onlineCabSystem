import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserRegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Perform validation and registration logic (e.g., save to database)
        // For simplicity, just print to console
        System.out.println("User registered: " + name);

        // Redirect to login page after successful registration
        response.sendRedirect("login.jsp");
    }
}

package com.onlinecab.controllers;

import com.onlinecab.models.User;
import com.onlinecab.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        User user = new User(username, email, phone, password);
        boolean isRegistered = userService.registerUser(user);

        if (isRegistered) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}

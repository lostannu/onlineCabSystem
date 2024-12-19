package com.onlinecab.controllers;

import com.onlinecab.services.UserService;
import com.onlinecab.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/profile")
public class UserProfileServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.getUserProfile();
        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}

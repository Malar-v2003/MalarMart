package com.malar.MalarMart.controller;

import com.malar.MalarMart.model.User;
import com.malar.MalarMart.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User user = new User(0, name, email, password, role);

        boolean registered = userService.register(user);

        if (registered) {
            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().println("Registration failed. Please try again.");
        }
    }
}
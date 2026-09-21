package com.malar.MalarMart.controller;

import com.malar.MalarMart.model.User;
import com.malar.MalarMart.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.login(email, password);

        if (user != null) {
            response.getWriter().println("Login successful! Welcome " + user.getName());
        } else {
            response.getWriter().println("Invalid email or password.");
        }
    }
}
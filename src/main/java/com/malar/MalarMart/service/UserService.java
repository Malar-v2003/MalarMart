package com.malar.MalarMart.service;

import com.malar.MalarMart.dao.UserDAO;
import com.malar.MalarMart.model.User;

public class UserService {

    private final UserDAO userDAO = new UserDAO();

    public boolean register(User user) {
        return userDAO.register(user);
    }

    public User login(String email, String password) {
        return userDAO.login(email, password);
    }
}
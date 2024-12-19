package com.onlinecab.services;

import com.onlinecab.models.User;

public class UserService {
    private static User userDatabase = null;

    public boolean registerUser(User user) {
        if (user != null) {
            userDatabase = user;
            return true;
        }
        return false;
    }

    public User getUserProfile() {
        return userDatabase;
    }
}

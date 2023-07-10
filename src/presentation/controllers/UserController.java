package presentation.controllers;


import application.UserService;
import core.User;

import javax.management.relation.Role;
import java.util.List;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void registerUser(String email, String password) {
        userService.registerUser(email, password);
    }

    public void updateUserRole(String email, Role newRole) {
        userService.updateUserRole(email, newRole);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    // Other methods related to user management...
}


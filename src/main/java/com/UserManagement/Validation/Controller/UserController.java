package com.UserManagement.Validation.Controller;

import com.UserManagement.Validation.Model.User;
import com.UserManagement.Validation.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return null;
        }
        return user;
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/updateUserInfo")
    public User updateUserInfo(@Valid @RequestBody User user) {
        User updatedUser = userService.updateUserInfo(user);
        if (updatedUser == null) {
            return null;
        }
        return updatedUser;
    }

    @DeleteMapping("/deleteUser/{userId}")
    public boolean deleteUser(@PathVariable("userId") Long userId) {
        return userService.deleteUser(userId);
    }
}

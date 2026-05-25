package com.example.demo.Controller;


//package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.UserService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // URL: POST /api/users
    // Add a new user
    @PostMapping
    public String addUser(@RequestBody Map<String, String> user) {
        userService.addUser(user);
        return "User added successfully!";
    }

    // URL: GET /api/users
    // Get all users
    @GetMapping
    public List<Map<String, String>> getAllUsers() {
        return userService.getAllUsers();
    }

    // URL: GET /api/users/{id}
    // Get a user by ID
    @GetMapping("/{id}")
    public Object getUserById(@PathVariable int id) {
        Map<String, String> user = userService.getUserById(id);
        return (user != null) ? user : "User not found!";
    }

    // URL: PUT /api/users/{id}
    // Update a user by ID
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody Map<String, String> user) {
        if (id >= 0 && id < userService.getUserCount()) {
            userService.updateUser(id, user);
            return "User updated successfully!";
        } else {
            return "User not found!";
        }
    }

    // URL: DELETE /api/users/{id}
    // Delete a user by ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        if (id >= 0 && id < userService.getUserCount()) {
            userService.deleteUser(id);
            return "User deleted successfully!";
        } else {
            return "User not found!";
        }
    }

    // URL: DELETE /api/users
    // Delete all users
    @DeleteMapping
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "All users deleted successfully!";
    }
}

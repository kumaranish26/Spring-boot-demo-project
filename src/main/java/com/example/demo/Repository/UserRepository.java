package com.example.demo.Repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private final List<Map<String, String>> users = new ArrayList<>();

    // Add user
    public void addUser(Map<String, String> user) {
        users.add(user);
    }

    // Get all users
    public List<Map<String, String>> getAllUsers() {
        return new ArrayList<>(users);
    }

    // Get user by index
    public Map<String, String> getUserById(int index) {
        if (index >= 0 && index < users.size()) {
            return users.get(index);
        }
        return null;
    }

    // Update user
    public void updateUser(int index, Map<String, String> user) {
        if (index >= 0 && index < users.size()) {
            users.set(index, user);
        }
    }

    // Delete user by index
    public void deleteUser(int index) {
        if (index >= 0 && index < users.size()) {
            users.remove(index);
        }
    }

    // Delete all users
    public void deleteAllUsers() {
        users.clear();
    }

    public int getUserCount() {
        return users.size();
    }
}

package com.example.demo.Service;

import org.springframework.stereotype.Service;
import com.example.demo.Repository.UserRepository;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(Map<String, String> user) {
        userRepository.addUser(user);
    }

    public List<Map<String, String>> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public Map<String, String> getUserById(int index) {
        return userRepository.getUserById(index);
    }

    public void updateUser(int index, Map<String, String> user) {
        userRepository.updateUser(index, user);
    }

    public void deleteUser(int index) {
        userRepository.deleteUser(index);
    }

    public void deleteAllUsers() {
        userRepository.deleteAllUsers();
    }

    public int getUserCount() {
        return userRepository.getUserCount();
    }
}

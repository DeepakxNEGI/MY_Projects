package com.MYprojectAppointmentSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.MYprojectAppointmentSys.exception.UserException;
import com.MYprojectAppointmentSys.modal.User;
import com.MYprojectAppointmentSys.repo.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Create user
    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    // Get all users
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long id) throws UserException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with ID: " + id));
    }

    // Update user
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) throws UserException {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setFullname(user.getFullname());
            existingUser.setEmail(user.getEmail());
            existingUser.setRole(user.getRole());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new UserException("User not found with ID: " + id));
    }

    // Delete user
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) throws UserException {
        if (!userRepository.existsById(id)) {
            throw new UserException("User not exist with ID: " + id);
        }
        userRepository.deleteById(id);
        return "User deleted";
    }
}
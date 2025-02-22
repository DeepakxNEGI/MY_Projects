package com.MYprojectAppointmentSys.controller;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.MYprojectAppointmentSys.exception.UserException;
import com.MYprojectAppointmentSys.modal.User;
import com.MYprojectAppointmentSys.repo.UserRepository;
import com.MYprojectAppointmentSys.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    
    private final UserService userService;

    // Create user
    @PostMapping
    public ResponseEntity <User> createUser(@RequestBody @Valid User user) {
        User createdUser= userService.createUser(user);
       return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
       }

    // Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long id) throws UserException {
        User user= userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
       }

    // Update user
    @PutMapping("/{id}")
    public  ResponseEntity<User>updateUser(@RequestBody User user, @PathVariable Long id) throws UserException {
        User updateUser= userService.updateUser(id,user);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteUserById(@PathVariable Long id) throws UserException {
       userService.deleteUser(id);
       return new ResponseEntity<>("user deleted",HttpStatus.ACCEPTED);
    }
}
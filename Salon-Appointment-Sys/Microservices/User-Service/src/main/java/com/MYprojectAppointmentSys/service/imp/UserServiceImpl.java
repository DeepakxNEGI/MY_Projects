package com.MYprojectAppointmentSys.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MYprojectAppointmentSys.exception.UserException;
import com.MYprojectAppointmentSys.modal.User;
import com.MYprojectAppointmentSys.repo.UserRepository;
import com.MYprojectAppointmentSys.service.UserService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
      private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
       return userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with ID: " + id));
     
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
       }

    @Override
    public void deleteUser(Long id) throws UserException {
        if (!userRepository.existsById(id)) {
            throw new UserException("User not exist with ID: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) throws UserException {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setFullname(user.getFullname());
            existingUser.setEmail(user.getEmail());
            existingUser.setRole(user.getRole());
            existingUser.setUsername(user.getUsername());

            return userRepository.save(existingUser);
        }).orElseThrow(() -> new UserException("User not found with ID: " + id));
    }


    
}

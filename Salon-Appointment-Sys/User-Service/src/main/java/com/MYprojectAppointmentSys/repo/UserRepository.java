package com.MYprojectAppointmentSys.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MYprojectAppointmentSys.modal.User;

public interface UserRepository extends JpaRepository<User ,Long > {

    
} 
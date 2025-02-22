package com.MYprojectAppointmentSys.modal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@NotBlank(message = "Full name is mandatory")
    //@Column(nullable = false)
    private String fullname;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String email;

   // @Column(unique = true)
    private String phone;

    private String role;

    @NotBlank(message = "Password is mandatory")
    @Column(nullable = false)
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String username;
 }

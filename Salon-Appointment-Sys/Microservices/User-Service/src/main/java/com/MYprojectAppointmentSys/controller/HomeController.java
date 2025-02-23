package com.MYprojectAppointmentSys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
public String HomeControllerHandler(){
    return "User microservice for salon booking system";
}
    
}

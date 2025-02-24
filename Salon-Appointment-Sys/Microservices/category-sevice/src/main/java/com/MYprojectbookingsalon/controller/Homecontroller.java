package com.MYprojectbookingsalon.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Homecontroller {
    @GetMapping

    public String HomecontrollerHandler() {
        return "Welcome to MYprojectbookingsalon";
    }
}

package com.MYprojectSalonMicro.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {

    @GetMapping
    public String HomeControllerHandler()
    {
        return "salon microserver for salon booking system";
    }
}

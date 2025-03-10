package com.MYproject.serviceOffering.payload;

import java.time.LocalTime;
import java.util.List;

import lombok.Data;
@Data
public class SalonDTO {
      private Long id;
    private String name;
    private List<String> images;
    private String address;
    private String phoneNumber;
    private String email;
    private String city;
    private Long ownerId;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String description;
    
}

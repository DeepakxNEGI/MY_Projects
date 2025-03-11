package com.MYprojectBookingservice.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Data;
@Data
public class BookingRequest {
    private LocalDateTime starTime;
    private LocalDateTime endTime;
    private Set<Long> serviceIds;
}

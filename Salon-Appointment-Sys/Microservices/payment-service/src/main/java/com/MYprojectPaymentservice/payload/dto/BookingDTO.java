package com.MYprojectPaymentservice.payload.dto;

import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;

@Data
public class BookingDTO {
    private Long id;
    private Long salonId;
    private Long customerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Set<Long> serviceIds;
    private int TotalPrice;
}

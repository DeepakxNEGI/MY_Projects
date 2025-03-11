package com.MYprojectBookingservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.MYprojectBookingservice.controller.modal.Booking;
import com.MYprojectBookingservice.domain.BookingStatus;
import com.MYprojectBookingservice.dto.BookingRequest;
import com.MYprojectBookingservice.dto.SalonDTO;
import com.MYprojectBookingservice.dto.ServiceDTO;
import com.MYprojectBookingservice.dto.UserDTO;

public interface BookingService {
    Booking createBooking(BookingRequest booking,
    UserDTO user,
    SalonDTO salon,
    Set<ServiceDTO> serviceDTOSet);

    List<Booking> getBookingsByCustomer(Long customerId);
    List<Booking> getBookingsBySalon(Long salonId);
    Booking getBookingsById(Long id);
    Booking updateBooking(Long bookingId ,BookingStatus status);
    List<Booking> getBookingsByDate(LocalDate date,Long salonId);



}

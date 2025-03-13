package com.MYprojectBookingservice.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.cglib.core.Local;

import com.MYprojectBookingservice.controller.modal.Booking;
import com.MYprojectBookingservice.domain.BookingStatus;
import com.MYprojectBookingservice.dto.BookingRequest;
import com.MYprojectBookingservice.dto.SalonDTO;
import com.MYprojectBookingservice.dto.ServiceDTO;
import com.MYprojectBookingservice.dto.UserDTO;
import com.MYprojectBookingservice.repo.BookingRepository;
import com.MYprojectBookingservice.service.BookingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    @Override
    public Booking createBooking(BookingRequest booking,
            UserDTO user,
            SalonDTO salon,
            Set<ServiceDTO> serviceDTOSet) throws Exception {
        int totalDuration = serviceDTOSet.stream().mapToInt(ServiceDTO::getDuration).sum();

        LocalDateTime bookingStartTime = booking.getStarTime();
        LocalDateTime bookingEndTime = bookingStartTime.plusMinutes(totalDuration);
        Boolean isSlotAvailable = isTimeSlotAvailable(salon, bookingStartTime, bookingEndTime);
        int totalPrice=serviceDTOSet.stream().mapToInt(ServiceDTO::getPrice).sum();
        Set<Long> idList =serviceDTOSet.stream().map(ServiceDTO::getId).collect(Collectors.toSet());
        Booking newBooking= new Booking();
        newBooking.setCustomerId(user.getId());
        newBooking.setSalonId(salon.getId());
        newBooking.setServiceIds(idList);
        newBooking.setStatus(BookingStatus.PENDING);
        newBooking.setStartTime(bookingStartTime);
        newBooking.setEndTime(bookingEndTime);
        newBooking.setTotalPrice(totalPrice);
        return bookingRepository.save(newBooking);
    }

    public Boolean isTimeSlotAvailable(SalonDTO salonDTO,
            LocalDateTime bookingStartTime,
            LocalDateTime bookingEndTime) throws Exception {
        List<Booking> existingBookings = getBookingsBySalon(salonDTO.getId());
        LocalDateTime salonOpenTime = salonDTO.getOpenTime().atDate(bookingStartTime.toLocalDate());
        LocalDateTime salonCloseTime = salonDTO.getOpenTime().atDate(bookingStartTime.toLocalDate());
        if (bookingStartTime.isBefore(salonOpenTime) || bookingEndTime.isAfter(salonCloseTime)) {
            throw new Exception("Booking time is outside salon working hours");

        }
        for (Booking existingBooking : existingBookings) {
            LocalDateTime existingBookingStartTime = existingBooking.getStartTime();
            LocalDateTime existingBookingEndTime = existingBooking.getEndTime();
            if (bookingStartTime.isBefore(existingBookingEndTime) && bookingEndTime.isAfter(existingBookingStartTime)) {
                throw new Exception("Booking time is overlapping with existing booking");
            }
            if (bookingStartTime.isEqual(existingBookingStartTime) || bookingEndTime.isEqual(existingBookingEndTime)) {
                throw new Exception("Booking time is overlapping with existing booking");
            }
            
        }
        return true;
    }

    @Override
    public List<Booking> getBookingsByCustomer(Long customerId) {
        return null;
    }

    @Override
    public List<Booking> getBookingsBySalon(Long salonId) {
        return null;
    }

    @Override
    public Booking getBookingsById(Long id) {
        return null;
    }

    @Override
    public Booking updateBooking(Long bookingId, BookingStatus status) {
        return null;
    }

    @Override
    public List<Booking> getBookingsByDate(LocalDate date, Long salonId) {
        return null;
    }

    @Override
    public SalonReport getSalonReport(Long salonId) {
        return null;
    }

    @Override
    public Booking updateBooking(Long bookingId, BookingStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBooking'");
    }

    @Override
    public List<Booking> getBookingsByDate(LocalDate date, Long salonId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingsByDate'");
    }

}

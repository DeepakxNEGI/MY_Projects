package com.MYprojectSalonMicro.service;
import com.MYprojectSalonMicro.payload.dto.SalonDTO;
import com.MYprojectSalonMicro.payload.dto.UserDTO;

import java.util.List;

import com.MYprojectSalonMicro.modal.Salon;
public interface SalonService {
  Salon createSalon(SalonDTO salonDTO, UserDTO user);
  Salon updateSalon(SalonDTO salon , UserDTO user, Long salonId) throws Exception;
List<Salon> getAllSalons();
Salon getSalonById(Long salonId) throws Exception;

Salon getSalonByOwnerId(Long ownerId);
List<Salon> searchSalonByCity(String city);
}

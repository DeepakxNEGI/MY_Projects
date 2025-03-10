package com.MYproject.serviceOffering.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MYproject.serviceOffering.Service.ServiceOfferingService;
import com.MYproject.serviceOffering.modal.ServiceOffering;
import com.MYproject.serviceOffering.payload.CategoryDTO;
import com.MYproject.serviceOffering.payload.SalonDTO;
import com.MYproject.serviceOffering.payload.ServiceDTO;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {
     private final ServiceOfferingService serviceOfferingService;
     
    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
        @RequestBody ServiceDTO serviceDTO
        ) {
            SalonDTO salonDTO = new SalonDTO();
            salonDTO.setId(1L);

            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(serviceDTO.getCategory());
            
            ServiceOffering serviceOfferings = serviceOfferingService.createService(salonDTO,serviceDTO, categoryDTO);
        return ResponseEntity.ok(serviceOfferings);

    }

         
    @PostMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(
        @PathVariable Long id,
        @RequestBody ServiceOffering serviceOffering
        ) throws Exception {
            SalonDTO salonDTO = new SalonDTO();
            salonDTO.setId(1L);
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(1L);
            ServiceOffering serviceOfferings = serviceOfferingService.updateService(id, serviceOffering);
        return ResponseEntity.ok(serviceOfferings);

    }

}

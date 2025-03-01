package com.MYproject.serviceOffering.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.MYproject.serviceOffering.Service.ServiceOfferingService;
import com.MYproject.serviceOffering.modal.ServiceOffering;
import com.MYproject.serviceOffering.payload.CategoryDTO;
import com.MYproject.serviceOffering.payload.SalonDTO;
import com.MYproject.serviceOffering.payload.ServiceDTO;
import com.MYproject.serviceOffering.repo.ServiceOfferingRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements ServiceOfferingService{
    private final ServiceOfferingRepository serviceOfferingRepository;
    @Override
    public ServiceOfferingService creaOfferingService(SalonDTO salonDTO, 
                                                     ServiceDTO serviceDTO,
                                                     CategoryDTO categoryDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creaOfferingService'");
    }

    @Override
    public ServiceOfferingService updateOfferingService(Long serviceId, ServiceOffering serviceOffering) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOfferingService'");
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySalonId(Long salonId, Long categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllServiceBySalonId'");
    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getServicesByIds'");
    }
    
}

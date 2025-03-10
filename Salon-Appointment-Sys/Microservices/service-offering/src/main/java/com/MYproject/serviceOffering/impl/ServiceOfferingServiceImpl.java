package com.MYproject.serviceOffering.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    public ServiceOffering createService(SalonDTO salonDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO) {
        ServiceOffering  serviceOffering = new ServiceOffering();
        serviceOffering.setImage(serviceDTO.getImage());
         serviceOffering.setSalonId(salonDTO.getId());
         serviceOffering.setName(serviceDTO.getName());
         serviceOffering.setPrice(serviceDTO.getPrice());
         serviceOffering.setDuration(serviceDTO.getDuration());
         serviceOffering.setCategoryId(categoryDTO.getId());
         serviceOffering.setDescription(serviceDTO.getDescription());
         return serviceOfferingRepository.save(serviceOffering);
        }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception {
      
        ServiceOffering serviceOffering = serviceOfferingRepository.findById(serviceId).
      orElse(null);
        if(serviceOffering != null) {
            throw new Exception("Service not exist with id "+serviceId);
        }
            serviceOffering.setImage(service.getImage());
            serviceOffering.setName(service.getName());
            serviceOffering.setPrice(service.getPrice());
            serviceOffering.setDuration(service.getDuration());
            serviceOffering.setDescription(service.getDescription());
            return serviceOfferingRepository.save(serviceOffering);
        }
    

    @Override
    public Set<ServiceOffering> getAllServiceBySalonId(Long salonId, Long categoryId) {
            Set <ServiceOffering>services=serviceOfferingRepository.
            findBySalonId(salonId);
            if(categoryId!=null){
                services=services.stream().filter((service)->service.getCategoryId()!=null && service.getCategoryId()==categoryId).collect(Collectors.toSet());
            }   
            return services;
    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        List <ServiceOffering> services =serviceOfferingRepository.findAllById(ids);
        return new HashSet<>(services);
    }

    @Override
    public ServiceOffering getServiceById(Long id) throws Exception {
   
        ServiceOffering serviceOffering = serviceOfferingRepository.findById(id).
        orElse(null);
          if(serviceOffering == null) {
              throw new Exception("Service not exist with id "+id);
          }
          return serviceOffering;
    }


    
}

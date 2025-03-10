package com.MYproject.serviceOffering.Service;
import java.util.Set;

import com.MYproject.serviceOffering.modal.ServiceOffering;
import com.MYproject.serviceOffering.payload.CategoryDTO;
import com.MYproject.serviceOffering.payload.SalonDTO;
import com.MYproject.serviceOffering.payload.ServiceDTO;

public interface ServiceOfferingService {
    

    ServiceOffering createService(SalonDTO salonDTO,
                                                ServiceDTO serviceDTO,
                                               CategoryDTO categoryDTO);
    ServiceOffering updateService(Long serviceId,ServiceOffering service) throws Exception;

    Set<ServiceOffering> getAllServiceBySalonId(Long salonId,Long categoryId);

    Set<ServiceOffering> getServicesByIds(Set<Long> ids);
    ServiceOffering getServiceById(Long id) throws Exception;
}

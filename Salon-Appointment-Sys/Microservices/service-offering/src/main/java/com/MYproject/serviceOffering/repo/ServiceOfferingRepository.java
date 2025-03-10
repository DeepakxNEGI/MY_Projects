package com.MYproject.serviceOffering.repo;

import java.util.Set;

import com.MYproject.serviceOffering.modal.ServiceOffering;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering, Long> {
    Set<ServiceOffering> findBySalonId(Long salonId);
    
}

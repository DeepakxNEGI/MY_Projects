package com.MYprojectPaymentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MYprojectPaymentservice.modal.PaymentOrder;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder,Long>{

    PaymentOrder findByPaymentLinkId(String paymentLinkId);
    
    
} 

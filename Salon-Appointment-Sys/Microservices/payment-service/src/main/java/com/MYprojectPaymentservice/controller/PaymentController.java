package com.MYprojectPaymentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MYprojectPaymentservice.payload.dto.BookingDTO;
import com.MYprojectPaymentservice.payload.dto.UserDTO;
import com.MYprojectPaymentservice.payload.response.PaymentLinkResponse;
import com.MYprojectPaymentservice.service.PaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentMethod;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(
            @RequestBody BookingDTO bookingDTO,
            @RequestParam PaymentMethod paymentMethod)
            throws StripeException, RazorpayException {
        UserDTO user = new UserDTO();
        user.setFullname("Rahul");
        user.setEmail("QGgT4@example.com");
        user.setId(null);
PaymentLinkResponse res = paymentService.createOrder(user, bookingDTO,null);

return ResponseEntity.ok(res);
    }

}
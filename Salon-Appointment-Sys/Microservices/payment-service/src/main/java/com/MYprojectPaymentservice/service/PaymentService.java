
package com.MYprojectPaymentservice.service;

import com.MYprojectPaymentservice.domain.PaymentMethod;
import com.MYprojectPaymentservice.modal.PaymentOrder;
import com.MYprojectPaymentservice.payload.dto.BookingDTO;
import com.MYprojectPaymentservice.payload.dto.UserDTO;
import com.MYprojectPaymentservice.payload.response.PaymentLinkResponse;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {

    PaymentLinkResponse createOrder(UserDTO user,
                                    BookingDTO booking,
                                    PaymentMethod paymentMethod) throws RazorpayException, StripeException;
    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    PaymentOrder getPaymentOrderByPaymentId(String paymentId);

    PaymentLink createRazorPaymentLink(UserDTO user,
                                    Long amount,
                                    Long orderId) throws RazorpayException;
    String createStripePaymentLink(UserDTO user,
                                    Long amount,
                                    Long orderId) throws StripeException;                                

                                }
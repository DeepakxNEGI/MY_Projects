package com.MYprojectPaymentservice.service.impl;

import org.apache.catalina.valves.JsonAccessLogValve;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.MYprojectPaymentservice.domain.PaymentMethod;
import com.MYprojectPaymentservice.modal.PaymentOrder;
import com.MYprojectPaymentservice.payload.dto.BookingDTO;
import com.MYprojectPaymentservice.payload.dto.UserDTO;
import com.MYprojectPaymentservice.payload.response.PaymentLinkResponse;
import com.MYprojectPaymentservice.repo.PaymentOrderRepository;
import com.MYprojectPaymentservice.service.PaymentService;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentOrderRepository paymentOrderRepository;
    @Value("${stripe.api.key}")
    private String stripeSecretkey;

    @Value("${razorpay.api.key}")
    private String razorpayApiKey;

    @Value("${razorpay.api.secret}")
    private String razorpayApiSecret;

    @Override
    public PaymentLinkResponse createOrder(UserDTO user,
            BookingDTO booking,
            PaymentMethod paymentMethod) throws RazorpayException {
        Long amount = (long) booking.getTotalPrice();
        PaymentOrder order = new PaymentOrder();
        order.setAmount(amount);
        order.setPaymentMethod(paymentMethod);
        order.setBookingId(booking.getId());
        order.setSalonId(booking.getSalonId());
        PaymentOrder savedOrder = paymentOrderRepository.save(order);

        PaymentLinkResponse paymentLinkResponse = new PaymentLinkResponse();

        if (paymentMethod.equals(PaymentMethod.RAZORPAY)) {
            PaymentLink payment = createRazorPaymentLink(user, savedOrder.getAmount(),
                    savedOrder.getId());
            String paymentUrl = payment.get("short_url");
            String paymentUrlId = payment.get("id");
            paymentLinkResponse.setPayment_Link_url(paymentUrl);
            paymentLinkResponse.setGetPayment_link_id(paymentUrlId);
            paymentOrderRepository.save(savedOrder);

        } else {
            String paymentUrl = createStripePaymentLink(user, savedOrder.getAmount(), savedOrder.getId());
            paymentLinkResponse.setPayment_Link_url(paymentUrl);
        }

        return paymentLinkResponse;

    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) throws Exception {
        PaymentOrder paymentOrder = paymentOrderRepository.findById(id).orElse(null);
        if (paymentOrder == null) {
            throw new Exception("payment order not found");
        }
        return paymentOrder;
    }

    @Override
    public PaymentOrder getPaymentOrderByPaymentId(String paymentId) {
        return paymentOrderRepository.findByPaymentLinkId(paymentId);
    }

    @Override
    public PaymentLink createRazorPaymentLink(UserDTO user,
            Long Amount,
            Long orderId) throws RazorpayException {

        Long amount = Amount * 100;

        RazorpayClient razorpay = new RazorpayClient(razorpayApiKey, razorpayApiSecret);

        JSONObject paymentLinkRequest =new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");

        JSONObject customer= new JSONObject();
        customer.put("name", user.getFullname());
        customer.put("email", user.getEmail());
        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("email", true);

        paymentLinkRequest.put("notify",notify);

        paymentLinkRequest.put("reminder_enable", true);

        paymentLinkRequest.put("callback_url","http://localhost:3000/payment-success/"+orderId);
        paymentLinkRequest.put("callback_method","get");

        return razorpay.paymentLink.create(paymentLinkRequest);
    }

    @Override
    public String createStripePaymentLink(UserDTO user, Long amount, Long orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createStripePaymentLink'");
    }

}

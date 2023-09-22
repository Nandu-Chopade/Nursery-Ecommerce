package com.nursery.payment;

public interface PaymentService {
    Payment createPayment(PaymentRequest request,  Long order);

    Payment getPaymentById(Long paymentId);

    // Add other payment-related methods as needed
}

package com.nursery.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    

	@Override
    public Payment createPayment(PaymentRequest request,  Long orderId) {
        
    	//TODO: payment process not working 
        return null;
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

 
}

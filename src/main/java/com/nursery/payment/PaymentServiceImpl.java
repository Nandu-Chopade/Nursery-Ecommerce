package com.nursery.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.order.Order;
import com.nursery.order.OrderRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    
    @Autowired
    private OrderRepository orederRepository;
    
    @SuppressWarnings("null")
	@Override
    public Payment createPayment(PaymentRequest request,  Long orderId) {
        
    	//TODO: payment process not working 
    	 Payment payment = null;
    			 payment.setPaymentMethod(request.getPaymentMethod());
    			 payment.setAmount(request.getAmount());
    			 payment.setPaymentDate(request.getPaymentDate());
    			 Order order = orederRepository.findById(orderId).get();
    			 payment.setOrder(order);
                 payment.setPaymentStatus(PaymentStatus.PENDING); // Set the initial payment status
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

 
}

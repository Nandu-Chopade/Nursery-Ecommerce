package com.nursery.order.items;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.order.details.OrderDetails;
import com.nursery.order.details.OrderDetailsRepository;
import com.nursery.payment.Payment;
import com.nursery.payment.PaymentMethod;
import com.nursery.payment.PaymentRepository;
import com.nursery.payment.PaymentStatus;
import com.nursery.product.model.Product;
import com.nursery.product.repository.ProductRepository;
import com.nursery.user.model.User;
import com.nursery.user.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository; 
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public List<OrderItemDTO> getUserOrders(Long id) {
	    User user = userRepository.findById(id).orElse(null);
	    
	    if (user == null) {
	        // Handle the case where the user is not found
	        return Collections.emptyList(); // Or throw an exception
	    }

//	    List<OrderItems> userOrders = orderRepository.findById(user.getId());

	    // Map Order entities to OrderDTO objects
//	    List<OrderItemDTO> orderDTOs = userOrders.stream()
//	            .map(order -> {
//	                OrderItemDTO orderDTO = new OrderItemDTO();
//	                orderDTO.setId(order.getId());
//	                orderDTO.setOrderDate(order.getOrderDate());
//	                return orderDTO;
//	            })
//	            .collect(Collectors.toList());

	    return null;
	}


	@Override
	public OrderItemDTO getOrderById(Long orderId) {
		return orderRepository.findById(orderId).map(order -> {
            OrderItemDTO orderDTO = new OrderItemDTO();
            orderDTO.setId(order.getId());
            orderDTO.setOrderDate(order.getOrderDate());
            return orderDTO;
        }).orElse(null);
		
		//TODO: work on null
	}
	
	

	@Override
	public OrderItems placeYourOrder(OrderItems order , Long productId , Long userId) {
		
		OrderDetails orderDetails = new OrderDetails();
		User user = userRepository.findById(userId).get();
		orderDetails.setUser(user);
		Product product = productRepository.findById(productId).get();
		Double price = product.getPrice();
		Integer quantity = order.getQuantity();
		Double total = price * quantity;
		orderDetails.setTotal(total);
		orderDetailsRepository.save(orderDetails);
		Payment payment = new Payment();
	    payment.setPaymentDate(new Date());
		payment.setAmount(total);
		payment.setPaymentMethod(PaymentMethod.CASH);
		payment.setPaymentStatus(PaymentStatus.PENDING);
		paymentRepository.save(payment);
		return  orderRepository.save(order);
	}
	
	

	@Override
	public List<OrderItemDTO> getAllOrders() {
		 return orderRepository.findAll().stream()
		            .map(order -> {
		                OrderItemDTO orderDTO = new OrderItemDTO();
		                orderDTO.setId(order.getId());
		                orderDTO.setOrderDate(order.getOrderDate());
		                return orderDTO;
		            })
		            .collect(Collectors.toList());
	}
	
	/**
	 * 
	
	@Autowired
    private PaymentService paymentService;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        // Process the order and calculate the total amount.
        // Create a PaymentRequest with the payment details.
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setPaymentMethod(orderRequest.getPaymentMethod());
        paymentRequest.setAmount(orderRequest.getTotalAmount());
        paymentRequest.setOrderId(orderRequest.getOrderId());

        // Use the PaymentService to process the payment.
        PaymentResponse paymentResponse = paymentService.processPayment(paymentRequest);

        // Handle the payment result, update the order status, and return the response.
        if (paymentResponse.isSuccess()) {
            // Payment successful, update order status, and complete the order.
            return new OrderResponse("Order placed successfully.");
        } else {
            // Payment failed, handle the error.
            return new OrderResponse("Payment failed: " + paymentResponse.getMessage());
        }
    }

 */               
}

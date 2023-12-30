package com.inm429.ecommerce.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inm429.ecommerce.Model.Cart;
import com.inm429.ecommerce.Model.Order;
import com.inm429.ecommerce.Repository.CartRepository;
import com.inm429.ecommerce.Repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private CartRepository cartRepository;

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }
    
    public Order createOrder(boolean shipped, int amount, Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));
        Order newOrder = new Order();
        newOrder.setShipped(shipped);
        newOrder.setAmount(amount);
        newOrder.setCart(cart);
        return orderRepository.save(newOrder);
    }

    public Order updateShippedStatus(Long orderId, boolean shipped) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setShipped(shipped);
            if(shipped) {
            	sendNotificationEmail(orderId);
            }
            return orderRepository.save(order);
        } else {
            throw new EntityNotFoundException("Order not found with id: " + orderId);
        }
    }

    public void deleteOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new EntityNotFoundException("Order not found with id: " + orderId);
        }
    }

    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        return optionalOrder.orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + orderId));
    }

    public List<Order> getOrdersByUserId(Long userId) {
    	List<Order> orderList = (List<Order>)orderRepository.findAll();
    	List<Order> resultList = new ArrayList<Order>();
    	for(Order order:orderList) {    		
    		if(order.getCart().getUser().getUserId() == userId) {
    			resultList.add(order);
    		}
    	}
    	return resultList;
    }
    
    public void sendNotificationEmail(Long orderId) {
    	Email email = EmailBuilder.startingBlank()
    		    .from("From", "ramkumardevadoss@gmail.com")
    		    .to("To", "ramkumardevadoss@gmail.com")
    		    .withSubject("Email Subject")
    		    .withPlainText("Email Body")
    		    .buildEmail();

		Mailer mailer = MailerBuilder
				.withSMTPServer("smtp.googlemail.com", 587, "ramkumardevadoss@gmail.com", "R12@k123@")
				.withTransportStrategy(TransportStrategy.SMTPS)
				.buildMailer();
		mailer.sendMail(email);

    }
}

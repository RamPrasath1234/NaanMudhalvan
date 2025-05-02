package com.nm.customer_orders.services;


import com.nm.customer_orders.model.Customer;
import com.nm.customer_orders.model.Order;
import com.nm.customer_orders.repository.CustomerRepository;
import com.nm.customer_orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Teja K
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getAllOrders() {
        List<Order> allOrders = orderRepository.findAll();
        return allOrders;
    }

    public Order saveOrder(Order order) {
        Order savedOrders = orderRepository.save(order);
        return savedOrders;
    }

    public ResponseEntity<String> deleteOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            orderRepository.deleteById(orderId);
            return ResponseEntity.ok("Order with ID " + orderId + " deleted successfully.");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order with ID " + orderId + " not found.");
        }

    }
}

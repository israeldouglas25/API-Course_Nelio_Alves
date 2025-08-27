package com.educandoweb.course.services;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.exceptions.NotFoundException;
import com.educandoweb.course.interfaces.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public ResponseEntity<Order> findById(UUID id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + id));
    }
}

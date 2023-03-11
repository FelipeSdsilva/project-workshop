package com.project.workshop.services;

import com.project.workshop.dto.OrderDTO;
import com.project.workshop.entities.Order;
import com.project.workshop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<OrderDTO> findAllOrder() {
        return repository.findAll().stream().map(OrderDTO::new).toList();
    }

    public OrderDTO findOrderById(Long id) {
        Order order = repository.findById(id).orElseThrow();
        return new OrderDTO(order);
    }
}

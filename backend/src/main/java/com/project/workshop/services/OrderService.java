package com.project.workshop.services;

import com.project.workshop.dto.OrderDTO;
import com.project.workshop.entities.Order;
import com.project.workshop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAllOrder() {
        return repository.findAll().stream().map(OrderDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public OrderDTO findOrderById(Long id) {
        Order order = repository.findById(id).orElseThrow();
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insertNewOrder(OrderDTO orderDTO) {
        Order order = new Order();
        converterDtoInEntity(orderDTO, order);
        order = repository.save(order);
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order order = repository.getReferenceById(id);
        converterDtoInEntity(orderDTO, order);
        order = repository.save(order);
        return new OrderDTO(order);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }

    private void converterDtoInEntity(OrderDTO orderDTO, Order order) {
        order.setMoment(orderDTO.getMoment().now());
        order.setStatus(orderDTO.getStatus());
    }
}

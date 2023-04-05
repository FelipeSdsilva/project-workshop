package com.project.workshop.services;

import com.project.workshop.dto.OrderDTO;
import com.project.workshop.entities.Order;
import com.project.workshop.repositories.OrderRepository;
import com.project.workshop.services.exceptions.DatabaseException;
import com.project.workshop.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            Order order = repository.getReferenceById(id);
            converterDtoInEntity(orderDTO, order);
            order = repository.save(order);
            return new OrderDTO(order);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void deleteOrder(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not Found " + id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity Violation");
        }

    }

    private void converterDtoInEntity(OrderDTO orderDTO, Order order) {
        order.setMoment(orderDTO.getMoment().now());
        order.setStatus(orderDTO.getStatus());
    }
}

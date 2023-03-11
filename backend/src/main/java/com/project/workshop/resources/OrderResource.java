package com.project.workshop.resources;

import com.project.workshop.dto.OrderDTO;
import com.project.workshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAllOrder() {
        List<OrderDTO> orderList = orderService.findAllOrder();
        return ResponseEntity.ok().body(orderList);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OrderDTO> findOrderById(@PathVariable Long id) {
        OrderDTO orderDto = orderService.findOrderById(id);
        return ResponseEntity.ok().body(orderDto);
    }
}

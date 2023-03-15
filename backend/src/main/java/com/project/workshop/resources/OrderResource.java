package com.project.workshop.resources;

import com.project.workshop.dto.OrderDTO;
import com.project.workshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<OrderDTO> newOrder(@RequestBody OrderDTO orderDTO) {
        orderDTO = orderService.insertNewOrder(orderDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(orderDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(orderDTO);
    }
}

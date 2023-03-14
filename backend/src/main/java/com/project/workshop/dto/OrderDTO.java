package com.project.workshop.dto;

import com.project.workshop.entities.Order;
import com.project.workshop.entities.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO implements Serializable {

    private Long id;
    private Instant moment;
    private OrderStatus status;

    private UserDTO client;

    private Set<OrderItemDTO> items = new HashSet<>();

    public OrderDTO(Long id, Instant moment, OrderStatus status, UserDTO client) {
        this.id = id;
        this.moment = moment;
        setStatus(status);
        this.client = client;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        setStatus(order.getStatus());
        this.client = new UserDTO(order.getClient());
    }


    public OrderStatus getStatus() {
        return OrderStatus.valueOf(String.valueOf(status));
    }

    public void setStatus(OrderStatus status) {
        this.status = OrderStatus.valueOf(status.getCode());
    }
}

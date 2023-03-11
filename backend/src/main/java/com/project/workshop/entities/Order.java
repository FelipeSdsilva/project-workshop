package com.project.workshop.entities;

import com.project.workshop.entities.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order(Long id, Instant moment, OrderStatus status, User client) {
        this.id = id;
        this.moment = moment;
        setStatus(status);
        this.client = client;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(String.valueOf(status));
    }

    public void setStatus(OrderStatus status) {
        if (status != null) {
            this.status = OrderStatus.valueOf(status.getCode());
        }
    }
}

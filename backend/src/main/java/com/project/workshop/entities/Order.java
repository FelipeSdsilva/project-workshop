package com.project.workshop.entities;

import com.project.workshop.entities.enums.OrderStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    private OrderStatus status;

}

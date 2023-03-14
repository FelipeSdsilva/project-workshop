package com.project.workshop.dto;

import com.project.workshop.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO implements Serializable {

    private ProductDTO productId;
    private OrderDTO orderId;
    private Double price;
    private Integer quantity;

    public OrderItemDTO(OrderDTO orderDTO, ProductDTO productDTO, Double price, Integer quantity) {
        setOrderId(orderDTO);
        setProductId(productDTO);
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemDTO(OrderItem orderItem) {
        this.orderId = new OrderDTO(orderItem.getOrder());
        this.productId = new ProductDTO(orderItem.getProduct());
        this.price = orderItem.getPrice();
        this.quantity = orderItem.getQuantity();
    }
}

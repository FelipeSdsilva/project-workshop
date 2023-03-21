package com.project.workshop.dto;

import com.project.workshop.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    private Set<CategoryDTO> categories = new HashSet<>();

    private Set<OrderItemDTO> items = new HashSet<>();

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();
    }

    public OrderDTO getOrders(){
        Set<OrderDTO> orders = new HashSet<>();
        for (OrderItemDTO itemDTO : items){
            orders.add(itemDTO.getOrderId());
        }
        return (OrderDTO) orders;
    }
}

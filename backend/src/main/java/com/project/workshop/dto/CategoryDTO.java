package com.project.workshop.dto;

import com.project.workshop.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Serializable {

    private Long id;
    private String name;

    private List<ProductDTO> products = new ArrayList<>();

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}

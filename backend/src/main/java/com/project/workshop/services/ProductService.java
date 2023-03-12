package com.project.workshop.services;

import com.project.workshop.dto.ProductDTO;
import com.project.workshop.entities.Product;
import com.project.workshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAllProduct() {
        return repository.findAll().stream().map(ProductDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO findProductById(Long id) {
        Product product = repository.findById(id).orElseThrow();
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO insertNewProduct(ProductDTO productDTO) {
        Product product = new Product();
        converterDtoInEntity(product, productDTO);
        product = repository.save(product);
        return new ProductDTO(product);
    }


    @Transactional
    public ProductDTO updateProductById(Long id, ProductDTO productDTO) {
        Product product = repository.getReferenceById(id);

        product = repository.save(product);
        return new ProductDTO(product);
    }

    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }

    private void converterDtoInEntity(Product product, ProductDTO productDTO) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(product.getPrice());
        product.setImgUrl(product.getImgUrl());
    }

}

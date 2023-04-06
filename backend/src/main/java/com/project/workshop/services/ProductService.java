package com.project.workshop.services;

import com.project.workshop.dto.ProductDTO;
import com.project.workshop.entities.Product;
import com.project.workshop.repositories.ProductRepository;
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
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAllProduct() {
        return repository.findAll().stream().map(ProductDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO findProductById(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
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
        try {
            Product product = repository.getReferenceById(id);

            product = repository.save(product);
            return new ProductDTO(product);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }

    }

    public void deleteProductById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violation Integrity");
        }

    }

    private void converterDtoInEntity(Product product, ProductDTO productDTO) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(product.getPrice());
        product.setImgUrl(product.getImgUrl());
    }

}

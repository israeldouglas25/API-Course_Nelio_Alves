package com.educandoweb.course.services;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.exceptions.ConflictException;
import com.educandoweb.course.exceptions.NotFoundException;
import com.educandoweb.course.interfaces.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    public ResponseEntity<Product> findById(UUID id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
    }

    public ResponseEntity<Product> save(Product product) {
        return ResponseEntity.ok(productRepository.save(product));
    }

    public ResponseEntity<Void> delete(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new NotFoundException("Product not found with id: " + id);
        }
        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException de) {
            throw new ConflictException(de.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

    /*
    A categoria de um produto não pode ser alterada diretamente pelo serviço, pois está representada como uma lista de categorias
    dentro do produto. Ou seja, um produto pode pertencer a várias categorias, mas a relação é gerenciada pela lista de
    categorias associada ao produto, e não por um campo único.
    */
    public ResponseEntity<Product> update(UUID id, Product productDetails) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(productDetails.getName() != null ? productDetails.getName() : product.getName());
                    product.setDescription(productDetails.getDescription() != null ? productDetails.getDescription() : product.getDescription());
                    product.setPrice(productDetails.getPrice() != null ? productDetails.getPrice() : product.getPrice());
                    product.setImageUrl(productDetails.getImageUrl() != null ? productDetails.getImageUrl() : product.getImageUrl());
                    Product updatedProduct = productRepository.save(product);
                    return ResponseEntity.ok(updatedProduct);
                })
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
    }
}

package com.educandoweb.course.services;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.exceptions.NotFoundException;
import com.educandoweb.course.interfaces.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.CacheRequest;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public ResponseEntity<Product> findById(UUID id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
    }

    public ResponseEntity<Product> save(Product product) {
        return ResponseEntity.ok(productRepository.save(product));
    }
}

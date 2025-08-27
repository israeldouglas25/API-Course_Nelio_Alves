package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.exceptions.NotFoundException;
import com.educandoweb.course.interfaces.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public ResponseEntity<Category> findById(UUID id) {
        return categoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Category not found with id: " + id));
    }
}

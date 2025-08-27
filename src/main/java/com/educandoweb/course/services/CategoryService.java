package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.exceptions.ConflictException;
import com.educandoweb.course.exceptions.NotFoundException;
import com.educandoweb.course.interfaces.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    public ResponseEntity<Category> findById(UUID id) {
        return categoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Category not found with id: " + id));
    }

    public ResponseEntity<Category> save(Category category) {
        URI uri = URI.create("/categories/" + category.getId());
        return ResponseEntity.created(uri).body(categoryRepository.save(category));
    }

    public ResponseEntity<Void> delete(UUID id) {
        if (!categoryRepository.existsById(id)) {
            throw new NotFoundException("Category not found with id: " + id);
        }
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException de) {
            throw new ConflictException(de.getMessage());
        }
        return ResponseEntity.noContent().build();
    }
}

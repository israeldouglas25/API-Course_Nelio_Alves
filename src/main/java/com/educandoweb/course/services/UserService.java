package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public ResponseEntity<User> findById(UUID id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> save(User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    public ResponseEntity<Void> delete(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> update(UUID id, User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userDetails.getName() != null ? userDetails.getName() : user.getName());
                    user.setEmail(userDetails.getEmail() != null ? userDetails.getEmail() : user.getEmail());
                    user.setPhone(userDetails.getPhone() != null ? userDetails.getPhone() : user.getPhone());
                    user.setPassword(userDetails.getPassword() != null ? userDetails.getPassword() : user.getPassword());
                    User updatedUser = userRepository.save(user);
                    return ResponseEntity.ok(updatedUser);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

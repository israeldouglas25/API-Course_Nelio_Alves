package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @EqualsAndHashCode.Include
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;

    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private Set<OrderItem> items = new HashSet<>();

    public Product(String name, String description, Double price, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product(String name, String description, Double price, String imageUrl, Set<Category> categories) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.categories = categories;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        Set<Order> orders = new HashSet<>();
        for (OrderItem item : items) {
            orders.add(item.getOrder());
        }
        return orders;
    }
}

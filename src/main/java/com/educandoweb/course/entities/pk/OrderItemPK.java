package com.educandoweb.course.entities.pk;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItemPK {

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

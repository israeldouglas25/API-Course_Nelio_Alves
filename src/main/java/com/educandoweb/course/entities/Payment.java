package com.educandoweb.course.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Payment {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private Instant moment;

    @OneToOne
    @MapsId
    private Order order;
}


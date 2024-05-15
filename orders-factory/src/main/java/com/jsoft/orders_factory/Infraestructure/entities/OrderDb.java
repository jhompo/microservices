package com.jsoft.orders_factory.Infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="orders",uniqueConstraints = {@UniqueConstraint(columnNames = "orderNumber")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique=true)
    String orderNumber;

    @OneToMany(mappedBy = "orderDb", cascade = CascadeType.ALL)
    List<OrderItemsDb> orderItem;

}

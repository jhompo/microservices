package com.jsoft.orders_factory.Domain.models;

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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique=true)
    String orderNumber;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<OrderItems> orderItem;

}

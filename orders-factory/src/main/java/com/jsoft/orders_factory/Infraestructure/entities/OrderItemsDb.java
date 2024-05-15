package com.jsoft.orders_factory.Infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemsDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String sku;
    Double price;
    long quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    OrderDb orderDb;

}

package com.jsoft.inventory_factory.Infraestructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InventoryDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String sku;

    private Long quantity;


}

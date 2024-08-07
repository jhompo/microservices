package com.jsoft.productsfactory.Domain.models;

import jakarta.persistence.*;
import lombok.*;
import java.lang.*;

@Entity
@Table(name="product", uniqueConstraints = {@UniqueConstraint(columnNames = "sku")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    String sku;

    String name;
    String description;
    long price;
    Boolean status;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
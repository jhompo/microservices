package com.jsoft.inventory_factory.Domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {

    long id;
    String sku;
    Double price;
    long quantity;

}

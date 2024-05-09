package com.jsoft.inventory_factory.Domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsRequest {

    long id;
    String sku;
    Double price;
    long quantity;
}

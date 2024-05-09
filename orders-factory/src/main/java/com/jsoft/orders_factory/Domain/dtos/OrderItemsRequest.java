package com.jsoft.orders_factory.Domain.dtos;

import com.jsoft.orders_factory.Domain.models.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

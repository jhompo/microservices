package com.jsoft.orders_factory.Domain.dtos;

import com.jsoft.orders_factory.Domain.models.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    List<OrderItemsRequest> orderItems;
}

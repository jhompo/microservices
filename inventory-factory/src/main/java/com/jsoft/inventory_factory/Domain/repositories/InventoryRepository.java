package com.jsoft.inventory_factory.Domain.repositories;

import com.jsoft.inventory_factory.Domain.dtos.DataResponse;
import com.jsoft.inventory_factory.Domain.dtos.OrderItemsRequest;
import com.jsoft.inventory_factory.Domain.models.Inventory;
import com.jsoft.inventory_factory.Domain.models.OrderItems;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository {
    boolean isInStock(String sku);

    DataResponse areInStock(List<OrderItemsRequest> orderItems);

    List<Inventory> all();
}

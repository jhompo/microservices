package com.jsoft.inventory_factory.Aplication;

import com.jsoft.inventory_factory.Domain.dtos.DataResponse;
import com.jsoft.inventory_factory.Domain.dtos.OrderItemsRequest;
import com.jsoft.inventory_factory.Domain.models.Inventory;
import com.jsoft.inventory_factory.Domain.models.OrderItems;
import com.jsoft.inventory_factory.Domain.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServices {

    @Autowired
    InventoryRepository inventoryRepository;


    public boolean isInStock(String sku){
        return inventoryRepository.isInStock(sku);
    }

    public DataResponse areInStock(List<OrderItemsRequest> orderItems){
        return inventoryRepository.areInStock(orderItems);
    }

    public List<Inventory> all() {
        return inventoryRepository.all();
    }
}

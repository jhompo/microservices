package com.jsoft.inventory_factory.Infraestructure.adapter;

import com.jsoft.inventory_factory.Domain.dtos.DataResponse;
import com.jsoft.inventory_factory.Domain.dtos.OrderItemsRequest;
import com.jsoft.inventory_factory.Domain.models.Inventory;
import com.jsoft.inventory_factory.Domain.models.OrderItems;
import com.jsoft.inventory_factory.Domain.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InventoryImpl implements InventoryRepository {

    @Autowired
    InventoryMysql  inventoryMysql;


    @Override
    public boolean isInStock(String sku) {
        var inventory = inventoryMysql.findBySku(sku);

        return inventory.filter(item -> item.getQuantity() > 0).isPresent() ;
    }

    @Override
    public DataResponse areInStock(List<OrderItemsRequest> orderItems) {
        var errorList = new ArrayList<String>();

        List<String> skus = orderItems.stream().map(OrderItemsRequest::getSku).toList();
        List<Inventory> inventoryList =  inventoryMysql.findBySkuIn(skus);

        orderItems.forEach(item->{
            var inventory = inventoryList.stream().filter(fil-> fil.getSku().equals(item.getSku())).findFirst();
            if (inventory.isEmpty()) {
                errorList.add("Product with sku " + item.getSku() + " does not exist");
            } else if (inventory.get().getQuantity() < item.getQuantity()) {
                errorList.add("Product with sku " + item.getSku() + " has insufficient quantity");
            }
        });

        return errorList.size()>0 ? new DataResponse(errorList.toArray(new String[0])) : new DataResponse(null);
    }

    @Override
    public List<Inventory> all() {
        return inventoryMysql.findAll();
    }
}

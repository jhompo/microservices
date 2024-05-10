package com.jsoft.inventory_factory.Infraestructure;

import com.jsoft.inventory_factory.Aplication.InventoryServices;
import com.jsoft.inventory_factory.Domain.dtos.DataResponse;
import com.jsoft.inventory_factory.Domain.dtos.OrderItemsRequest;
import com.jsoft.inventory_factory.Domain.models.Inventory;
import com.jsoft.inventory_factory.Domain.models.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryServices inventoryServices;


    @GetMapping("")
    public List<Inventory> all(){
        return inventoryServices.all();
    }


    @GetMapping("/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku") String sku) {
        return inventoryServices.isInStock(sku);
    }

    @PostMapping("/in-stock")
    @ResponseStatus(HttpStatus.OK)
    public DataResponse areInStock(@RequestBody List<OrderItemsRequest> orderItems) {
        return inventoryServices.areInStock(orderItems);
    }



}

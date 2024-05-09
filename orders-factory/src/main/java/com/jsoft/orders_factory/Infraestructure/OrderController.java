package com.jsoft.orders_factory.Infraestructure;


import com.jsoft.orders_factory.Aplication.OrderServices;
import com.jsoft.orders_factory.Domain.dtos.OrderItemsRequest;
import com.jsoft.orders_factory.Domain.dtos.OrderRequest;
import com.jsoft.orders_factory.Domain.models.Order;
import com.jsoft.orders_factory.Domain.models.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderServices orderServices;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderRequest orderRequest) {
        orderServices.create(orderRequest);
        return "Order placed successfully";
    }


    @GetMapping("")
    public List<Order> AllOrder() {
        return orderServices.all();
    }

    @GetMapping("/{id}")
    public List<Order> findOrderById(@PathVariable int id) {
        return orderServices.all();
    }

}

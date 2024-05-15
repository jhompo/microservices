package com.jsoft.orders_factory.Infraestructure.adapter;

import com.jsoft.orders_factory.Domain.models.Order;
import com.jsoft.orders_factory.Domain.models.OrderItems;
import com.jsoft.orders_factory.Domain.repository.OrderRepository;
import com.jsoft.orders_factory.Infraestructure.entities.OrderDb;
import com.jsoft.orders_factory.Infraestructure.entities.OrderItemsDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrdemImpl implements OrderRepository {

    @Autowired
    OrderMysql orderMysql;

    @Override
    public Order save(Order order) {

        OrderDb orderDb = OrderDb.builder().id(order.getId())
                .orderNumber(order.getOrderNumber())
                .orderItem(order.getOrderItem().stream().map(this::itemsToItemsDb).toList())
                .build();

        orderMysql.save(orderDb);

        return (order);
    }



    @Override
    public List<Order> all() {
        List<OrderDb> listOrder =orderMysql.findAll();
        return  listOrder.stream().map(this::orderDbToOrder).toList();
    }

    @Override
    public Optional<Order> findById(Long id) {
        Optional<OrderDb> listOrder = orderMysql.findById(id);
        return listOrder.stream().map(this::orderDbToOrder).findFirst(); //Optional.of(;
    }


    public Order orderDbToOrder(OrderDb item){
        return  Order.builder()
                .id(item.getId())
                .orderNumber(item.getOrderNumber())
                .orderItem(item.getOrderItem().stream().map(this::itemsDbToItems).toList())
                .build();
    }

    private OrderItemsDb itemsToItemsDb(OrderItems orderItems) {
        return OrderItemsDb.builder()
                .id(orderItems.getId())
                .sku(orderItems.getSku())
                .price(orderItems.getPrice())
                .quantity(orderItems.getQuantity())
                .build();

    }

    private OrderItems itemsDbToItems(OrderItemsDb orderItems) {
        return OrderItems.builder()
                .id(orderItems.getId())
                .sku(orderItems.getSku())
                .price(orderItems.getPrice())
                .quantity(orderItems.getQuantity())
                .build();
    }

}

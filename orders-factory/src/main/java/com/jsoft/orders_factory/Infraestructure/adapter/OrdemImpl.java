package com.jsoft.orders_factory.Infraestructure.adapter;

import com.jsoft.orders_factory.Domain.models.Order;
import com.jsoft.orders_factory.Domain.repository.OrderRepository;
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
        return orderMysql.save(order);
    }

    @Override
    public List<Order> all() {
        return orderMysql.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderMysql.findById(id);
    }
}

package com.jsoft.orders_factory.Domain.repository;

import com.jsoft.orders_factory.Domain.models.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository {

    Order save(Order order);
    List<Order> all();
    Optional<Order> findById(Long id);
}

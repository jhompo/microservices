package com.jsoft.orders_factory.Infraestructure.adapter;

import com.jsoft.orders_factory.Domain.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrderMysql extends JpaRepository<Order, Long> {
}

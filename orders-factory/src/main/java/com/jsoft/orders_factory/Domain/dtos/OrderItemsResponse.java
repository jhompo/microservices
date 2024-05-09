package com.jsoft.orders_factory.Domain.dtos;

public record OrderItemsResponse(Long id, String sku, Double price, Long quantity) {
}
